/* 
StringBuffer is a class in Java that represents a mutable sequence of characters. 
It provides an alternative to the immutable String class, allowing you to modify the contents 
of a string without creating a new object every time.
A thread-safe, mutable sequence of characters.
A string buffer is like a String, but can be modified. At any point in time it contains some 
particular sequence of characters, but
the length and content of the sequence can be changed through certain method calls.

String buffers are safe for use by multiple threads. 
The methods are synchronized where necessary so that all the operations on any particular 
instance behave as if they occur in some serial order that is consistent with the order of the 
method calls made by each of the individual threads involved.

*/

public class Main{
    public static void main(String[] args) {
        StringBuffer sbuff1 = new StringBuffer("Tirthraj");
        StringBuffer sbuff2 = new StringBuffer("Tirthraj");

        System.out.println("sbuff1==sbuff2? " + (sbuff1==sbuff2));

        // ---------- x ---------- x ---------- x ----------

        StringBuffer sbuff3 = sbuff1;
        System.out.println("sbuff1==sbuff3? " + (sbuff1==sbuff3));
        sbuff3.append(" Mahajan");
        System.out.println(sbuff1);
        System.out.println(sbuff3);
        System.out.println("sbuff1==sbuff3? " + (sbuff1==sbuff3));

    }
}