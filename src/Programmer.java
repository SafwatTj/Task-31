import Excepions.ProgrammerBusyException;
import Excepions.ProgrammerUnavailableNowException;

public class Programmer {

    private String name;
    private ProgrammerStatus status;

    /*
    private final static String AVAILABLE_STATUS = "доступен";
    private final static String UNAVAILABLE_STATUS = "не доступен";
    private final static String  BUSY_STATUS = "занят";
     */

    public Programmer(String name) {
        this.name = name;
        this.status = ProgrammerStatus.AVAILABLE;
    }

    public Programmer(String name, ProgrammerStatus programmerStatus) {
        this.name = name;
        this.status = programmerStatus;
    }



    public void setAvailable() {
        this.status = ProgrammerStatus.AVAILABLE;
    }
    public void setUnavailable() {
        this.status = ProgrammerStatus.UNAVAILABLE;
    }
    public void setBusy() {
        this.status = ProgrammerStatus.BUSY;
    }

    @Override
    public String toString() {
        return name + "("+ status + ")";
    }

    public String doWork(String msg){
        if (status.equals(ProgrammerStatus.UNAVAILABLE)){
            throw new ProgrammerUnavailableNowException();
        }
        if (status.equals(ProgrammerStatus.BUSY)){
            throw new ProgrammerBusyException();
        }
        if (msg==null){
            return "";
        }
        return msg.toUpperCase();
    }

}
