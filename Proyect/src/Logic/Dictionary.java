package Logic;

import java.util.ArrayList;
import java.util.Comparator;

public class Dictionary {
    private static BinaryTree<Word>[] alphabetTrees;

    public Dictionary() {
        // Inicialización de árboles
        alphabetTrees = new BinaryTree[26];
        for (int i = 0; i < 26; i++) {
            alphabetTrees[i] = new BinaryTree<>(Comparator.comparing(Word::getWord));
        }
    }

    public String addWordToDictionary(Word word) {
        if (!word.isEmpty() && Character.isLetter(word.getWord().charAt(0))) {
            int index = convertWordToASCII(word.getWord().toUpperCase().charAt(0));
            if (index >= 0 && index <= 25) {
                alphabetTrees[index].addNode(word);
                return "Palabra agregada exitosamente al diccionario.";
            }
        }
        return "La palabra ingresada no es válida. Inténtelo de nuevo.";
    }

    public void displayDictionary() {
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            System.out.println("\nPalabras que comienzan con la letra " + letter + ":");
            ArrayList<Word> words = alphabetTrees[i].listInsort();
            for (Word word : words) {
                System.out.println("Palabra: " + word.getWord() +
                        ", Significado: " + word.getMeaning() +
                        ", Traducción: " + word.getTranslation());
            }
        }
    }

    private int convertWordToASCII(char firstLetter) {
        return Character.toUpperCase(firstLetter) - 'A';
    }

    public void displayDictionaryAlphabetically() {
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i);
            System.out.println("\nPalabras que comienzan con la letra " + letter + ":");

            ArrayList<Word> words = alphabetTrees[i].listInsort();
            for (Word word : words) {
                System.out.println("Palabra: " + word.getWord() +
                        ", Significado: " + word.getMeaning() +
                        ", Traducción: " + word.getTranslation());
            }
        }
    }


}
