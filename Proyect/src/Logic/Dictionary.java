package Logic;

import Model.Word;

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

    public String displayDictionary() {
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
        return null;
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



    public String updateMeaning(String wordToUpdate, String newMeaning) {
        int index = convertWordToASCII(wordToUpdate.toUpperCase().charAt(0));

        if (index >= 0 && index <= 25) {
            TreeNode<Word> node = alphabetTrees[index].findNode(new Word(wordToUpdate, "", ""));
            if (node != null) {
                Word foundWord = node.getInfo();
                foundWord.setMeaning(newMeaning);
                return "Significado de '" + wordToUpdate + "' actualizado exitosamente.";
            }
        }

        return "Palabra no encontrada. No se pudo actualizar el significado.";
    }
    public String[] getMeaningAndTranslation(String wordToFind) {
        int index = convertWordToASCII(wordToFind.toUpperCase().charAt(0));

        if (index >= 0 && index <= 25) {
            TreeNode<Word> node = alphabetTrees[index].findNode(new Word(wordToFind, "", ""));
            if (node != null) {
                Word foundWord = node.getInfo();
                String meaning = foundWord.getMeaning();
                String translation = foundWord.getTranslation();
                return new String[]{meaning, translation};
            }
        }

        return new String[]{"Palabra no encontrada", "Palabra no encontrada"};
    }

    public String deleteWord(String wordToDelete) {
        int index = convertWordToASCII(wordToDelete.toUpperCase().charAt(0));

        if (index >= 0 && index <= 25) {
            TreeNode<Word> node = alphabetTrees[index].findNode(new Word(wordToDelete, "", ""));
            if (node != null) {
                alphabetTrees[index].deleteNode(node);
                return "Palabra '" + wordToDelete + "' eliminada exitosamente.";
            }
        }

        return "Palabra no encontrada. No se pudo eliminar.";
}
    public ArrayList<Word> getWordsByLetter(char letter) {
        int index = convertWordToASCII(Character.toUpperCase(letter));

        if (index >= 0 && index <= 25) {
            return alphabetTrees[index].listInsort();
        }

        return new ArrayList<>(); // Devolver una lista vacía si la letra es válida
}

}
