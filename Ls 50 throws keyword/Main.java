/*

The Java throws keyword is used to declare an exception. 
It gives an information to the programmer that there may occur an exception. 
So, it is better for the programmer to provide the exception handling code so that the normal flow of the program can be maintained.


Suppose a method contains a 'critical' statement (Which may throw an exception). You can either surround the statement in a try-catch block their itself
**OR**
Let the function calling the method handle the exception.
So you mark the method that it may throw an Exception -> throws keyword
*/

class A {
    
    // So instead of handling the error in the divide function, we let the parent method handle the error
    public int divide(int p, int q) throws ArithmeticException {
        return p/q;
    }

}

class Main{
    public static void main(String[] args){
        int i=0, j=0;
        A obj = new A();

        try{
            System.out.println(obj.divide(i,j));
        }
        catch(ArithmeticException e){
            System.out.println("This error has been propagated from the divide function in class A");
            System.out.println(e.getMessage());
        }

        System.out.println("Thanks for using");

    }
}