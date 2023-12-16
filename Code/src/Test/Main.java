package Test;
import Logic.Dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        System.out.println(dictionary.addWordToDictionary("hola"));
        System.out.println(dictionary.addWordToDictionary("holo"));
        System.out.println(dictionary.addWordToDictionary("hala"));
        dictionary.displayDictionary();
    }

}
