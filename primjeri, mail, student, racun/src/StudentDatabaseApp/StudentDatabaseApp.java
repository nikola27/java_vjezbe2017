package StudentDatabaseApp;

import java.util.Scanner;

public class StudentDatabaseApp {
    public static void main(String[] args){
      //  Student stu1 = new Student();
        //stu1.enroll();
        //stu1.payTuition(500);//ovdje možemo upisat preko paymnet ali možemo i tražit da se upiše
        //stu1.payTuition();
        //System.out.println(stu1.toString());


        //pitati koliko korisnika dodati želimo
        System.out.println(" koliko studenata? ");
        Scanner in = new Scanner(System.in);
        int numOfStudents = in.nextInt();
        Student[] students =  new Student[numOfStudents];

        //create n number of new students
        //pravimo niz jer je lakse tako za ispisivanje
        //da ne pisemo za svakomg kod, več ovako odredimo koliko ili smo upisujemo ako nismo odredili
        // umjesto n neki broj koliko že ih ići tj koliko će biti niz ili array
        for (int n = 0; n<numOfStudents;n++){
            students[n] = new Student();
            students[n].enroll();
            //stu1.payTuition(500);//ovdje možemo upisat preko paymnet ali možemo i tražit da se upiše
            students[n].payTuition();
            System.out.println(students[n].toString());

        }
       // ovo je za kad unosimo posebno kolko smo odredili i izbaci nam inf
        // System.out.println(students[0].toString());
        //System.out.println(students[1].toString());
    }

}
