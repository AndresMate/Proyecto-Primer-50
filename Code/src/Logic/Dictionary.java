package Logic;


import java.util.ArrayList;
import java.util.Comparator;
import Logic.BinaryTree;

public class Dictionary {
    private static BinaryTree<String>[] alphabetTrees;


    public Dictionary() {
        // Inicialización de árboles
        alphabetTrees = new BinaryTree[26];
        for (int i = 0; i < 26; i++) {
            alphabetTrees[i] = new BinaryTree<>();
        }
    }


    public static void addWordToDictionary(String word) {
        if (!word.isEmpty() && Character.isLetter(word.charAt(0)) && convertWordToASCII(word)>=0 && convertWordToASCII(word)<=25 ) {
            int index = convertWordToASCII(word);
            alphabetTrees[index].addNode(word);
            System.out.println("Palabra agregada exitosamente al diccionario.");
        } else {
            System.out.println("La palabra ingresada no es válida. Inténtelo de nuevo.");
        }
    }

    public static void displayDictionary() {
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            System.out.println("\nPalabras que comienzan con la letra " + letter + ":");
            ArrayList<String> words = alphabetTrees[i].listInsort();
            for (String word : words) {
                System.out.println(word);
            }
        }
    }

    public static int convertWordToASCII(String word) {
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
        System.out.println(word);
        int codigoASCII = (word.charAt(0));
        return codigoASCII-65;
    }

}
