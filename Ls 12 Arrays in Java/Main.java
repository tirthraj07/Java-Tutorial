// https://www.geeksforgeeks.org/arrays-in-java/

// In Java, all arrays (as well as other objects) are stored on the heap, regardless of how they are initialized.

public class Main {
    public static void main(String args[]) {
        // Implicit Initialization
        int arr1[] = {1, 2, 3, 4, 5};  // Initialized with values directly
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        // Explicit Initialization with Assignment
        int arr2[] = new int[5];  // Array created with space for 5 elements
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr1[i]; // Assigning values from arr1 to arr2
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        // Explicit Initialization with Array Literal
        int arr3[] = new int[]{1, 2, 3, 4, 5};  // Initialized with specific values
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
