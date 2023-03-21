package Backup.Users;
public class Supervisor extends User{
    
    private String supervisorID;

    public Supervisor(){
        this.supervisorID = super.getUserID;
    }

    public String getSupervisorID(){
        return this.supervisorID;
    }
}