package Logic;

import static Logic.Dictionary.convertWordToASCII;


import java.util.Scanner;

public class ff {
    public static void main(String[] args) {
        // Arreglos de árboles para cada letra del abecedario
        BinaryTree[] alphabetTrees = new BinaryTree[26];

        // Inicialización de árboles
        for (int i = 0; i < 26; i++) {
            alphabetTrees[i] = new BinaryTree();
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Ver letras guardadas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de nextInt()

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese una palabra: ");
                    String palabra = scanner.nextLine().toLowerCase(); // Convierte a minúsculas
                    agregarPalabra(alphabetTrees, palabra);
                    break;
                case 2:
                    mostrarLetrasGuardadas(alphabetTrees);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    // Método para agregar una palabra al árbol correspondiente según el código ASCII de la primera letra
    private static void agregarPalabra(BinaryTree[] alphabetTrees, String palabra) {
        if (!palabra.isEmpty()) {
            char primeraLetra = palabra.charAt(0);
            if (Character.isLetter(primeraLetra)) {
                int index = primeraLetra - 'a';
                alphabetTrees[index].insert(palabra);
                System.out.println("Palabra agregada exitosamente.");
            } else {
                System.out.println("La primera letra no es una letra del abecedario. Inténtelo de nuevo.");
            }
        } else {
            System.out.println("La palabra ingresada está vacía. Inténtelo de nuevo.");
        }
    }

    // Método para mostrar las letras guardadas y las palabras dentro de cada árbol
    private static void mostrarLetrasGuardadas(BinaryTree[] alphabetTrees) {
        for (int i = 0; i < 26; i++) {
            char letra = (char) ('a' + i);
            System.out.println("\nLetra " + letra + ":");
            alphabetTrees[i].inOrder();
        }
    }
}

class Node {
    String data;
    Node left, right;

    public Node(String palabra) {
        this.data = palabra;
        this.left = this.right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(String palabra) {
        this.root = insertRec(this.root, palabra);
    }

    private Node insertRec(Node root, String palabra) {
        if (root == null) {
            root = new Node(palabra);
            return root;
        }

        int comparisonResult = palabra.compareTo(root.data);

        if (comparisonResult < 0) {
            root.left = insertRec(root.left, palabra);
        } else if (comparisonResult > 0) {
            root.right = insertRec(root.right, palabra);
        }

        return root;
    }

    public void inOrder() {
        inOrderRec(this.root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }
}