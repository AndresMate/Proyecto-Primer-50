package Logic;

import java.util.ArrayList;
import java.util.Comparator;

import Model.Word;

public class Dictionary {
    private static BinaryTree<Word>[] alphabetTrees;

    /**
     * Constructor de la clase Dictionary.
     * Inicializa los árboles binarios de búsqueda para cada letra del alfabeto.
     */
    public Dictionary() {
        // Inicialización de árboles
        alphabetTrees = new BinaryTree[26];
        for (int i = 0; i < 26; i++) {
            alphabetTrees[i] = new BinaryTree<>(Comparator.comparing(Word::getWord));
        }
    }

    /**
     * Método para agregar una palabra al diccionario.
     * @param word Palabra a agregar.
     * @return Mensaje de éxito o fracaso.
     */
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


    /**
     * Método para convertir una letra a su valor ASCII.
     * @param firstLetter Letra a convertir.
     * @return Valor ASCII de la letra.
     */

    private int convertWordToASCII(char firstLetter) {
        return Character.toUpperCase(firstLetter) - 'A';
    }

    /**
     * Método para mostrar el diccionario en orden alfabético.
     */
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

    /**
     * Método para buscar una palabra en el diccionario y cambiar su significado.
     * @param wordToUpdate Palabra a buscar.
     * @param newMeaning Nuevo significado de la palabra.
     * @return Mensaje de éxito o fracaso.
     */
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

    /**
     * Método para buscar una palabra en el diccionario y ver su significado y traducción.
     * @param wordToFind Palabra a buscar.
     * @return Arreglo con el significado y traducción de la palabra.
     */
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

    /**
     * Método para buscar una palabra en el diccionario y eliminarla.
     * @param wordToDelete Palabra a eliminar.
     * @return Mensaje de éxito o fracaso.
     */
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

    /**
     * Método para obtener todas las palabras que comienzan con una letra.
     * @param letter Letra a buscar.
     * @return Lista de palabras que comienzan con la letra.
     */
    public ArrayList<Word> getWordsByLetter(char letter) {
        int index = convertWordToASCII(Character.toUpperCase(letter));

        if (index >= 0 && index <= 25) {
            return alphabetTrees[index].listInsort();
        }

        return new ArrayList<>(); // Devolver una lista vacía si la letra es válida
}

}
