import java.util.*;
public class btree {
    Node root;
    btree(){}
    static class Node{
        Node left,right;
        int data;
        Node(int n){
            data = n;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        btree tree = new btree();
        ArrayList<Integer> inorder = new ArrayList<Integer>();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        Inorder(tree.root,inorder);
        boolean isit = true;
        for(int i = 0; i < inorder.size()-1; i++){
            if(inorder.get(i) > inorder.get(i+1)) isit = false;
        }
        System.out.println("The tree is in order? " + isit + "\n" + inorder);
    }
    static void Inorder(Node root, ArrayList<Integer> list){
        Node current = root;
        if(current.left != null) Inorder(current.left, list);
        list.add(current.data);
        if(current.right != null) Inorder(current.right, list);
    }
}
