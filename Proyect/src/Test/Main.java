package Test;

import Logic.Dictionary;
import Logic.Word;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        System.out.println(dictionary.addWordToDictionary(new Word("Gato", "Un animal doméstico", "Cat")));
        System.out.println(dictionary.addWordToDictionary(new Word("Perro", "Un amigo leal", "Dog")));
        System.out.println(dictionary.addWordToDictionary(new Word("Manzana", "Una fruta deliciosa", "Apple")));
        System.out.println(dictionary.addWordToDictionary(new Word("Elefante", "Un animal grande y majestuoso", "Elephant")));
        System.out.println(dictionary.addWordToDictionary(new Word("Casa", "Un lugar para vivir", "House")));
        System.out.println(dictionary.addWordToDictionary(new Word("Zanahoria", "Una hortaliza anaranjada", "Carrot")));
        System.out.println(dictionary.addWordToDictionary(new Word("Java", "Un lenguaje de programación", "Java")));
        System.out.println(dictionary.addWordToDictionary(new Word("Sol", "Una estrella", "Sun")));
        System.out.println(dictionary.addWordToDictionary(new Word("Montaña", "Una elevación natural de la tierra", "Mountain")));
        System.out.println(dictionary.addWordToDictionary(new Word("Jirafa", "Un animal de cuello largo", "Giraffe")));
        System.out.println(dictionary.addWordToDictionary(new Word("Hamburguesa", "Una comida deliciosa", "Burger")));
        System.out.println(dictionary.addWordToDictionary(new Word("Fútbol", "Un deporte popular", "Football")));
        System.out.println(dictionary.addWordToDictionary(new Word("Universidad", "Institución académica", "University")));
        System.out.println(dictionary.addWordToDictionary(new Word("Invierno", "Una de las estaciones", "Winter")));
        System.out.println(dictionary.addWordToDictionary(new Word("Lápiz", "Instrumento de escritura", "Pencil")));
        System.out.println(dictionary.addWordToDictionary(new Word("Océano", "Gran masa de agua salada", "Ocean")));
        System.out.println(dictionary.addWordToDictionary(new Word("Volar", "Desplazarse por el aire", "Fly")));
        System.out.println(dictionary.addWordToDictionary(new Word("Teclado", "Dispositivo de entrada", "Keyboard")));
        System.out.println(dictionary.addWordToDictionary(new Word("Piano", "Instrumento musical", "Piano")));
        System.out.println(dictionary.addWordToDictionary(new Word("Reptil", "Clase de animales", "Reptile")));
        System.out.println(dictionary.addWordToDictionary(new Word("Plátano", "Fruta tropical", "Banana")));
        System.out.println(dictionary.addWordToDictionary(new Word("Eclipse", "Ocultación de un astro por otro", "Eclipse")));
        System.out.println(dictionary.addWordToDictionary(new Word("Río", "Cuerpo de agua en movimiento", "River")));
        System.out.println(dictionary.addWordToDictionary(new Word("Computadora", "Dispositivo electrónico", "Computer")));
        System.out.println(dictionary.addWordToDictionary(new Word("Ciencia", "Conocimiento sistemático", "Science")));

        System.out.println(dictionary.addWordToDictionary(new Word("Reloj", "Instrumento para medir el tiempo", "Clock")));
        System.out.println(dictionary.addWordToDictionary(new Word("Aventura", "Experiencia emocionante", "Adventure")));
        System.out.println(dictionary.addWordToDictionary(new Word("Pescado", "Animal acuático comestible", "Fish")));
        System.out.println(dictionary.addWordToDictionary(new Word("Espejo", "Superficie reflectante", "Mirror")));
        System.out.println(dictionary.addWordToDictionary(new Word("Helado", "Postre congelado", "Ice Cream")));

        // Mostrar el diccionario
        dictionary.displayDictionary();

        // Mostrar el diccionario en orden alfabético
        dictionary.displayDictionaryAlphabetically();

    }
}
