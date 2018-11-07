package emailapp.bankaccountapp;
//abstract znači da ne možemo kreirati objekte iz account klase ali možemo iz klasa koje nasljeđuju account
//zelimo da ovo bude parent class a checking i savings
// /*imprelemtirali smo Ibaserate, tko da sve što bue u  ibase rate je ukljueno u accounts
// i saving i checkins će imate vrijednosti isto u account sa kamatnim stopada interface irate
// */
public abstract class Account implements IBaseRate{

    //lista uobicajenih vrijednost ili  stvari za checkings i savings
    private String name;
    private String sSN;
    private double balance;
    //index , jer nam treba u zadatku neki broj s 5 znamenki, dolje imamo index ++ da svaki put doda 1
    private static int  index = 10000;
    //ovo je kontrla pristupa accesa
    //protevted jer ako je private ne možemo pristupit, protevted se može jer se koristi u
    //ove vdije klase ove vdije varijable, radi se zbog zaštite, da se neke stvari ne vide,
    //treba pazit šta se iz koje klase koristi u drugim klasama, ako se ne koristi onda se stavi private, samo
    //za tu klasu znači, a protecdet je valjda se može korsitti u u drugim ali je sakriveno
    protected String accountNumber;
    protected double rate;



    // konstruktor za bazne vrijednosti za iniciranje računa
    public Account(String name, String sSN, double initDeposit){
        this.name =  name;
        this.sSN = sSN;
        balance = initDeposit;
       // ovo ćećmo maknit, da nam ne ispisuje ovo sve jer je neportrebo, bit če posebno u funkciji showinfo, tjmetodi// System.out.println("NAME: " + name + " SSN: "+ sSN + " BALANCE: "+ balance );

        index++;

        // broj računa, ovdje jer je jednako iza savings i checkins
        this.accountNumber = setAccountNumber();
        //mislim da ovo zovemo funkciju ovdje jer klase naslijeđuju ovu pa može samo ovdje
        setRate();
        }

        //implementiramo abstract metodu, i moramo je implementirati u checkings i savings jer se
        //jer je u ovoj klasikoja je abstract
        public abstract void setRate();
        //jer je metode isto možemo je ovdje pozvati u superklasi


    private String setAccountNumber(){
        //zadnja dva broja so ovom fukncijom ide
        String lastTwoSSN = sSN.substring(sSN.length()-2,sSN.length());
        int uniqueID =  index;
        //random broj ide sa ovim fukncijama, ovo 10 i 3 jer treba troznamenkasti brojs
        int randomNumber =  (int) (Math.random()* Math.pow(10,3));
        //ovo je sve ovo zajedno gore da ispadne, ne znam zašto nismo gore varijblu stavili, ovo je funkcija samo onda izgleda
        return lastTwoSSN + uniqueID + randomNumber;

        /*System.out.print("ime:  ");
        //ovdje smo koristili jer je name-super kontrs i ne pišemo više u savings i checkings već samo ovdje
        // ili gore odmah, ali name se koristi pa mi gdje hoćemo stavit,
        // i ovdje isto
        System.out.println(name);*/
    }
        //mislim da je ovo neka kamata na novac koji je na računu valjda
    public void compound(){
        double accruedInterest = balance* (rate/100);//jer je u postotcima pa da vratimo
        balance = balance + accruedInterest;
        System.out.println("accrued interest: "+ accruedInterest);
        printBalance();
        }


    // lista zajedničkih metoda, deposit redraw

        public void deposit(double amount){
        balance = balance+amount;
            System.out.println("Uplata kn " + amount);
            printBalance();
        }

        public void withdraw(double amount){
        balance = balance- amount;
            System.out.println("Isplata kn" + amount);
            printBalance();
        }

        public void transfer(double amount, String mjesto){
        balance = balance-amount;
            System.out.println("prebacivanje novaca kn "+ amount + " prema "+ mjesto );
            printBalance();
        }
        public void printBalance(){
            System.out.println("STANJE: "+ balance);
        }


        public void showInfo(){
            System.out.println(
                    "NAME: " + name +
                     "\nACCOUNT NUMBER: " + accountNumber +
                     "\nBALANCE: " + balance +
                            "\nRATE: "+ rate + "%"
                    );






        }




}
