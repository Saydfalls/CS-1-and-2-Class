public class delete3rdlast {
    Node root; // creates root
    static class Node{ // node class to create nodes
        int data; // stores data
        Node next; // creates a next node
        Node(int n){ // node takes an integer
            data = n; // inputted data is stored in data
            next = null; // creates a next node
        }
    }
    public void p() { // printing method
        Node ref = root; // attaches to root

        while (ref != null) { // while loop that prints list until it reaches null
            System.out.print(ref.data + " "); // prints data and adds a space
            ref = ref.next; // goes to next
        }
    }
    public static void main(String[] args) {
        // initializes list and creates its nodes
        delete3rdlast list = new delete3rdlast();
        Node first = new Node(2);
        Node second = new Node(3);
        Node third = new Node(1);
        Node fourth = new Node(7);
        Node fifth = new Node(5);
        Node sixth = new Node(18);

        //linking the list and setting its root
        list.root = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;

        list.p(); // print list prior to removal
        System.out.println();
        rem3rd(list); // runs rem3rd which will remove the 3rd to last node
        list.p(); // prints the list
    }
    static void rem3rd(delete3rdlast list){ //method that takes the list and removes the third to last node
        Node remover = list.root; // this will be the node that gets removed
        Node prior = list.root; // this will be the node before the removed node
        Node latter = list.root; // this will be the node after the removed node

        // setting up
        remover = remover.next;
        latter = latter.next.next;

        while(remover.next.next.next != null){ // loop that runs until reaching the third to last node
            // moves to next per iteration
            prior = prior.next;
            remover = remover.next;
            latter = latter.next;
        }
        prior.next = latter; // links the prior to the latter skipping over the remover to remove it
    }
}
