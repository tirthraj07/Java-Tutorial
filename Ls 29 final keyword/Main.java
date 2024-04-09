/*
    final keyword can be used for variables, functions and classes
    variables -> when you declare a variable final, it becomes a constant. You cannot change it
    class -> when you declare a class final, you cannot extend it further. Inheritance stops their
    functions -> when you declare a function final, it means that you cannot override it in child class
*/

class A{
    final double PIE = 3.1415;
    final void show(){
        // PIE = 3; // error: cannot assign a value to final variable PIE
        System.out.println(PIE);
    }
}

final class B extends A{
    // void show(){} // error: show() in B cannot override show() in A

    void print(){
        // PIE = 3; // error: cannot assign a value to final variable PIE
        System.out.println(PIE);
    }

}

// class C extends B{} // error: cannot inherit from final

class Main{
    public static void main(String[] args) {
        B obj = new B();
        obj.print();
    }
}