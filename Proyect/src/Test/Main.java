package Test;

/*import Logic.Dictionary;
import Logic.Word;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        System.out.println(dictionary.addWordToDictionary(new Word("Gato", "Un animal doméstico", "Cat")));

        System.out.println(dictionary.addWordToDictionary(new Word("Animal", "animal de la selva","Animal")));
        System.out.println(dictionary.addWordToDictionary(new Word("Ave", "ave de la selva","aveishon")));
        System.out.println(dictionary.addWordToDictionary(new Word("Avion", "vehiculo de trnasporte","Aeroplane")));
        System.out.println(dictionary.addWordToDictionary(new Word("Arriba", "parte de arriba","up")));
        // Mostrar el diccionario
        dictionary.displayDictionary();

        // Mostrar el diccionario en orden alfabético
        dictionary.displayDictionaryAlphabetically();

    }
}*/
import Logic.Dictionary;
import Logic.Word;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear un diccionario
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n*** Menú del Diccionario ***");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Consultar significado");
            System.out.println("3. Consultar listado por letra");
            System.out.println("4. Listar palabras");
            System.out.println("5. Modificar significado");
            System.out.println("6. Eliminar palabra");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después del nextInt()

            switch (opcion) {
                case 1:
                    // Agregar palabra
                    System.out.print("Ingrese la palabra: ");
                    String nuevaPalabra = scanner.nextLine();
                    System.out.print("Ingrese el significado: ");
                    String nuevoSignificado = scanner.nextLine();
                    System.out.print("Ingrese la traducción: ");
                    String nuevaTraduccion = scanner.nextLine();
                    Word nuevaWord = new Word(nuevaPalabra, nuevoSignificado, nuevaTraduccion);
                    System.out.println(dictionary.addWordToDictionary(nuevaWord));
                    break;

                case 2:
                    // Consultar significado
                    System.out.print("Ingrese la palabra a consultar: ");
                    String palabra = scanner.nextLine();
                    String[] result = dictionary.getMeaningAndTranslation(palabra);
                    System.out.println("Significado de '" + palabra + "': " + result[0]);
                    System.out.println("Traducción de '" + palabra + "': "+result[1]);
                    break;

                case 3:
                    // Listar palabras
                    System.out.println("\nListado por letra");
                    System.out.println("Ingrese una letra");
                    char letter = scanner.next().charAt(0);

                      ArrayList<Word> wordsByLetter=dictionary.getWordsByLetter(letter);
                    System.out.println("listado de palabras que inciian por "+letter);
                    for(Word word: wordsByLetter){
                        System.out.println("palabra: "+word.getWord()+", significado: "+word.getMeaning()+"traduccion: "+word.getTranslation());
                    }
                    break;

                case 4:
                    // Listar palabras
                    System.out.println("\nDiccionario ordenado alfabéticamente:");
                    dictionary.displayDictionaryAlphabetically();
                    break;

                case 5:
                    // Modificar significado
                    System.out.print("Ingrese la palabra a modificar: ");
                    String palabraModificar = scanner.nextLine();
                    System.out.print("Ingrese el nuevo significado: ");
                    String nuevoSignificadoModificar = scanner.nextLine();
                    dictionary.updateMeaning(palabraModificar, nuevoSignificadoModificar);
                    break;

                case 6:
                    // Eliminar palabra
                    System.out.print("Ingrese la palabra a eliminar: ");
                    String palabraEliminar = scanner.nextLine();
                    dictionary.deleteWord(palabraEliminar);
                    break;

                case 7:
                    // Salir
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 6);
    }
}
