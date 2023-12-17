package Test;
import Logic.Dictionary;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
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


        Translate translate = TranslateOptions.getDefaultInstance().getService();
        System.out.print("Ingrese una palabra: ");
        String palabra = scanner.nextLine();
        Translation translation = translate.translate(palabra, Translate.TranslateOption.targetLanguage("en"));
        System.out.println("Traducción en inglés: " + translation.getTranslatedText());
    }

}
