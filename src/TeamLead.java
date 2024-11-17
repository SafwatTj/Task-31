import Excepions.AllProgrammersAreBusyNowException;
import Excepions.TeamLeadUnavailableNowException;

import java.util.List;

public class TeamLead {
    private String name;
    private TeamLeadStatus status;
    private List<Programmer> programmers;

    public TeamLead(String name, TeamLeadStatus status, List<Programmer> programmers) {
        this.name = name;
        this.status = status;
        this.programmers = programmers;
    }

    @Override
    public String toString() {
        return name + " (" + status + ") " + " programmers=" + programmers;
    }

    public void setStatus(TeamLeadStatus status) {
        this.status = status;
    }

    public String doTask(String taskMsg){
        if (status.equals(TeamLeadStatus.UNAVAILABLE)){
            throw new TeamLeadUnavailableNowException();
        }

        for (Programmer programmer:programmers){
            try{
                return programmer.doWork(taskMsg);
            } catch (Exception e){
                System.out.println(programmer);
            }
        }
        throw new AllProgrammersAreBusyNowException();
    }

}
