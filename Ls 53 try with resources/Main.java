/*

Support for try-with-resources — introduced in Java 7 — allows us to declare resources to be used in a try block with the assurance that the resources will be closed after the execution of that block.

The resources declared need to implement the AutoCloseable interface


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("Enter a number: ");
            int num = Integer.parseInt(br.readLine());
            System.out.println(num);
        }


    }
}