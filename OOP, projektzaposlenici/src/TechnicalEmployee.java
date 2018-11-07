import java.io.*;
//izlgeda da se može ovako povezivati klase preko ovog extends, a imam prije gdje sam upisiovo ovo import java.io.*
public class TechnicalEmployee extends Employee {
    private int checkIns = 0;

    //postavljanej default bazne plaće na 75000, preko objekta ime stavlja se bazna plaća
    public TechnicalEmployee(String name){
        super(name, 75000.00);
    }
    // Should return a String representation of this TechnicalEmployee that includes their ID, name and how many
    // successful check ins they have had. Example: "1 Kasey has 10 successful check ins"
    public String employeeStatus(){
        return super.employeeStatus() + "has " + this.checkIns + " successful check ins ";

    }

}

