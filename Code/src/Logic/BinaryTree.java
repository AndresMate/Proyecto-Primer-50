package Logic;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree<T> {
private Comparator<T> comparator;
public ArrayList<T> list;
TreeNode<T> root;

    public BinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void addNode(T info){
        if (isEmpty()){
            root= new TreeNode<>(info);
        }else{
            TreeNode<T> newNode = new TreeNode<>(info);
            TreeNode<T> actually= root;
            TreeNode<T> previous = null;
            while (actually != null){
                previous = actually;
                actually= comparator.compare(actually.getInfo(),info) < 0 ? actually.getLeft() : actually.getRight() ;
                if (comparator.compare(info, previous.getInfo()) < 0){
                    previous.setLeft(newNode);
                }else{
                    previous.setRight(newNode);
                }
            }
        }

    }

    public TreeNode<T> findNode(T info){
        TreeNode<T> aux = root;
        while(aux !=null && comparator.compare(aux.getInfo(),info) != 0){
            aux = comparator.compare(info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }
        return aux;
    }

    public int heightTree(){
        return heightNode(root);
    }

    public int heightNode(TreeNode<T> node){
        if(node == null)
            return 0;
        int leftHeight = heightNode(node.getLeft());
        int rightHeight = heightNode(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    private int height(TreeNode<T> node, int height){
       return 0;
    }

    public int weightTree(){
        return weight(root);
    }

    private int weight(TreeNode<T> node){
        if(node == null)
            return 0;
        return 1 + weight(node.getLeft()) + weight(node.getRight());
    }

    public int levelNode(TreeNode<T> node){
        return node == root ? 0 :  levelNode(findFather(node))+1;
    }

    public boolean isLeaf(TreeNode<T> node){
        if(node == null) return false;
        if(node.getLeft() == null && node.getRight() == null)
            return true;
        return false;
    }

    public byte gradeNode(TreeNode node){
        int cont=0;
        if (node.getLeft() != null){
            cont++;
        }
        if (node.getRight() != null){
            cont++;
        }
        return (byte) cont;
    }

    public ArrayList<T> listPresort(){
        list= new ArrayList<>();
        presort(root);
        return list;
    }

    private void presort(TreeNode<T> root){
        if (root != null){
            list.add(root.getInfo());
            presort(root.getLeft());
            presort(root.getRight());
        }
    }

    public ArrayList<T> listInsort(){
        list= new ArrayList<>();
        insort(root);
        return list;
    }

    private void insort(TreeNode<T> root){
        if (root != null){
            list.add(root.getInfo());
            insort(root.getLeft());
            insort(root.getRight());
        }

    }

    public List<T> listAmplitudeDown(){
        List<T> out = new ArrayList<>();
        ArrayDeque<TreeNode>tail = new ArrayDeque<>();
        tail.add(root);
        while (!tail.isEmpty()){
            TreeNode<T> aux = tail.poll();
            if (aux.getLeft() != null){
                tail.add(aux.getLeft());
            }
            if (aux.getRight() != null){
                tail.add(aux.getRight());
            }
            out.add(aux.getInfo());
        }
        return out;
    }

    public ArrayList<T> listAmplitudeTop(){
        return null;
    }

    public TreeNode<T> findFather(TreeNode<T> node){
        if (node != root){
            TreeNode<T> aux = root;
            while (aux.getLeft() != node && aux.getRight() != node){
                aux = comparator.compare(node.getInfo(), aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
            }
            return aux;
        }
        return null;
    }

    public T deleteNode(TreeNode<T> node){
        switch (gradeNode(node)){
            case 0:
                return deleteLeaf(node);
            case 1:
                return deleteWithSon(node);
            case 2:
                return deleteWithSons(node);
        }
        return null;
    }

    private T deleteLeaf(TreeNode<T> node){
        T out =node.getInfo();
        if (node == root){
            root = null;
        }else if(findFather(node).getLeft() == node)
            findFather(node).setLeft(null);
        else
            findFather(node).setRight(null);
        return out;
    }

    private T deleteWithSon(TreeNode<T> node){
        T out =node.getInfo();
        return out;
    }

    private T deleteWithSons(TreeNode<T> node){
        T out =node.getInfo();
        return out;
    }
}