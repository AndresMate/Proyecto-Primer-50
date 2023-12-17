package Logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator;

    /**
     *constructor
     *@param comparator
     */
    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }


    /**
        * Agrega un nuevo nodo con la información especificada al árbol binario.
        * @param info la información del nodo a agregar
        */
    public void addNode(T info) {
        root = addNode(root, info);
    }

    /**
     * Agrega un nuevo nodo con la información especificada al árbol binario.
     * @param node el nodo raíz del árbol binario
     * @param info la información del nodo a agregar
     * @return el nodo raíz del árbol binario
     */
    private TreeNode<T> addNode(TreeNode<T> node, T info) {
        if (node == null) {
            return new TreeNode<>(info);
        }
        int compareResult = comparator.compare(info, node.getInfo());
        if (compareResult < 0) {
            node.setLeft(addNode(node.getLeft(), info));
        } else if (compareResult > 0) {
            node.setRight(addNode(node.getRight(), info));
        }
        return node;
    }


    /**
     * Busca un nodo con la información especificada en el árbol binario.
     * @param info la información del nodo a buscar
     * @return el nodo con la información especificada, o null si no se encuentra
     */
    public TreeNode<T> findNode(T info) {
        return findNode(root, info);
    }

    /**
     * Busca un nodo con la información especificada en el árbol binario.
     * @param node el nodo raíz del árbol binario
     * @param info la información del nodo a buscar
     * @return el nodo con la información especificada, o null si no se encuentra
     */
    private TreeNode<T> findNode(TreeNode<T> node, T info) {
        if (node == null || comparator.compare(info, node.getInfo()) == 0) {
            return node;
        }
        int compareResult = comparator.compare(info, node.getInfo());
        if (compareResult < 0) {
            return findNode(node.getLeft(), info);
        } else {
            return findNode(node.getRight(), info);
        }
    }

    /**
    *Metodo que retorna la altura del arbol
    * @return la altura del arbol
     */
    public int heightTree() {
        return height(root);
    }

    /**
     * Retorna la altura del árbol binario.
     * @return la altura del árbol binario
     */
    public int heightNode(TreeNode<T> node) {
        return height(node);
    }

    /**
     * Retorna la altura del árbol binario.
     * @param node el nodo raíz del árbol binario
     * @return la altura del árbol binario
     */
    private int height(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Retorna el número de nodos del árbol binario.
     * @return el número de nodos del árbol binario
     */
    public int weightTree() {
        return weight(root);
    }

    /**
     * Retorna el número de nodos del árbol binario.
     * @param node el nodo raíz del árbol binario
     * @return el número de nodos del árbol binario
     */
    private int weight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return weight(node.getLeft()) + weight(node.getRight()) + 1;
    }

    /**
     * Metodo que Retorna la lista de nodos del árbol binario en preorden.
     * @return la lista de nodos del árbol binario en preorden
     */
    public ArrayList<T> listPresort() {
        ArrayList<T> resultList = new ArrayList<>();
        presort(root, resultList);
        return resultList;
    }

    /**
     * Retorna la lista de nodos del árbol binario en preorden.
     * @param node el nodo raíz del árbol binario
     * @param resultList la lista de nodos del árbol binario en preorden
     */
    private void presort(TreeNode<T> node, ArrayList<T> resultList) {
        if (node != null) {
            presort(node.getLeft(), resultList);
            resultList.add(node.getInfo());
            presort(node.getRight(), resultList);
        }
    }

    /**
     * Retorna la lista de nodos del árbol binario en orden.
     * @return la lista de nodos del árbol binario en orden
     */
    public ArrayList<T> listInsort() {
        ArrayList<T> resultList = new ArrayList<>();
        insort(root, resultList);
        return resultList;
    }

    /**
     * ordena la lista de nodos del árbol binario en orden.
     * @param node el nodo raíz del árbol binario
     * @param resultList la lista de nodos del árbol binario en orden
     */
    private void insort(TreeNode<T> node, ArrayList<T> resultList) {
        if (node != null) {
            resultList.add(node.getInfo());
            insort(node.getLeft(), resultList);
            insort(node.getRight(), resultList);
        }
    }

    
    /**
     * Devuelve una lista con los elementos del árbol en orden de amplitud descendente.
     * @return una lista con los elementos del árbol en orden de amplitud descendente.
     */
    public ArrayList<T> listAmplitudeDown() {
        ArrayList<T> resultList = new ArrayList<>();
        if (root != null) {
            // Using a queue for level order traversal
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode<T> current = queue.poll();
                resultList.add(current.getInfo());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }

                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
        }
        return resultList;
    }

    /**
     * Devuelve una lista con los elementos del árbol en orden de amplitud ascendente.
     * @return una lista con los elementos del árbol en orden de amplitud ascendente.
     */
    public ArrayList<T> listAmplitudeTop() {
        ArrayList<T> resultList = new ArrayList<>();
        if (root != null) {
            // Using a stack for level order traversal
            Stack<TreeNode<T>> stack = new Stack<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode<T> current = stack.pop();
                resultList.add(current.getInfo());

                if (current.getRight() != null) {
                    stack.push(current.getRight());
                }

                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                }
            }
        }
        return resultList;
    }


    /**
     * Busca el padre del nodo especificado en el árbol binario.
     * @param node el nodo cuyo padre se desea encontrar
     * @return el padre del nodo especificado
     */
    public TreeNode<T> findFather(TreeNode<T> node) {
        return findFather(root, node);
    }

    /**
     * Busca el padre del nodo especificado en el árbol binario.
     * @param current el nodo raíz del árbol binario
     * @param target el nodo cuyo padre se desea encontrar
     * @return el padre del nodo especificado
     */
    private TreeNode<T> findFather(TreeNode<T> current, TreeNode<T> target) {
        if (current == null || current.getLeft() == null && current.getRight() == null) {
            return null;  // Node is root or leaf, has no father
        }
        if ((current.getLeft() != null && current.getLeft().equals(target)) ||
                (current.getRight() != null && current.getRight().equals(target))) {
            return current;  // Found the father
        }
        TreeNode<T> leftResult = findFather(current.getLeft(), target);
        if (leftResult != null) {
            return leftResult;
        }
        return findFather(current.getRight(), target);
    }
    
    /**
     * Elimina el nodo especificado del árbol binario.
     * @param node el nodo a eliminar
     * @return la información del nodo eliminado, o null si no se encuentra
     */
    public T deleteNode(TreeNode<T> node) {
        if (node == null || findNode(node.getInfo()) == null) {
            return null;  // Node not found in the tree
        }
        TreeNode<T> father = findFather(node);
        if (father == null) {
            // Node is the root
            root = (TreeNode<T>) deleteRoot(node);
        } else if (father.getLeft() != null && father.getLeft().equals(node)) {
            // Node is the left child of its father
            father.setLeft(deleteRoot(node));
        } else {
            // Node is the right child of its father
            father.setRight(deleteRoot(node));
        }
        return node.getInfo();
    }


    /**
     * Elimina el nodo raíz del árbol binario y devuelve el nuevo nodo raíz.
     * Si el nodo raíz no tiene hijos, se devuelve null.
     * Si el nodo raíz tiene solo un hijo izquierdo, se devuelve ese hijo.
     * Si el nodo raíz tiene solo un hijo derecho, se devuelve ese hijo.
     * Si el nodo raíz tiene tanto un hijo izquierdo como un hijo derecho,
     * se encuentra el sucesor del nodo raíz en el subárbol derecho y se reemplaza
     * el valor del nodo raíz con el valor del sucesor. Luego, se elimina el sucesor
     * del subárbol derecho y se devuelve el nodo raíz actualizado.
     *
     * @param node el nodo raíz a eliminar
     * @return el nuevo nodo raíz después de eliminar el nodo raíz actual
     */
    private TreeNode<T> deleteRoot(TreeNode<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            // Node is a leaf
            return null;
        } else if (node.getLeft() != null && node.getRight() == null) {
            // Node has only a left child
            return node.getLeft();
        } else if (node.getLeft() == null && node.getRight() != null) {
            // Node has only a right child
            return node.getRight();
        } else {
            // Node has both left and right children
            T successorInfo = findSuccessor(node.getRight()).getInfo();
            node.setRight(deleteNode(node.getRight(), successorInfo));
            node.setInfo(successorInfo);
            return node;
        }
    }


    /**
     * Elimina un nodo del árbol binario.
     * @param node El nodo actual.
     * @param info La información del nodo a eliminar.
     * @return El nodo actualizado después de eliminar el nodo especificado.
     */
    private TreeNode<T> deleteNode(TreeNode<T> node, T info) {
        if (node == null) {
            return null;
        }
        int compareResult = comparator.compare(info, node.getInfo());
        if (compareResult < 0) {
            node.setLeft(deleteNode(node.getLeft(), info));
        } else if (compareResult > 0) {
            node.setRight(deleteNode(node.getRight(), info));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            TreeNode<T> successor = findSuccessor(node.getRight());
            node.setRight(deleteNode(node.getRight(), successor.getInfo()));
            node.setInfo(successor.getInfo());
        }
        return node;
    }

    /**
     * Encuentra el sucesor del nodo especificado en el árbol binario.
     * @param node el nodo del cual se desea encontrar el sucesor
     * @return el sucesor del nodo especificado
     */
    private TreeNode<T> findSuccessor(TreeNode<T> node) {
        if (node.getLeft() == null) {
            return node;
        }
        return findSuccessor(node.getLeft());
    }

}
