import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
         * Collection API provides a common interface to deal with data structures like
         * Arrays, Vectors, LinkedLists, etc and introduced the Collection Framework in
         * JDK 1.2 post which both, legacy Vectors and Hashtables were modified to
         * conform to the Collection Framework.
         * Collection collection = new Collection<E>() {
         * // You will have to implement the Methods defined in Collections Class
         * // You can use a set of predefined collection like Lists, HashSets,
         * HashTable, etc
         * };
         * 
         */

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list); // [1, 2, 3, 4, 5]

        Set<Integer> set = new HashSet<>();
        set.add(62);
        set.add(54);
        set.add(82);
        set.add(21);
        set.add(21);
        System.out.println(set); // [82, 21, 54, 62]

        // Sorted
        Set<Integer> set2 = new TreeSet<>();
        set2.add(62);
        set2.add(54);
        set2.add(82);
        set2.add(21);
        set2.add(21);
        System.out.println(set2); // [21, 54, 62, 82]

        // Sorting
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(1);
        arr.add(5);
        arr.add(7);
        arr.add(9);
        arr.sort(null); // OR Collections.sort(arr);
        System.out.println(arr);

        // Sorting with custom comparator

        // Create an object of Comparator class by implementing the compare function
        // Compares its two arguments for order. Returns a negative integer, zero, or a
        // positive integer as the first argument is less than, equal to, or greater
        // than the second.

        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 % 10 > o2 % 10) {
                    return 1;
                }
                return -1;
            }
        };

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(50);
        arr2.add(41);
        arr2.add(32);
        arr2.add(23);
        arr2.add(14);
        arr2.sort(comp);
        System.out.println(arr2); // [50, 41, 32, 23, 14]

        // Shorter form
        arr2.sort((Integer o1, Integer o2) -> {
            return (o1 % 10 - o2 % 10);
        });

        System.out.println(arr2); // [50, 41, 32, 23, 14]

        // asList and ways of printing a list

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // Method 1
        System.out.println(list2); // [1, 2, 3, 4, 5, 6, 7]

        // Method 2
        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i));
            System.out.print(", ");
        }
        System.out.println();
        // 1, 2, 3, 4, 5, 6, 7,

        // Method 3
        for (int i : list2) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.println();
        // 1, 2, 3, 4, 5, 6, 7,

        list2.forEach((Integer i) -> {
            System.out.print(i);
            System.out.print(", ");
        });
        System.out.println();
        // 1, 2, 3, 4, 5, 6, 7,

    }
}