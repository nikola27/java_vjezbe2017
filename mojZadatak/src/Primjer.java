import java.util.Scanner;

public class Primjer {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("OCJENE");
        //odredimo koliko ocjena ćemo unijeti, varijablom brojocjena, input je prenosi u red
        //sa tim imenom istim, u for funkciji svaku dodanu ocjenu u varijablu pod mojeocjene
        // funkcija for je svrha da za određeni broj dadaje znači svaku novu sve dok nije jednako 6 kako je postavljeno
        //i dodaje u ovaj output ocjena i +1 kao ocjena1 ocjena 2 itd, input u zadnjem redu da se to odradi

        System.out.println("kolko bi ociena unijeli? ");
        int brojOcjena = input.nextInt();
        System.out.println("unesite ocjene od 1-5");
        int[] mojeOcjene = new int[brojOcjena];
        for (int i = 0; i<mojeOcjene.length; i++){
            System.out.println("Ucenik " + (i + 1)+ " postigao: ");
            mojeOcjene[i] = input.nextInt();
            if (mojeOcjene[i]>5){
                System.out.println("krivi unos, ponovi pokreni program!");
                return ;
                }
            }

            //broj učenika koji su pali
        int pad = 0;
        for(int i = 0; i < mojeOcjene.length; i++){
            if (mojeOcjene[i] == 1){
                pad++;
            }
        }

        int prolaz=0;
        for(int i = 0; i < mojeOcjene.length; i++){
            if (mojeOcjene[i] >=2){
                prolaz++;
            }
        }
       // prolaznostu postotku
        int post = (prolaz * 100/ mojeOcjene.length);



        //suma svih ocjena
        int sum = 0;
        for(int i = 0; i < mojeOcjene.length; i++){
            sum += mojeOcjene[i];
        }

        //prosjek ocjena svih u nizu unesenih
        int avg =  sum / mojeOcjene.length;
        //nakon što se izračuna prosjeg avg ovdje odredimo imali koja ocjena iznad tog prosjeka, tj kolko ocjena je preko prosjeka
        //aboveavg++ za svaku ocjenu tu iznad je ovaj dio
        int aboveAvg = 0;
        for(int i= 0; i< mojeOcjene.length; i++){
            if(mojeOcjene[i] > avg) {
                aboveAvg++;

            }
        }

        System.out.println("broj učenika koji nisu zadov: "+ pad);
        System.out.println("prošlo je: "+ prolaz);
        System.out.println("Prosječna ocjena = " + avg);
        System.out.println(aboveAvg+ " ocjene iznad prosjeka.");
        System.out.println("prolaznost " + post +"%");

    }
}

