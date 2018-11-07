package StudentDatabaseApp;

import java.util.Scanner;

public class Student {
    //treba pogledat koji parametri trebaju za neki program, ime prezime, neke definirane stvari itd
    //označiti si koje metode treba napravit u komentarima, kao etape šta će trebati, prije nego se krene sa pisanje koda

    private String firstName;
    private String lastName;
    private int gradeYear;
    private String studentID;
    private String courses= "";//neke varijable ne znamo odmah, već s pisanjem koda dolazimo 
//toga da su nam potrebene pa ih definiramo
    private int tuitionBalance = 0;
    private static int costOfCourse = 600;//static se koristi u cijeloj klasi ako je ovdje naznaceno ovako, znači ova vrijednost u cijeoj klasi
    private static int id= 1000;





    //konstruktor upisivanje imena i godine
    public Student(){
        //treba nam upisivanje  die scnnner
        Scanner in = new Scanner(System.in);
        System.out.print("upisi ime studenta: ");
        this.firstName = in.nextLine();

        System.out.print("upisi prezime studenda: ");
        this.lastName = in.nextLine();

        System.out.print("1- freshman \n2- sophmore\n3- junior\n4- senior\n Enter student class level: ");
        this.gradeYear = in.nextInt();
        setStudentID();
        System.out.println(firstName+ " " + lastName+ " " +gradeYear+ " " + studentID);



    }


    // generiaranje ID
        private void setStudentID(){
        //grade level + id

            id++;//dodaoje svakom novom studentu plus 1
            this.studentID =  gradeYear + "" + id;//zbog ovih navodnika prelazi u string, ova varijabla može biti string iako je broj onda
        }

    // upisivanje u course
        public void enroll() {

        //pravimo petlju da radi sve dok ne uzimamo više courseva, kad stisnemo Q

            do {
                System.out.print("enter course to enroll(Q to quit)");
                Scanner in = new Scanner(System.in);
                String course = in.nextLine();
                if (!course.equals("Q")) {
                    courses = courses + "\n" + course;
                    tuitionBalance = tuitionBalance + costOfCourse;
                } else {
                    break;
                }
            } while (1 != 0);//ovo je da se vrti beskonačno
        //ovo sve možemo brisati da se ne vidi, već samo info i tako ima par stvari koje možemo mjenjati
                System.out.println("enrolled in: "+ courses);
                System.out.println("tuition balance: "+ tuitionBalance);
            }


            //balance
    public void viewBalance(){
        System.out.println("your balance is :"+ tuitionBalance );
    }


    //pay tuition
    //public void payTuition(int payment) kada imamo unaprijed upisano koliko je placeno
    public void payTuition(){
        viewBalance();//da vidimo kolko imamo
        System.out.println("upisi kolko je uplaceno");
        Scanner in = new Scanner(System.in);
        int payment = in.nextInt();
        tuitionBalance = tuitionBalance - payment;
        System.out.println("thank you for your paxment of " + payment);
        viewBalance();

    }

    // možemo brisati stvari koje ne želimo da se vide, samo ono što treba, možda samo ovo na kraju
    //show status
    public String toString (){
        return "name: " + firstName+ " "+ lastName+
                "\ngrade " + gradeYear+
                "\n id: " + id +
                "\nCourses enrolled: "+ courses+
                "\nbalance: "+ tuitionBalance;

    }


}
