import java.lang.String;
public class Chrypto {
    public static void main(String[] args) {
        String input = "This is some \"really\" great. (Text) ZBa!?";
        int shift = 3;
        int group = 5;
        String crypted = encryptString(input, shift, group);
        System.out.println(crypted);
    }

    public static String encryptString(String input, int shift, int group) {
        String normalized = normalizeText(input);
        String obified = obify(normalized);
        String shifted = caesarify(obified, shift);
        return groupify(shifted, group);
    }
    //ovdje ide ovaj dio gdje se tekst spaja, maknu se znakovi itd
    public static String normalizeText(String input) {
        return input.replaceAll("[. , : ; \" ’ ! ? ( )]", "").toUpperCase();
    }



    public static String obify(String normalized) {
        StringBuilder str = new StringBuilder(normalized);
        for (int idx = 0; idx < str.length(); idx++) {
            char thisC = str.charAt(idx);
            if (thisC == 'A' || thisC == 'E' || thisC == 'I' || thisC == 'O' || thisC == 'U' || thisC == 'Y') {
                str.insert(idx, "OB");
                idx = idx + 2;
            }
        }
        return str.toString();
    }
//ovaj je dio metoda caesarify, ima ključ te određeno slovo miče po abecedi za tolio mjesta koliki je kl
//ključ, pomak
    public static String caesarify(String obified, int shift) {
        String result = "";
        for (int i = 0; i < obified.length(); i++) {
            int numeric = (int) obified.charAt(i);
            char newCurrChar = (char) (numeric + shift);
            if (newCurrChar <= 'Z' && newCurrChar >= 'A') {
                result = result + newCurrChar;
            } else if (newCurrChar < 'A') {
                char adjChar = (char) (numeric + shift + 26);
                result = result + adjChar;
            } else {
                char adjChar = (char) (numeric + shift - 26);
                result = result + adjChar;
            }

        }
        return result;
    }
//metoda gropuify ima dva parematra string koji želimo u grupama i broj slova po grupi
    //vraćastring u grupama sa određenim brojem slova koji smo odredili sa nLetters
    public static String groupify(String shifted, int nLetters) {
        StringBuilder str = new StringBuilder(shifted);
        int idx = nLetters;
        while (idx < str.length()) {
            str.insert(idx, " ");
            idx = idx + nLetters + 1;
        }
        while (str.length() % (nLetters + 1) != nLetters) {
            str.insert(str.length(), "x");
        }
        return str.toString();
    }
}