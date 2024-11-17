import Excepions.AllProgrammersAreBusyNowException;
import Excepions.TeamLeadUnavailableNowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TeamLeadTest {
    private TeamLead teamLead;
    Programmer jack;
    Programmer john;


    @BeforeEach
    void setUp() {
        jack = new Programmer("Jack");
        john = new Programmer("John");
        teamLead = new TeamLead("Lena", TeamLeadStatus.AVAILABLE, List.of(jack, john));

    }

    @Test
    void testToString() {
        String expectedResult = "Lena (AVAILABLE)  programmers=[Jack(AVAILABLE), John(AVAILABLE)]";
        Assertions.assertEquals(expectedResult, teamLead.toString());
    }


    private static Stream<Arguments> setStatusTest_Argument(){
        Arguments argumentsSet1 = Arguments.of(TeamLeadStatus.UNAVAILABLE, "Lena (UNAVAILABLE)  programmers=[Jack(AVAILABLE), John(AVAILABLE)]");
        Arguments argumentsSet2 = Arguments.of(TeamLeadStatus.AVAILABLE, "Lena (AVAILABLE)  programmers=[Jack(AVAILABLE), John(AVAILABLE)]");
        return Stream.of(argumentsSet1,argumentsSet2);
    }

    @ParameterizedTest
    @MethodSource("setStatusTest_Argument")
    void setStatus(TeamLeadStatus status, String expectedResult) {
        jack.setAvailable();
        john.setAvailable();
        teamLead.setStatus(status);

        Assertions.assertEquals(expectedResult, teamLead.toString());
    }

    @Test
    void doTask_allProgrammersAvailable_TaskDone() {
        jack.setAvailable();
        john.setAvailable();
        teamLead.setStatus(TeamLeadStatus.AVAILABLE);

        String actualResult = teamLead.doTask("text of task");
        String expectedResult = "TEXT OF TASK";

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void doTask_anyProgrammerAvailable_TaskDone() {
        jack.setUnavailable();
        john.setAvailable();
        teamLead.setStatus(TeamLeadStatus.AVAILABLE);

        String actualResult = teamLead.doTask("text of task");
        String expectedResult = "TEXT OF TASK";

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void doTask_programmerUnavailable_AllProgrammersAreBusyNowException() {
        jack.setUnavailable();
        john.setBusy();
        teamLead.setStatus(TeamLeadStatus.AVAILABLE);
        Assertions.assertThrows(AllProgrammersAreBusyNowException.class, () -> teamLead.doTask("text of task"));
    }

    @Test
    void doTask_programmersAndTeamLeadUnavailable_TeamLeadUnavailableNowException() {
        jack.setUnavailable();
        john.setBusy();
        teamLead.setStatus(TeamLeadStatus.UNAVAILABLE);
        Assertions.assertThrows(TeamLeadUnavailableNowException.class, () -> teamLead.doTask("text of task"));
    }

    @Test
    void doTask_programmersAvailableButTeamLeadUnavailable_TeamLeadUnavailableNowException() {
        jack.setAvailable();
        john.setAvailable();
        teamLead.setStatus(TeamLeadStatus.UNAVAILABLE);
        Assertions.assertThrows(TeamLeadUnavailableNowException.class, () -> teamLead.doTask("text of task"));
    }


}