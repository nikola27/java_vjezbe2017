import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MovieGame extends Main {
    //postavlanje pocenith parametara
    private Scanner input;
    //ovdje je uveden file
    private File movieFile = new File("filmovi.txt");
    private int movieCount = 0;
    private String[] movieList = new String[100];
    private String pickedMovie;
    public String movieToGuess;
    private char inputLetter;
    private int badGuess = 0;

    //povezano sa file, očito može pvako, upisivanje iz file
    public String getMovie() throws FileNotFoundException {
        input = new Scanner(movieFile);
        while (input.hasNextLine()) {
            movieList[movieCount] = input.nextLine();
            movieCount++;
        }
        input.close();
//povezano sa redom, možemom ovako koristit funkciju math
        int randomNumber = (int) (Math.random() * movieCount);

        pickedMovie = movieList[randomNumber].toLowerCase();
//zamjena odabranog fila i znakova u _ te vraćanja takvohg oblika
        movieToGuess = pickedMovie.replaceAll("[A-Za-z0-9]", "_");
        return movieToGuess;
    }

    public void checkLetter() {
        System.out.println("You are guessing: " + movieToGuess);
        System.out.println("You have guessed " + badGuess + " wrong letters.");
        System.out.println("Guess a letter: ");
        boolean letterCorrect = false;
        input = new Scanner(System.in);
        inputLetter = input.next().toLowerCase().charAt(0);
        for (int i = 0; i < pickedMovie.length(); i++) {
            //ovo je pos slovu, za [i] je svako slovo oz odabranog.dužina, znači svako slovo jer je ovdje char znak
            if (pickedMovie.charAt(i) == inputLetter) {
                //ovo je ako bude isto slovo, i ponovo zove cijelu metodu checkletter
                if (movieToGuess.charAt(i) == inputLetter) {
                    System.out.println("You have already used the letter " + inputLetter + ".");
                    checkLetter();
                }
                //mislim da ovdje pretvara u zankove slova i provhera pa vrača u string sve dok nije true
                char[] gMovie = movieToGuess.toCharArray();
                gMovie[i] = inputLetter;
                movieToGuess = String.valueOf(gMovie);
                letterCorrect = true;
            }
        }

        if (letterCorrect) {
            System.out.println("Good guess!");
            if (movieToGuess.indexOf('_') < 0) {
                System.out.println("Congratulations, you got it!");
                return;
            }
        } else {
            //broj pogreški i pogodata koji smo odredili da je 10
            badGuess++;
            if (badGuess < 10) {
                System.out.println("Wrong. Guess again!");
            } else {
                System.out.println("You have guessed " + badGuess + " wrong letters.");
                System.out.println("Sorry, you lost. The movie title was " + pickedMovie.trim() + ".");
                return;
            }
        }
        checkLetter();
    }
}
