/*
Java provides us the facility to create our own exceptions which are basically derived classes of Exception. Creating our own Exception is known as a custom exception or user-defined exception.

*/


class MyException extends Exception{
    public MyException(){
        super();
    }
    public MyException(String s){
        super(s);
        // Call constructor of parent Exception
    }
}


class Main{
    public static void main(String[] args){
        
        try{
            throw new MyException("This is my custom exception");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}