import java.io.*;
public class SoftwareEngineer extends TechnicalEmployee {
    // Should start without access to code and with 0 code check ins.
    private boolean codeAccess = false;
    private int checkIns = 0;
    public SoftwareEngineer(String name){
        super(name);

    }
    // Should return whether or not this SoftwareEngineer has access to make changes to the code base.
    public boolean getCodeAccess(){
        return this.codeAccess;
    }
    // Should allow an external piece of code to update the SoftwareEngineer's code privileges to either true or false.
    public void setCodeAccess(boolean access){
        if (access) {
            this.codeAccess = true;
        } else {
            this.codeAccess = false;
        }
    }
    // Should return the current count of how many times this SoftwareEngineer has successfully checked in code.
    public int getSuccessfulCheckIns(){
        return this.checkIns;
    }
    // Should check if this SoftwareEngineer's manager approves of their check in. If the check in is approved their
    // successful checkin count should be increased and the method should return "true". If the manager does not
    // approve the check in the SoftwareEngineer's code access should be changed to false and the method should
    // return "false".


    public boolean checkInCode() {
        // Need to verify if manager approves checkIn. Return true and increment checkIns by 1. Else, false.
        TechnicalLead manager = (TechnicalLead)this.getManager();
        if (manager.approveCheckIn(this)) {
            checkIns++;
            return true;
        } else {
            if (codeAccess) { codeAccess = false; }
            return false;
        }
    }

    public String employeeStatus() {
        return this.ID + " " + this.getName() + " has " + this.checkIns + " successful check ins.";
    }



}
