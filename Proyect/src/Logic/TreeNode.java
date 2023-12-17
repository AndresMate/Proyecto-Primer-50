package Logic;

public class TreeNode<T> {
    private T info;

    private TreeNode<T> left;
    private TreeNode<T> right;


    public TreeNode(T info) {
        this.info = info;
        left = right = null;
    }
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    void setLeft(TreeNode<T> left){
        this.left = left;
    }

    TreeNode<T> getLeft(){
        return left;
    }

    void setRight(TreeNode<T> right){
        this.right = right;
    }

    TreeNode<T> getRight(){
        return right;
    }

    @Override
    public String toString() {
        return info.toString();
    }
    
}
