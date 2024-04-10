/*
In Multiple inheritances, one class can have more than one superclass and inherit features from all parent classes. 
Please note that Java does not support multiple inheritances with classes. 
In Java, we can achieve multiple inheritances only through Interfaces. 
In the image below, Class C is derived from interfaces A and B. 
*/

interface A{
    void show();
    void config();
}

interface B{
    void show();
    void drive();
}

interface C extends A,B{}

class myClass implements C{     // or you can say implements A,B if you don't want to declare a new interface C that extends A,B
    public void show(){
        System.out.println("In Show");
    }
    public void config(){
        System.out.println("In Config");
    }
    public void drive(){
        System.out.println("In Drive");
    }
}

class Main{
    public static void main(String[] args) {
        myClass obj = new myClass();
        obj.show();
        obj.config();
        obj.drive();
    }
}