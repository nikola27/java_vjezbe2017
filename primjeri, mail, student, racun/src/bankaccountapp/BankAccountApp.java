package emailapp.bankaccountapp;
//ovo mora biti
import java.util.LinkedList;
import java.util.List;
//ovo nam je klasa gdje je ispis znači, to je u biti aplikacija, ona je public i svamo iz nje ispisujemo što nam treba
//a ove ostale su sve sa elementima gdje su potrebni upisi neki pinovi i to šo se ne vid pa su neki elementi metode avarijable private i protected
public class BankAccountApp {
    public static void main (String [] args){
        //strukura podataka  za ovu klasu accounts, to je kraj, da nam sve ispise onda kako treba biti,
        // a truktura će bit lista za naše objekte, mi žemo linked listu a može bit array
        List<Account> accounts = new LinkedList<Account>(/*prazan konstruktor, tako je rekao*/);

        /*
        //ovo su objekti koje smo riučno dodavali
        Checking chkacc1 = new Checking("Nikola Šarić", "784859609", 1500);
        Savings savacc1 =  new Savings("Marko Marić", "938409503",2849 );
        //ovako zovemo metode, inače neće ništaispisat jer smo pravil promjene u account
       //ovaj izračun stanja balance uz ove kamate, stabili smo ovdje pa da ide dolje info sav
        savacc1.compound();
        savacc1.showInfo();
        //samo razdvajamo raćune
        System.out.println("**********");
        chkacc1.showInfo();

      //ovdje opet zovemo metode koje smo napravili
        /*savacc1.deposit(5000);
        savacc1.withdraw(300);
        savacc1.transfer(300,"Zara" );*/


        //učitavanje CSV dat pa kreiranje novog acc bazirano na tim podacima
        //ovaj array je jednak našem utilites
        //nakokn read u zagradu ide
        //ovo je nešto što je pokazivano u nekom drugom tutorijalu koji nemam pojma

        //ovdje definiramo file, tj gdje s enalazi, kopiramo link znači, ovo se veže sa dolje
        //ova list string, i dodamo ime file
        String file = "C:\\Users\\NIKOLA\\Downloads//NewBankAccounts.csv";
        List<String[]> newAccountHolders = utilities.CSV.read(file);
        //OVO JE VALJDA da printa ovih prvih par, odnosno na mjestu 0123
        //meni je izbacivalo grešku, samo prvi niz ispise, radi jer sam tamo imao razmak u CSV
        //ovo je algoritam za uctavanje iz datoteke, određeni objekt, name SSn na određeno mjestu u nizu
        for (String[] accountHolder: newAccountHolders){
            //System.out.println("NOVI RACUNI: ");
            String name = accountHolder[0];//ovo do ispisa dolje nam izbacuje sve računa iz dat
            String sSN = accountHolder[1];// onako kako je upisano po redoslijedu i nizu
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);//ovo ide ovako jer accountholder def kao string a treba nam double
            //System.out.println(name + " " + sSN+ " "+ accountType+ " "+ initDeposit);// za ispis pod iz dat u nizu
            //ovdje određujemo koji je tip računa
            if (accountType.equals("Savings")) {
               // System.out.println("OTVORI ŠTEDNI RAČUN");u
                //umjesto printa ćemo dodati gore za accounts u niz novi objekt ako je savings
                accounts.add(new Savings(name, sSN, initDeposit));
            }else if(accountType.equals("Checking")){
                //System.out.println("OTVORI TEKUĆI RAČUN");
                accounts.add(new Checking(name, sSN, initDeposit));
                }else{
                System.out.println("GREŠKA U UČITAVANJU TIPA RAČUNA");
            }


           /* System.out.println(accountHolder[0]);//ovako stavlja podatke jedan ispd drugog
            System.out.println(accountHolder[1]);//tj, ime na 0, br rac na 1, tip na 2 i svota na 3, to
            System.out.println(accountHolder[2]);//to su mjesta u niuzu od 0 kreće, a
            System.out.println(accountHolder[3]);//a tako su raspoređeni podaci u dat*/
        }
        //iteriramo koroz strukturu podataka tj Account
        //a zovemo metodu showinfo gdje imamo sve podatke, koji se trebaju ispisat
        //što je svrha, znači samo ono što se smije vidit da se ispiše
        //accounts.get(5).showInfo();//da dođemo do podatka u dat iz ove liste, a za određeni objekt u listi iz datoteke

        for(Account acc: accounts){//ovo je za sve elemente, tj objekte
            System.out.println("\n***************");//da odvojimo sve objekte ili elemente iz dat
            acc.showInfo();
       }
    }

}
