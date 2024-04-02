/*
https://www.geeksforgeeks.org/variables-in-java

There are three types of variables in Java
1. Local Variables
2. Instance Variables
3. Static Variables 

1. Local Variables:
A variable defined within a block or method or constructor is called a local variable. 
These variables are created when the block is entered, or the function is called and destroyed after exiting from the block or when the call returns from the function.

2. Instance Variables:
Instance variables are non-static variables and are declared in a class outside of any method, constructor, or block. 
They belong to each instance of the class and have separate copies for each instance.

3. Static Variables:
Static variables are also known as class variables. 
These variables are declared similarly to instance variables. The difference is that static variables are declared using the static keyword within a class outside of any method, constructor, or block.
They belong to the class itself rather than any specific instance of the class and have only one copy shared by all instances of the class.

*/

class myClass{
    // Instance variable declaration
    public String instanceVariable = "I am instance variable";
    // Static variable declaration
    public static String staticVariable = "I am a static variable";
}


public class Main{
    public static void main(String[] args) {
        // Local variable declaration
        String local = "I am a local variable";
        System.out.println(local);

        myClass obj1 = new myClass();
        myClass obj2 = new myClass();

        // Accessing instance variable using object
        System.out.println(obj1.instanceVariable);
        // Modifying instance variable using object
        obj2.instanceVariable = "Changed Instance variable";
        System.out.println(obj2.instanceVariable);

        // Accessing static variable using object
        System.out.println(obj1.staticVariable);
        // Modifying static variable using object
        obj1.staticVariable = "Changed Static variable";
        System.out.println(obj2.staticVariable);

        // Accessing static variable directly using class name
        System.out.println(myClass.staticVariable);

    }
}
