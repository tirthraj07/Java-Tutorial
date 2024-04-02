// https://www.geeksforgeeks.org/operators-in-java/?ref=lbp

public class Main {
    public static void main(String[] args) {
        int num = 5;
        int num2 = 10;
        // Arithmetic Operators : + - * / %
        System.out.println(num+num2);
        System.out.println(num-num2);
        System.out.println(num*num2);
        System.out.println(num/num2);
        System.out.println(num%num2);

        // Unary Operators: -(num), +(num), ++(num), --(num), (num)++, (num)--, !(bool)
        System.out.println(num); // 5
        System.out.println(num++); // 5
        System.out.println(++num); // 7
        System.out.println(num--); // 7
        System.out.println(--num); // 5
        
        // Assignment Operators: =, +=, -=, *=, /=, %=
        num+=1;
        num-=1;
        num*=1;
        num/=1;
        num%=1;
        System.out.println(num);

        // Relation Operators: ==, !=, <, <=, >, >=
        int a=10, b=3, c=5;
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));
        System.out.println("a == c: " + (a == c));
        System.out.println("a != c: " + (a != c));

        // Logical Operators: &&, ||, !
        boolean x = true;
        boolean y = false;
      
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));

        // Ternary operator
        int result
            = ((a > b) ? (a > c) ? a : c : (b > c) ? b : c);
        System.out.println("Max of three numbers = "
                           + result);

        // Bitwise Operators: &, |, ^, ~
        int d = 0b1010;
        int e = 0b1100;
        System.out.println("d & e: " + (d & e));
        System.out.println("d | e: " + (d | e));
        System.out.println("d ^ e: " + (d ^ e));
        System.out.println("~d: " + (~d));
        System.out.println("d << 2: " + (d << 2));
        System.out.println("e >> 1: " + (e >> 1));
        System.out.println("e >>> 1: " + (e >>> 1));


        // Shift Operators: <<, >>, >>>
        int f = 10;
    
          // using left shift
        System.out.println("f<<1 : " + (f << 1));
      
        // using right shift
        System.out.println("f>>1 : " + (f >> 1));
    }    
}
