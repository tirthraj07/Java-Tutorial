/*
 
Let us first see how we print an output in depth, then we will learn how to take input

When we want to print something, we use System.out.println()

This println() -> is a method of the PrintStream class
Here's a snippet:
public void println(String x) {
    writeln(String.valueOf(x));
}

But we don't declare an object of PrintStream class. Then how can we call it?

Well, in the System class, there is already a static variable called out of the PrintStream Class

public static final PrintStream out = null;

Let us see how to take input

There is an "in" object in the System class, that is of type 'InputStream'

There is a System.in.read() function, but if you store the value in a variable, you would notice that it prints out the ASCII Hex of the number
Also it only fetches one character


For that we can use the BufferReader class
BufferReader obj requires a Reader object for initialization.
If we want to provide the input of the console, we needs to give an object of InputStreamReader
InputStreamReader object requires an InputStream object for initialization.
We already have that in System.in

So now we can use the readLine() function of the BufferedReader. But it returns a string. Thus we need to parse it into an Int


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    public static void main(String[] args) throws IOException{
        System.out.println("Enter a Number");
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        int a = Integer.parseInt(bf.readLine());
        System.out.println(a);
    }
}