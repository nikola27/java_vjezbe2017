import java.io.*;
import java.util.ArrayList;
public class TechnicalLead extends TechnicalEmployee {
    private int headCount = 4;
    private double baseSalary = 0.00;
    private ArrayList<SoftwareEngineer> team = new ArrayList<>();
    private int totalCheckIns = 0;

    // Create a new TechnicalLead that is a Manager. The TechnicalLead's base salary should be 1.3 times that of a
    // TechnicalEmployee. TechnicalLeads should have a default head count of 4.
    public TechnicalLead(String name) {
        super(name);
        this.baseSalary = super.getBaseSalary() * 1.3;
    }

    // Should return true if the number of direct reports this manager has is less than their head count.
    public boolean hasHeadCount() {
        if (team.size() < headCount) { return true; }
        else { return false; }
    }

    // Should accept the reference to a SoftwareEngineer object, and if the TechnicalLead has head count left
    // should add this employee to their list of direct reports. If the employee is successfully added to the
    // TechnicalLead's direct reports true should be returned, false should be returned otherwise.
    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount()) {
            team.add(e);
            e.setManager(this);
            return true;
        } else {
            return false;
        }
    }

    // Should see if the employee passed in does report to this manager and if their code access is currently set
    // to "true". If both those things are true, true is returned, otherwise false is returned.
    public boolean approveCheckIn(SoftwareEngineer e) {
        if ((team.contains(e)) && (e.getCodeAccess())) { this.totalCheckIns++; return true; }
        else { return false; }
    }

    // Should check if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead.
    // If it is, that employee should get that bonus and true should be returned. False should be returned otherwise.
    public boolean requestBonus(Employee e, double bonus) {
        return false;
    }

    // Should return a String that gives insight into this Manager and all their direct reports. It should return a
    // string that is a combination of the TechnicalLead's employee status followed by each of their direct employee's
    // status on subsequent lines. If the TechnicalLead has no reports it should print their employee status followed
    // by the text " and no direct reports yet". Example: "10 Kasey has 5 successful check ins and no direct reports
    // yet". If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins
    // and is managing: /n Niky has 2 successful check ins"
    public String getTeamStatus() {
        String outputString = "";
        outputString += this.ID + " ";
        outputString += this.getName() + " ";
        outputString += "has ";
        outputString += this.totalCheckIns + " successful check ins";
        if (team.size() > 0) {
            outputString += ", and is managing:";
            for (int i = 0; i < team.size(); i++) {
                outputString += "\n \t" + team.get(i).employeeStatus();
            }
        } else {
            outputString += " and no direct reports yet.";
        }
        return outputString;
    }

    // Custom method so Accountant can get reporting Software Engineers' salaries.
    public double getSalaries() {
        double monies = 0.0;
        for (int i = 0; i < this.team.size(); i++) {
            monies += team.get(i).getBaseSalary();
        }
        return monies;
    }

}
