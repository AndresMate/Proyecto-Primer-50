package Test;
import Logic.Dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.addWordToDictionary("hola"));
        System.out.println(dictionary.addWordToDictionary("holo"));
        System.out.println(dictionary.addWordToDictionary("hala"));
        System.out.println(dictionary.addWordToDictionary("dumar"));
        System.out.println(dictionary.addWordToDictionary("dinamarca"));
        System.out.println(dictionary.addWordToDictionary("diana"));
        System.out.println(dictionary.convertWordToASCII("dumar"));
        dictionary.displayDictionary();



    }

}
