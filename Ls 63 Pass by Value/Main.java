/*
    Java ALWAYS uses pass by value, even for objects.
*/

class WrapperInt {
    public int value;

    public WrapperInt(int value) {
        this.value = value;
    }
}

public class Main {

    public static void modify(int a) {
        a = 20; // This only changes the local copy of 'a', not the original variable
    }

    public static void modify(WrapperInt ref) {
        ref.value = 20; // Modifies the actual object's field
    }

    public static void main(String[] args) {
        /*
         * Java stores primitives directly in memory.
         * - Local variables (like 'a') are stored in the stack.
         * - When passing a primitive to a method, a COPY of the value is passed.
         * - This means modifications inside the method do NOT affect the original
         * variable.
         */

        int a = 10; // Primitive integer
        System.out.println("Before modify: " + a); // Output: 10
        modify(a); // Passing 'a' (a copy of 10) to the method
        System.out.println("After modify: " + a); // Output: 10 (Unchanged, since it's pass by value)

        /*
         * Now, let's see how Java handles objects.
         * - When we create an object, it is stored in the heap.
         * - The variable 'ref' stores a REFERENCE to the object (not the object
         * itself).
         * - When passing 'ref' to a method, a COPY of the reference (memory address) is
         * passed.
         * - Since the reference copy still points to the same object in the heap,
         * modifying the object affects the original.
         */

        WrapperInt ref = new WrapperInt(10); // Creating an object with value 10

        System.out.println("Before modify: " + ref.value); // Output: 10
        modify(ref); // Passing 'ref' (a copy of the reference) to the method
        System.out.println("After modify: " + ref.value); // Output: 20 (Object's field modified)
    }
}
