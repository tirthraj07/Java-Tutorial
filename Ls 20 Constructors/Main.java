/*
A constructor in Java is a special method that is used to initialize objects.
There are 3 types
Default, Parametrized, Copy
Like C++, Java also supports a copy constructor. 
But, unlike C++, Java doesn’t create a default copy constructor if you don’t write your own.
*/

class myClass{
    private String val;
    public myClass(){
        System.out.println("Default constructor called");
        val = "Default Value";
    }
    public myClass(String val){
        System.out.println("Parametrized constructor called");
        this.val = val;
    }
    public myClass(myClass cpy){
        System.out.println("Copy constructor called");
        this.val = cpy.val;
    }

    public String getVal(){
        System.out.println(this.val);
        return val;
    }
    
}


class Main{
    public static void main(String[] args) {
        myClass def = new myClass();
        def.getVal();
        myClass para = new myClass("New Value");
        para.getVal();
        myClass cpy = new myClass(para);
        cpy.getVal();
    }
}