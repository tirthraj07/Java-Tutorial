class MyClass{
    public void myFunc(){
        System.out.println("This is my Func inside MyClass");
    }
}

public class Main{
    public static void main(String args[]){
        MyClass myObj = new MyClass();
        // MyClass myObj; -> Creates a reference. To store an object, we need to use 'new' keyword
        myObj.myFunc();
    }
}