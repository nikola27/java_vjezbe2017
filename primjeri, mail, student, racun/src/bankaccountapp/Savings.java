package emailapp.bankaccountapp;

public class Savings extends Account {

    //lista vriejdnosti spec za savings
    int safetyDepositBoxID;
    int getSafetyDepositBoxKey;

    //kontrsukotr za inic za savings
    public Savings(String name, String sSN, double initDeposit) {
        //ovdje isto super, najvjerojatnije jer se koristi iz ovih klasa koje naslijeđuju i ima više
        // i koristi se više iz ovog konttruktora koji je u account, koja je glavna klasa
        super(name, sSN, initDeposit);
        //pošto treba dodati za ispis novog računa ako je 1 za štednju , a 2 za tekući, ovo sve fuknc u account klasi jer ovje dvije naslijeđuju account klasu
        accountNumber = "1" + accountNumber;
        //treba nam za box i key broj, koji nam treba kad napravimo račun
        //ovo kao u checkings zovemo je u konstr a dolje je ispisana
        setSafetyDepositBox ();


        // ovo ćećmo maknit, da nam ne ispisuje ovo sve jer je neportrebo, bit če posebno u funkciji showinfo, tjmetodi
        //System.out.println("BROJ RAČUNA: "+ this.accountNumber);
        //System.out.println("NOVI ŠTEDNI RAČUN " );
        // System.out.println(name);
    }
        private void setSafetyDepositBox(){
        //treba nam 3znam broj random
        safetyDepositBoxID =(int) (Math.random() * Math.pow(10, 3));
        //reba nam 4 znam broj za key
            getSafetyDepositBoxKey = (int) (Math.random() * Math.pow(10, 4));
        }

    //kamata za savings izračun iz ibaserate
    @Override
    public void setRate(){
        rate = getBaseRate() - .25;
        }


    // lista metoda spec za savings acc
    public void showInfo() {
        //ovo će pozvati showinfo superklase za savings
        super.showInfo();
        System.out.println(
                "Your savings account feature:" +
                        "\n Safety deposit box ID: " + safetyDepositBoxID +
                        "\n Safety deposit box key: " + getSafetyDepositBoxKey);
         }

}