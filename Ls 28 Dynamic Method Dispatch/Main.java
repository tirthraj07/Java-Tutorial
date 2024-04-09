/*

This code may be confusing if you are coming from C++ Background!
Please Read Notes.md

*/

class A{
    public void show(){
        System.out.println("In A Show");
    }
}

class B extends A{
    public void show(){
        System.out.println("In B Show");
    }
}

public class Main{
    public static void main(String[] args) {
        A ref = new B();
        ref.show(); // Prints "In B Show"
        // Irrespective of the reference type, Java will consider the type of object and then call the method
    }
}