import java.util.*;
public class deduplicatearray {
    public static void main(String[] args) {
        // initializing and adding elements to array
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(4);
        a.add(6);
        a.add(6);
        a.add(6);

        HashSet<Integer> h = new HashSet<>(); // initializing hashset

        System.out.println("Pre-Dedup: " + a); // prints array prior to dedup

        for(int i = 0; i < a.size(); i++){ // dedup for loop
            if(!h.contains(a.get(i))) h.add(a.get(i)); // adds elements to hashset if they aren't in it already
            else{
                if(h.contains(a.get(i))) { // removes an element if its in the hashset and does i-- to account for a.size() change.
                    a.remove(i);
                    i--;
                }
            }
        }

        System.out.println("Post-Dedup: " + a); // prints the array after dedup
    }
}
