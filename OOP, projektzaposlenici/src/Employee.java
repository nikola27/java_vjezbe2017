import java.io.*;
public class Employee {
    public String name = "";
    public double salary ;
    public static int employeeID = 0;
    public int ID = 0;
    public Employee boss;
    public String status = "";

    //konstruktor za objekt novog zaposl koji uzima ime i plaću
    //dodali smo da ID dodaje za svaki upisani novi jedan broj, ovo employeeID++
    public Employee(String name, double baseSalary){
        this.name = name;
        this.salary = baseSalary;
        employeeID++;
        this.ID = employeeID;

    }
    //vraća plaću
    public double getBaseSalary(){
        return salary;
    }
    //vraća ime upisano
    public String getName(){
        return name;
    }
    //vraća ID zaposlenika, koji će ici plus jedan za svaki upisani ID gore ovo što smo stavili++
    public int getEmployeeID(){
        return this.ID;

    }
    //vraća ime šefa zaposlenika
    public Employee getManager(){
        return this.boss;
    }
    //mutator instaliramo da možemo upisati ime šefa tom zaposleniku
    public void setManager(Employee name){
        this.boss = name;
    }
    //vraća ispis ako su isti ID od zaposlenika
    public boolean equals(Employee other){
        if(this.ID == other.ID){
            return true;
            } else {
            return false;
        }
    }
    // vraća ispis id s imenom zaposlenika, pod bavodnicima je razma samo da bude 1 ime
    public String toString(){
        return this.ID + " " + this.name;
    }
    //vraća status za svakog zaposlenika
    public String employeeStatus(){
        return this.status;
    }

}
