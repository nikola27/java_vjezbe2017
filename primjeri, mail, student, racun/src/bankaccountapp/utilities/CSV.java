package utilities;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

//za ucivavanje iz datoteke, pravimo novi package utilites, pa novu klasu CSV
//ova funkcija će učitavati iz CSV file i vratit će vrijednots u oblku liste
//ovi importi gore nam trebaju, pravimo lista preko niza, jer imamo ime, ssn, tip računa i balance
//arraj list jer ne znamo kolko ima pa da može koliko trbe aupisivat
public class CSV {
    //static da možemo uvijek pristupit
    public static List<String[]> read(String file) {
        //pravimo listu imena data
        List<String[]> data = new LinkedList<String[]>();

        //pa ide bufferedREader, dolazi iz filereadera iz file
        //treba nam ovaj try catch blok naredbe, mislim daje to zbog toga ako nema fila,
        //ovo IOeepction su greške valjda da izbaci ako na njih aniđe
        //treba pisati, ovo dolje je e. izbaci ovaj dio koji treba dodati
        //deklariramo ovaj data izvan
        String dataRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            //ovo mislim readline da čita iz file
            //i čita sve dok ovo nije jedanko nuli , tj dok ima nešto za učitat
            while ((dataRow = br.readLine()) != null)
            {
                //podjelit ih sa zarezom, ejr ima više tipova,ime bla bla
                //i tako idu u niz array
                String[] dataRecords = dataRow.split(",");//ovdje ne smije bit razmak uz zarez, jer neće ispisat, izbacivali mi je grešku
                data.add(dataRecords);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nemoguce naci podatke");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Nemoguce ucitati podatke");
            e.printStackTrace();
        }
        //ovo ne zab, da vrati vrijednost dat
        return data;
    }
}







