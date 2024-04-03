/*
From Java Docs:
The String class represents character strings.
All string literals in Java Programs are implemented as instance of this class
A pool of strings, initially empty, is maintained privately by the class String.
String literals with the same content are interned, meaning they are stored only once in memory and reused if encountered again.

*/

public class Main{
    public static void main(String args[]){
        String s = "Hello";
        System.out.println(s);

        // Here, String Literal is created in the string constant pool with content "Hello"
        // Reference of the literal is stored in s

        // -------- x -------- x -------- x -------- x -------- x --------  

        String s1 = "Tirthraj";
        // Here, String Literal is created in the string constant pool
        // Reference of the literal is stored in s1
        String s2 = "Tirthraj";
        // Now instead of creating a new string object, the JVM looks for the String literal in the pool with the same content
        // Thus it returns the reference of the same literal as s1 and stores it in s2
        System.out.println(s1+" : "+s2);
        System.out.println("s1 and s2 reference the same object: s1==s2? " + (s1 == s2));
        // Since s1 and s2 are referencing the same string literal (address), they are deemed equal

        // -------- x -------- x -------- x -------- x -------- x --------  

        String s3 = new String("Mahajan");
        // "Mahajan" is the string literal and it is stored in string constant pool if it doesn't already
        // 'new String()' creates a new String object in the heap memory containing the same character sequence as the string literal "Mahajan"
        // The new keyword ensures that a new object is created in the heap memory, separate from any existing string literals in the string constant pool.
        // The reference to this newly created String object is assigned to the variable s3.

        String s4 = new String("Mahajan");
        // Here, "Mahajan" string literal already exists in the string constant pool. Hence the JVM will not create a new string literal in string constant pool
        // However, due to the 'new' keyword, JVM creates a new string object inside the heap memory that contains the copy (replica) of the string literal "Mahajan"
        // The new keyword ensures that a new object is created in the heap memory regardless of whether the content already exists in the string constant pool.
        // The reference of this newly created String object is assigned to the variable s4
        // Unless an explicit copy of {@code original} is needed, use of this constructor is unnecessary since Strings are immutable.

        System.out.println(s3+" : "+s4);
        System.out.println("s3 and s4 reference different objects: s3==s4? " + (s3 == s4)); 
        // Since s3 and s4 are referencing different String objects regardless of the content, they are deemed unequal
        System.out.println("Contents of s3==s2? " + (s3.equals(s4)));


        // -------- x -------- x -------- x -------- x -------- x --------  

        String s5 = "Tirthraj";
        // String literal "Tirthraj" is created in the string constant pool and its reference is stored in variable s5
        
        String s6 = "Tirthraj";
        // Since the string literal already exists in the pool, the same reference is stored in the variable s6

        System.out.println(s5 + " : " + s6);
        System.out.println("s5==s6? " + (s5==s6) ); // true

        // Thus s5 and s6 are referencing to the same string literal, thus deemed equal

        s5 += " Mahajan";
        // Now JVM creates a new string literal " Mahajan" in string constant pool.
        // It creates a new String object that contains the concatenation of "Tirthraj" literal and " Mahajan" literal
        // And then the reference of the newly created object is stored in s5
        // Note that the result of concatenation "Tirthraj Mahajan" is NOT stored in the string constant pool
        // Thus String are considered immutable in Java

        s6 += " Mahajan";
        // Now JVM does NOT create a new string literal " Mahajan" as it already exists in string constant pool.
        // But it creates a new String object that contains the concatenation of "Tirthraj" literal and " Mahajan" literal
        // And then the reference of the newly created object is stored in s6

        System.out.println(s5 + " : " + s6);
        System.out.println("s5==s6? " + (s5==s6) ); 
        // Since the variables s5 and s6 are referencing to different String objects, they are deemed unequal

    }
}