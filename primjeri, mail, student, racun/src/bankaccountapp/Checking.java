package emailapp.bankaccountapp;

public class Checking extends Account {

    //lista vriejsnoti specificno za checkhing account
    int debitCardNumber;
    int debitCardPIN;

    //kontrsuktor za inicijaciju vrijednosti checking acc
    public Checking(String name, String sSN, double initDeposit){
        //moramo korsiti super da bi iz parenet pozvali ovaj kontrukotr
        //super konstruktor
        super(name, sSN, initDeposit);
        accountNumber = "2"+ accountNumber;

        //nakon što napravimo račun idu ovi podaci u ovoj fuknciji
        //također mislim da smo pozvali samo ovdje fuknciju a dolje je napisana
        setDebitCard();



        // ovo ćećmo maknit, da nam ne ispisuje ovo sve jer je neportrebo, bit če posebno u funkciji showinfo, tjmetodi
        //System.out.println("BROJ RAČUNA: "+ this.accountNumber);
        //System.out.println("NOVI TEKUĆI RAČUN ");

        //ovo možemo obrisati iz checking i savings ali staviti u account jer one ju nasliješuju
        // te tamo printat ime za obje valjda
        //System.out.println("ime: "+ name);
    }



    //ovdje implementiramo abstract metodu iz account
    //ovo je odg We are setting the 'setRate' function in our Account class, right? Then all the child classes have to implement the 'setRate' function and take over Account 'setRate' class functionality.
    //
    //So @Override is a annotation saying "Hey, you need to have this function in that class. Is not optional", unlike some others as showInfo or setDebitCard
    @Override
    public void setRate(){
        //ovdje je 15 posto glavne kamate, osnovne ove 2,5 iz ibaserate
        rate = getBaseRate() * .15;
        }


    //lista nekih metoda speci za checking acc, private jer želimo lokalno za ovu klasu
    //void jer ne vraćamo ništa već ćemo postavit, set
    private void setDebitCard(){
        // treba nam broj random sa 12znamenki
        debitCardNumber = (int)(Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * Math.pow(10,4));

        }


    public void showInfo(){
        //ovo će pozvati showinfo superklase za checkings
        super.showInfo();
        System.out.println("your checking account features: " +
        "\n Debit card number: " + debitCardNumber +
        "\n Debit card pin: " + debitCardPIN
        );

    }
}
