/*
Exception Handling:
Exception Handling in Java is one of the effective means to handle runtime errors so that the regular flow of the application can be preserved. 
Java Exception Handling is a mechanism to handle runtime errors such as ClassNotFoundException, IOException, SQLException, RemoteException, etc.

Exceptions are runtime errors
They mainly occur due to following reasons:
- Invalid user input
- Device failure
- Loss of network connection
- Physical limitations (out-of-disk memory)
- Code errors
- Opening an unavailable file

Exception Hierarchy

Object Class -> Throwable -> Exception and Error

Refer: https://media.geeksforgeeks.org/wp-content/uploads/20230613122108/Exception-Handling-768.png

Difference between Exceptions and Errors
Error : An Error indicates a serious problem that a reasonable application should not try to catch.
Exceptions : Exception indicates conditions that a reasonable application might try to catch.


There are mainly two types of Exceptions, User Defined Exceptions and Built in Exceptions
In Built in Exceptions : Checked Exceptions and Unchecked Exceptions

Checked Exceptions:
Checked exceptions are called compile-time exceptions because these exceptions are checked at compile-time by the compiler.

Unchecked Exceptions:
The compiler doesn't check these exceptions. Thus the compiler won't throw compilation error

Methods to print the Exception information:

Exception e

1. e.printStackTrace() -> This method prints exception information in the format of the Name of the exception: description of the exception, stack trace.
2. e.toString() -> The toString() method prints exception information in the format of the Name of the exception: description of the exception.
3. e.getMessage() -> The getMessage() method prints only the description of the exception.

How Does JVM Handle an Exception?
Whenever inside a method, if an exception has occurred, 
the method creates an Object known as an Exception Object and hands it off to JVM. 
The exception object contains the name and description of the exception and the current state of the program where the exception has occurred. 
Creating the Exception Object and handling it in the run-time system is called throwing an Exception

*/


class Main{
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        try{
            j = i/j;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(j);
        
    }
}