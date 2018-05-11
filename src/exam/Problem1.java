package exam;

/***
 * Question:
 * - Create a Binary Tree data structure
 * - Implement in-order tree traversal using two different ways: recursive & iterative
 *
 */

class TNode {
    private int data;
    private TNode left;
    private TNode right;

    TNode(int data) {
        this.data = data;
    }

    int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    TNode getLeft() {
        return left;
    }

    void setLeft(TNode left) {
        this.left = left;
    }

    TNode getRight() {
        return right;
    }

    void setRight(TNode right) {
        this.right = right;
    }

}

class BTree {
    private TNode root;

    BTree(int data) {
        root = new TNode(data);
    }

    TNode getRoot() {
        return root;
    }

    void add(TNode parent, int value) {
        // TODO: Put your code here to add a new data to the tree
    }

    void inOrder(TNode parent) {
        // TODO: Put your code here to traverse a tree in InOrder fashion
    }


    void inOrderWithoutRecursive(TNode parent) {
        // TODO: Re-write <inOrder> function without recursive way
    }

}

public class Problem1{
    public static void main(String[] args) {
        BTree tree = new BTree(10);
        tree.add(tree.getRoot(), 2);
        tree.add(tree.getRoot(), 12);
        tree.add(tree.getRoot(), 2);

        tree.inOrder(tree.getRoot());

        tree.inOrderWithoutRecursive(tree.getRoot());
    }
}

