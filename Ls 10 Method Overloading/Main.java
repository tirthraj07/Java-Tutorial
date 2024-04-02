// https://www.geeksforgeeks.org/method-overloading-in-java/
// Different Ways of Method Overloading in Java
// Changing the Number of Parameters.
// Changing Data Types of the Arguments.
// Changing the Order of the Parameters of Methods

class Calculator{
    public int add(int a, int b){
        return a+b;
    }
    public double add(double a, double b){
        return a+b;
    }
    public String add(String a, String b){
        return a+b;
    }
    public int add(int a, int b, int c){
        return a+b+c;
    }
}

public class Main{
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(1,2));
        System.out.println(calc.add(1.2343,2.3442));
        System.out.println(calc.add("ABC","DEF"));
        System.out.println(calc.add(1,2,3));

    }
}