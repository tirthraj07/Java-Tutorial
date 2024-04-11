/*
 
There are three types of Interfaces:
1. Normal Interfaces:
The interfaces containing two or more functions

2. Functional Interface:
Functional Interface is an interface that has only pure one abstract method.

3. Marker interface

An interface that does not contain any methods, fields, Abstract Methods, and any Constants is Called a Marker interface.

Also, if an interface is empty, then it is known as Marker Interface.

The Serializable and the Cloneable interfaces are examples of Marker interfaces.


Cloneable interface :
Cloneable interface is present in java.lang package. 
There is a method clone() in Object class. 
A class that implements the Cloneable interface indicates that it is legal for clone() method to make a field-for-field copy of instances of that class. 
Invoking Object’s clone method on an instance of the class that does not implement the Cloneable interface results in an exception CloneNotSupportedException being thrown. 
By convention, classes that implement this interface should override Object.clone() method. 

Serializable interface : 
Serializable interface is present in java.io package. 
It is used to make an object eligible for saving its state into a file. This is called Serialization. 
Classes that do not implement this interface will not have any of their state serialized or deserialized. 
All subtypes of a serializable class are themselves serializable.

*/

@FunctionalInterface
interface A{
    void show();
}


class Main{
    public static void main(String[] args){
        System.out.println("Hello World");
    }
}