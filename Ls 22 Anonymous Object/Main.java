/*
In Java, an anonymous object is an object that is created without giving it a name. 
Anonymous objects are often used to create objects on the fly and pass them as arguments to methods. 

When we say MyClass obj = new MyClass();
There are two things which are happening
1. Declaring reference
2. Creation of object

We know that 'obj' is not the object but a REFERENCE of the object
Thus we can divide the above line into 2 lines
MyClass obj; // Declaring the reference
obj = new MyClass() ; Creating the object

When we declare a reference in the first line, Java store the reference in stack memory
When we create an object, java creates an object in heap memory
Then the reference is initialized with address of the object created in heap 

But sometimes we don't want to create a new variable for calling the method of a class 
This is where we use Anonymous objects

Anonymous objects are nothing but objects that are not assigned to a reference. That means, the object is created in heap but the reference is not created and stored in stack
This can be done by just using 'new MyClass()' -> to create an object
This process of creating the object and not assigning it to reference is called Anonymous objects


As these objects are not stored in variables, we cannot retain them. Thus we would have to create a new object for every function call
*/

class MyClass{
    public MyClass(){
        System.out.println("Constructor is Called");
    }

    public void function(){
        System.out.println("You are in a function");
    }
}

class Main {
    public static void main(String[] args) {
        new MyClass();
        
        new MyClass().function();
    }    
}
