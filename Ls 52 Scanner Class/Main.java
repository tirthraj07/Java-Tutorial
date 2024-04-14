/*

Scanner class was introduced in Java 1.5

Difference between Scanner and BufferedReader

- BufferedReader is synchronized (thread-safe) while Scanner is not
- Scanner can parse primitive types and strings using regular expressions
- BufferedReader allows for changing the size of the buffer while Scanner has a fixed buffer size
- BufferedReader has a larger default buffer size
- Scanner hides IOException, while BufferedReader forces us to handle it
- BufferedReader is usually faster than Scanner because it only reads the data without parsing it

*/

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        System.out.println("Enter A Number");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a);
    }
}