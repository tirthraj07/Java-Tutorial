/*

A Wrapper class in Java is a class whose object wraps or contains primitive data types.
we can wrap a primitive value into a wrapper class object.

In Java, primitive data are directly stored on the stack

Objects are stored inside the heap memory

The classes in java.util package handles only objects and hence wrapper classes help in this case.
Data structures in the Collection framework, such as ArrayList and Vector, store only objects
An object is needed to support synchronization in multithreading.

char -> Character
byte -> Byte
short -> Short
int -> Integer
long -> Long
float -> Float
double -> Double
boolean -> Boolean

When you convert a primitive data or variable into a object of their corresponding wrapper class, it is called boxing
When there is an automatic / implicit conversion of the primitive data into object of wrapper class, it is called auto-boxing

When you convert the object of the wrapper class into a primitive data type it is called Unboxing
When there is an automatic conversion, it is called auto-unboxing

*/

class Main{
    public static void main(String[] args) {
        
        // boxing
        int a = 10;
        Integer num1 = new Integer(a); // deprecated

        // auto-boxing
        int b = 20;
        Integer num2 = b; 

        // unboxing
        Integer num3 = 30;
        int c = num3.intValue();

        // auto-unboxing
        Integer num4 = 40;
        int d = num4; 

        // You can also do this
        String num5 = "50";
        int e = Integer.parseInt(num5);
        System.out.println(e+10);  // Prints 60

    }

}