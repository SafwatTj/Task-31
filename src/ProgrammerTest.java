import Excepions.ProgrammerBusyException;
import Excepions.ProgrammerUnavailableNowException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProgrammerTest {

    @Test
    void doWork_ifStatusAvailable_returnMsgUpperCase() {
        Programmer programmer = new Programmer("Jack");
        programmer.setAvailable();

        String actualResult = programmer.doWork("hello java");
        String expectedResult = "HELLO JAVA";

        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void doWork_ifStatusUnavailable_throwProgrammerUnavailableNowException() {
        Programmer programmer = new Programmer("Jack");
        programmer.setUnavailable();

        Assertions.assertThrows(ProgrammerUnavailableNowException.class, ()->programmer.doWork("hello java") );
    }
    @Test
    void doWork_ifStatusBusy_throwProgrammerBusyException() {
        Programmer programmer = new Programmer("Jack");
        programmer.setBusy();

        Assertions.assertThrows(ProgrammerBusyException.class, ()->programmer.doWork("hello java") );
    }

    @Test
    void doWork_ifStatusAvailableAndValueNull_returnEmptyString() {
        Programmer programmer = new Programmer("Jack");
        programmer.setAvailable();

        String actualResult = programmer.doWork(null);
        String expectedResult = "";

        Assertions.assertEquals(expectedResult,actualResult);
    }

}