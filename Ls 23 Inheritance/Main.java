import java.lang.Math;

class Calculator{
    public int add(int a ,int b){
        return a+b;
    }
    public int sub(int a,int b){
        return a-b;
    }
    public int div(int a, int b){
        return a/b;
    }
    public int mul(int a, int b){
        return a*b;
    }
}

class ScientificCalc extends Calculator{
    public double sine(double deg){
        double radians = Math.toRadians(deg);
        return Math.sin(radians);
    }
    public double cos(double deg){
        double radians = Math.toRadians(deg);
        return Math.cos(radians);
    }
    public double tan(double deg){
        double radians = Math.toRadians(deg);
        return Math.sin(radians);
    }
    public double exponent(double a, double b){
        return Math.pow(a, b);
    }

}

class Main{
    public static void main(String args[]){
        ScientificCalc calc = new ScientificCalc();
        System.out.println(calc.add(5,10));
        System.out.println(calc.sub(5,10));
        System.out.println(calc.mul(5,10));
        System.out.println(calc.div(5,10));
        System.out.println(calc.exponent(5,10));
        System.out.println(calc.sine(30));
        System.out.println(calc.cos(60));
        System.out.println(calc.tan(45));


    }
}