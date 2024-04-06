/*
The extends keyword is used for inheritance in Java. 
Using the extends keyword indicates you are derived from an existing class. 
In other words, “extends” refers to increased functionality.

We will learn about inheritance in depth in upcoming lessons.

super is also used to invoke super-class’s method or constructor.
it can be used to refer immediate parent class instance variable
it can be used to refer immediate parent class method
it can be used to refer immediate parent class constructor.

'this' is a reserved key word to invoke or initiate current class constructor or to refer instance variable of current class

When we instantiate an object of Derived class, Java by default calls the constructor of the super class.
There is an implicit super(); in the constructor of each class that calls the super class / Parent class constructor
*/

class Base{
    public Base(){
        super();        // This is implicit by default, but we can explicitly mention it as well.

        /*
         * But what exactly is it calling?
         * We haven't explicitly extended any class to Base Class.
         * Then what does super actually call?
         * Well, by default, all Classes in java extend the 'Object' class which is built in
         * So super() calls the constructor of the Object class which is empty constructor
         */

        System.out.println("This is default constructor of Base Class");
    }

    public Base(int a){
        super();
        System.out.println("This is parametrized constructor of Base Class");
    }
}

class Derived extends Base{
    public Derived(){
        /*
         * Say if we wanted to call the parametrized constructor of the Derived class.
         * We can do that using this(); keyword. By passing the parameter in this(), it will call the parametrized constructor of the class instance class
         * If we provide no arguments, then it will call the default constructor of the instance class
        */

        this(5);
        System.out.println("This is default constructor of Derived Class");
    }

    public Derived(int a){
        // super(); This is implicit in nature. So whenever you call the parametrized constructor of a class, it will call the DEFAULT constructor of super class
        // But what if we want to call the parametrized constructor of the super class also?
        // We can pass the parameter in the super() function which will invoke the parameterized constructor of the super class
        super(a);
        System.out.println("This is parametrized constructor of Derived Class");
    }
}

/*
 * We can also explicitly mention to extend from the 'Object' class.
 * From Docs:
 * Class {@code Object} is the root of the class hierarchy.
 * Every class has {@code Object} as a superclass. All objects,
 * including arrays, implement the methods of this class.
 * 
 public class Object {

    // Constructs a new object.
    @IntrinsicCandidate
    public Object() {} // As you can see, it is an empty constructor

 */

class tempClass extends Object {
    public tempClass(){
        super(); // Calls the constructor of the 'Object' class
        /*
         * As you can see from the Docs, the constructor of Object class is empty
         * This it does not do anything.
         */
    }
}

public class Main{
    public static void main(String[] args) {
        Derived a = new Derived();
        Derived b = new Derived(10);
    }
}