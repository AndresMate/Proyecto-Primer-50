package Logic;



public class Dictionary {

    
    public static int convertWordToASCII(String word) {
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        System.out.println(word);
        int codigoASCII = (word.charAt(0));
        return codigoASCII-65;
    }

}
