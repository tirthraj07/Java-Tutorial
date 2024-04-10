/*
Abstract Class in Java

In Java, abstract class is declared with the abstract keyword. It may have both abstract and non-abstract methods(methods with bodies).

Java abstract class is a class that can not be initiated by itself, 
it needs to be subclassed by another class to use its properties. 
An abstract class is declared using the “abstract” keyword in its class definition.

We can have an abstract class without any abstract method.
Abstract methods cannot have a body

If the Child class is unable to provide implementation to all 
abstract methods of the Parent class then we should declare that 
Child class as abstract so that the next level Child class 
should provide implementation to the remaining abstract method.

*/

abstract class Shape{
    int color;
    public abstract void draw();
}

/*
 * In C++, to declare an abstract class, you would have to define a pure virtual function as there is no 'abstract' keyword in C++
 * 
 * class Shape{
 * private:
 *  int color;
 * public:
 *  virtual void draw() = 0;
 * };
 * 
 * 
 * By default, all functions of Java (except 'final' or 'static') are virtual functions.
 * Thus we use 'abstract' keyword for method to represent a 'PURE' virtual function
 * 
 */

class Square extends Shape{
    public void draw(){
        System.out.println("Drawing Square.. ");
    }
}


class Main{
    public static void main(String[] args) {
        Shape s = new Square();
        s.draw();
    }
}