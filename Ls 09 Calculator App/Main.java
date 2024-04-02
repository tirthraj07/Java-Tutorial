class Calculator{
    public int add(int a, int b){
        return a+b;
    }
    public int sub(int a, int b){
        return a-b;
    }
    public int mul(int a, int b){
        return a*b;
    }
    public int div(int a, int b){
        return a/b;
    }
}

public class Main{
    public static void main(String[] args) {
        int a = 10, b = 5;
        Calculator calc = new Calculator();
        System.out.println("Addition : "+calc.add(a,b));
        System.out.println("Subtraction : "+calc.sub(a,b));
        System.out.println("Multiplication : "+calc.mul(a,b));
        System.out.println("Division : "+calc.div(a,b));
    }
}