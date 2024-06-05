public class bst3min {
    Node root; // stores root node
    static class Node{
        int data; // stores data
        Node left,right; // stores left and right nodes;
        Node(int item){ // takes integer and stores it
            data = item; // stores input
            // creates a null left and right
            left = null;
            right = null;
        }
    }
    public static void main(String[] args) {
        // initializing and creating a binary tree
        bst3min tree = new bst3min();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);

        System.out.println(ret3rdmin(tree.root)); // prints the 3rd smallest element
    }
    static int ret3rdmin(Node current){ // takes the tree and runs through it
        Node incase = current; // this is in case there is a null
        current = current.left; // this is for the ideal case
        while(current.left.left != null){ // runs through the tree until reaching the last parent tree
            // goes to next per iteration
            current = current.left;
            incase = incase.left;
        }
        if(current.right != null) current = current.right; // checks the right node of the subtree and if it exists it returns that
        else{
            return incase.data; // if the right node doesn't exist it returns currents parent node
        }
        return current.data; // returns current data
    }
    // this code assumes that the tree is balanced, and takes into account that the question specifies the 3rd to last element rather than the nth to last.
}
