/*
A lambda expression is a short block of code which takes in parameters and returns a value. 
Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

E.g 1
parameter -> expression

E.g 2
(parameter1, parameter2) -> expression

E.g 3
(parameter1, parameter2) -> { code block }

*/

@FunctionalInterface
interface A{
    void show();
}

class Main{
    public static void main(String[] args){

        // Since A is Functional Interface, i.e only one function has to be implemented, 

        A obj = () -> {
            System.out.println("In A show");
        };

        obj.show();
    }
}