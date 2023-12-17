package Logic;

import java.util.*;

public class BinaryTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void addNode(T info) {
        root = addNode(root, info);
    }

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

    public TreeNode<T> findNode(T info) {
        return findNode(root, info);
    }

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

    public int heightTree() {
        return height(root);
    }

    public int heightNode(TreeNode<T> node) {
        return height(node);
    }

    private int height(TreeNode<T> node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int weightTree() {
        return weight(root);
    }

    private int weight(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        return weight(node.getLeft()) + weight(node.getRight()) + 1;
    }

    public ArrayList<T> listPresort() {
        ArrayList<T> resultList = new ArrayList<>();
        presort(root, resultList);
        return resultList;
    }

    private void presort(TreeNode<T> node, ArrayList<T> resultList) {
        if (node != null) {
            presort(node.getLeft(), resultList);
            resultList.add(node.getInfo());
            presort(node.getRight(), resultList);
        }
    }

    public ArrayList<T> listInsort() {
        ArrayList<T> resultList = new ArrayList<>();
        insort(root, resultList);
        return resultList;
    }

    private void insort(TreeNode<T> node, ArrayList<T> resultList) {
        if (node != null) {
            resultList.add(node.getInfo());
            insort(node.getLeft(), resultList);
            insort(node.getRight(), resultList);
        }
    }

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

    public TreeNode<T> findFather(TreeNode<T> node) {
        return findFather(root, node);
    }

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

    private TreeNode<T> findSuccessor(TreeNode<T> node) {
        if (node.getLeft() == null) {
            return node;
        }
        return findSuccessor(node.getLeft());
    }


}
