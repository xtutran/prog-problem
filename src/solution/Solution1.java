package solution;

import java.util.Stack;

/***
 * Question:
 * - Create a Binary Tree
 *
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

    // TODO: Put your code here to add a new data to the tree
    void add(TNode parent, int value) {
        if (parent == null) {
            return;
        }

        if (value <= parent.getData()) {
            if(parent.getLeft() == null) {
                parent.setLeft(new TNode(value));
            } else {
                add(parent.getLeft(), value);
            }
        } else {
            if(parent.getRight() == null) {
                parent.setRight(new TNode(value));
            } else {
                add(parent.getRight(), value);
            }
        }
    }

    // TODO: Put your code here to traverse a tree in InOrder fashion
    void inOrder(TNode parent) {
        if (parent != null) {
            inOrder(parent.getLeft());
            System.out.print(parent.getData() + " ");
            inOrder(parent.getRight());
        }
    }

    // TODO: Re-write <inOrder> function without recursive way
    void inOrderWithoutRecursive(TNode parent) {
        Stack<TNode> stack = new Stack<TNode>();

        TNode cursor = parent;
        while(!stack.isEmpty() || cursor != null) {
            if (cursor != null) {
                stack.push(cursor);
                cursor = cursor.getLeft();
            } else {
                cursor = stack.pop();
                System.out.print(cursor.getData() + " ");
                cursor = cursor.getRight();
            }
        }
    }

}

public class Solution1 {
    public static void main(String[] args) {
        BTree tree = new BTree(10);
        tree.add(tree.getRoot(), 2);
        tree.add(tree.getRoot(), 12);
        tree.add(tree.getRoot(), 2);

        System.out.println("\nIn-order recursive way");
        tree.inOrder(tree.getRoot());

        System.out.println("\nIn-order iterative way");
        tree.inOrderWithoutRecursive(tree.getRoot());

        // expected output: 2 2 10 12
    }
}
