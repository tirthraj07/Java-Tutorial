/*
The JVM memory manager creates memory pools during the runtime of the program
When a variable is declared static in Java programming, it means that the variable belongs to the class itself rather than to any specific instance of the class. This means that there is only one copy of the variable in memory, regardless of how many instances of the class are created.
Since these methods and variables cannot be stored in a normal heap, they are stored in a special area called permanent generation(PermGen).
Note: In Java 5 and 6, PermGen space was used. 
But due to major changes in memory model in Java 8, storage specification has also been changed. 
Now a new memory space “MetaSpace” has been introduced where all the names fields of the class, methods of a class with the byte code of methods, constant pool, JIT optimizations are stored. 
The main reason for this change of PermGen in Java 8.0 is that it is tough to predict the size of PermGen, and it helps in improving garbage collection performance.

When we create an object, there are 2 things which are happening
1. Class Loading
2. Objects are instantiated 

So when classes are loaded, all the static variables are instantiated
Thus static block runs before the constructor

So what if we do not create an object?
Well, the static block does not run, and the class doesn't get instantiated
Still, if we want to instantiate a class and its static variables, without creating an object, we can do that
using java's built in 'Class' class

Method of the class is 'forName' -> which is used to load the class irrespective of the fact that the object is created or not
Class.forName("<Name-of-the-class>");
it throws an exception ClassNotFoundException; but we will talk about them later

*/
class Mobile{
    String company, name;
    int price;
    static String type;

    // Static Block -> It will be called only once.
    // Static block is called before the constructor in Java
    static{
        type = "Smart Phones";
        System.out.println("This is static block");
    }

    public Mobile(){
        System.out.println("This is constructor");
    }

    public Mobile(String company){
        this.company = company;
    }

    public void show(){
        // You can use static variable in a non static function
        System.out.println("Company: "+company+" Name: "+name+" Price: "+price+" Type : "+type);
    }

    public static void count(){
        System.out.println("This is a static function");
        System.out.println("Type : "+type); // You can call static variables in static function
        // System.out.println("Company: "+company+" Name: "+name+" Price: "+price);
        // You cannot call non static variables in a static function
        // But you can pass an object as argument or create a new object
        System.out.println(new Mobile("Nothing Phone").company);
    }


}

/*
 
The main() method is marked static so that the JVM may call it without having to create an instance of the class that contains the main() function
There is no object of the class available at the time of starting java runtime, and because of that, we have to define the main() method as static. 
By doing that, JVM can load the class into the main memory and call the main() method.
So, if we define main() method as non-static method, JVM would not be able to call it and throws error

*/


public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        Class.forName("Mobile");

        Mobile.count();
        
        System.out.println("Creating objects after this line");
        Mobile m1 = new Mobile();
        m1.company = "Apple";
        m1.name = "Iphone 15";
        m1.price = 1500;

        Mobile m2 = new Mobile();
        m2.company = "Samsung";
        m2.name = "S21";
        m2.price = 1700;

        m1.show();
        m2.show();

        Mobile.type = "Phones";

        m1.show();
        m2.show();

    }    
}