package Logic;
import java.util.ArrayList;

public class Dictionary {
    private static BinaryTree<String>[] alphabetTrees;

    public Dictionary() {
        // Inicialización de árboles
        alphabetTrees = new BinaryTree[26];
        for (int i = 0; i < 26; i++) {
            alphabetTrees[i] = new BinaryTree<>((CharSequence::compare));
        }
    }
    public  String addWordToDictionary(String word) {
        if (!word.isEmpty() && Character.isLetter(word.charAt(0)) && convertWordToASCII(word)>=0 && convertWordToASCII(word)<=25 ) {
            int index = convertWordToASCII(word);
            alphabetTrees[index].addNode(word);
            return ("Palabra agregada exitosamente al diccionario.");
        } else {
            return ("La palabra ingresada no es válida. Inténtelo de nuevo.");
        }
    }
    public  void displayDictionary() {
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            System.out.println("\nPalabras que comienzan con la letra " + letter + ":");
            ArrayList<String> words = alphabetTrees[i].listInsort();
            for (String word : words) {
                System.out.println(word);
            }
        }
    }
    public  int convertWordToASCII(String word) {
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        int codigoASCII = (word.charAt(0));
        return codigoASCII-65;
    }

}