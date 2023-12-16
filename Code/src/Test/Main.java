package Test;
import Logic.Dictionary;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Dictionary.addWordToDictionary("hola");
        Dictionary.addWordToDictionary("holo");
        Dictionary.displayDictionary();
    }
}
