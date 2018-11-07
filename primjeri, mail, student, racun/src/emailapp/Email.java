package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;//za random passw, dodajemo ovaj paremetar
    private int mailboxCapacity = 500;
    private String companySuffix = "firma.hr";
    private String alternateEmail;

    //constructor to revieve first name anad last name
    //gore se moraju slagati parametri koje korisitmi kasinje u konstruktoru, znači sve ove varijable se prvo gore navedu
    // ne ide sve po redu u kodu ovom, znači pisao sam kod dolje izvan konstruktora da dođem do ovih parametara, npr da genenrira neku mail pa smo to ovdje koristili
    //znači treba prvo napisat kako nešto ide i ovdje to koristimo u konstrukotru, iznad varijable dodajemo svakom konstruktoru, inače neće radit ako nije naznačena, default ili ako ima neka vrijednost
// gore su klasne varijable, imamo lokallne koje koristimo
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        // ovo nam više ne treba jer imamo dolje u info, pa se može brisati, ostavit ću ovo za primjer iskomentirano  System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);
//metoda koja traži koji je odjel department i da vrati koji je
        this.department = setDepartment();
       // System.out.println("Department: " + this.department);

        //zovi metodu koja vraća random lozinku pass
        this.password = randomPassword(defaultPasswordLength);// dužina pass koji će se generirati, metoda je randompassword
        System.out.println("your password : "+ this.password);

        //spajanje elemenata da geneeriramo novu email adresu, mala slova moraju bit sva, fiukncija to.lovercase, zovemo sve varijable, npr company smo dali vrijednost firme
        email = firstName.toLowerCase()+ "." + lastName.toLowerCase()+ "@" + department + "." + companySuffix;
        //System.out.println("your email is: "+ email);
    }


    // ask for the departmene
    private String setDepartment(){
        System.out.print("NEW WORKER NAME:"+firstName+ " -DEPARTMENT CODES\n1 for sales\n2 for development\n3 accounting\n0 for none department code:  ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1){return "sales";}
        else if (depChoice ==2){return "dev";}
        else if (depChoice == 3){ return "acct";}
        else {return "";}


    }
    // generate random password
  //iz stribga passwird će uzetu random znamenke i napisati neki password
    private String randomPassword(int length){// legth možemo mjenjati, tolka je dužina pass
    String passwordSet = "ABCDEFGHIJLKMNOPRSTUVZ!$%&";
    char[] password = new char[length];//pravimo array slova veličine length tj tako se zove array
    for (int i = 0; i < length; i++){
        int rand = (int) (Math.random() * passwordSet.length());
        password[i] = passwordSet.charAt(rand);
        }
        return new String(password) ;//string jer su slova
    }


    //sett the mailbox capacity, set metode da definiramo
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;// enkapsulacija
    }
    // set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change the password
    public void changePassword(String password){
        this.password = password ;
    }
    //metode pomoću kojih komnuciramo sa set ove tri gore, mjenjamo stvari u glavnoj klasi, ima pr tamo
    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){ return password;}

    // metoda koja će nam izbacit info o svemu, vraća string sa informacijama
    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
               //\n da ide u novi red
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY : " + mailboxCapacity + "mb" ;
    }

}
