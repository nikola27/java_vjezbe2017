import java.util.Scanner;
public class TripPlanner {
    public static void main (String[] args)
    {
        part1();
        part2();
        part3();
        part4();
    }


        public static void part1()
        {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to trip planner!");
            System.out.print("what is your name? ");
            String name = input.nextLine();
            System.out.print("hello " + name +"," + "where are you traveling to? ");
            String destination = input.nextLine();
            System.out.println("Great! " + destination + " sounds good.");
        }



        public static void part2()
        {
            Scanner input = new Scanner(System.in);
            System.out.print("how many days staying?");
            int days = input.nextInt();
            System.out.print("Your budget? ");
            int budget = input.nextInt();
            System.out.print("whats the currency symbool? ");
            String currency = input.next();
            System.out.print("whats the conversion? ");
            double conversion = input.nextDouble();
            System.out.println();
            System.out.println("if you are travelling for " + days + " thats the same as" + (days*24) + " or "+
                    (days*1440));
            System.out.println("if you are going to spend $ "+ budget + "USD" +
                    "that means per day you can spend up to $ "+ (budget/days));

        }

        public static void part3()
        {
            Scanner input = new Scanner(System.in);
            System.out.print("Whats the time diference");
            int timeDiff = input.nextInt();
            System.out.println("that means when its midnight at home it will be "+ ( 0+ timeDiff)+ ":00 "+ "in your " +
                    "travel destionation and when its noon at home it will be " + (12 + timeDiff ) + ":00" );

        }

        public static void part4()
        {
            Scanner input =  new Scanner (System.in);
            System.out.print("whats square the are of your destination? ");
               double area = input.nextDouble();
            System.out.println("so in miles2 that is " + (area * 0.62) );

        }





}
