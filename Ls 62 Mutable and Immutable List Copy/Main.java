import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void printList(List<Integer> lst) {
        for (int i = 0; i < lst.size(); i++) {
            System.out.print(lst.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example 1:

        List<Integer> original1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        original1.add(6); // ✔️ Works

        printList(original1); // 1 2 3 4 5 6

        List<Integer> copy1 = List.copyOf(original1);
        List<Integer> copy2 = List.copyOf(original1);

        // copy1.add(7); // ❌ Doesn't work - UnsupportedOperationException.
        // List.copyOf() creates an immuatable copy of the original

        System.out.println("original1 == copy1 : " + (original1 == copy1)); // original1 == copy1 : false
        System.out.println("original1 == copy2 : " + (original1 == copy2)); // original1 == copy2 : false
        System.out.println("copy1 == copy2 : " + (copy1 == copy2)); // copy1 == copy2 : false

        List<Integer> mutableCopy = new ArrayList<>(original1);
        mutableCopy.add(7); // ✔️ Works
        printList(mutableCopy); // 1 2 3 4 5 6 7

        List<Integer> copyOfCopy = List.copyOf(copy1);
        System.out.println("copy1 == copyOfCopy : " + (copy1 == copyOfCopy));   // copy1 == copyOfCopy : true

        // Example 2
        List<Integer> original2 = List.of(1, 2, 3, 4, 5);
        printList(original2); // 1 2 3 4 5

        // original2.add(6); // ❌ Doesn't work - UnsupportedOperationException.
        // List.of() creates an immutable list

        List<Integer> copy3 = List.copyOf(original2);
        List<Integer> copy4 = List.copyOf(original2);

        System.out.println("original2 == copy3 : " + (original2 == copy3)); // original2 == copy3 : true
        System.out.println("original2 == copy4 : " + (original2 == copy4)); // original2 == copy4 : true
        System.out.println("copy3 == copy4 : " + (copy3 == copy4)); // copy3 == copy4 : true

        // List.copyOf() doesn’t always create a new list in memory. It behaves differently based on the input:

        // Case 1: If the Original List is Already Immutable
        // If the input list is already immutable (e.g., from List.of()), List.copyOf() returns the same reference.
        // No new memory allocation happens.

        // Case 2: If the Original List is Mutable
        // If the input list is mutable (ArrayList, LinkedList), List.copyOf() creates a new immutable copy.
        // A new list is allocated in memory.
    }
}
