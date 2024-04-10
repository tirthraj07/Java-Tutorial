/*
Inner class refers to the class that is declared inside class or interface 
which were mainly introduced, to sum up, same logically relatable classes 

- Making code clean and readable.
- Private methods of the outer class can be accessed, so bringing a new dimension and making it closer to the real world.
- Optimizing the code module.

Inner classes can be static. Outer class cannot be static

To instantiate a non-static inner class, we need an object of the outer class
To instantiate a static inner class, we do not require an object of outer class, just the name of class
*/

class Outer{

    public void show(){
        System.out.println("In Show.. ");
    }

    class Inner{
        public void config(){
            System.out.println("In Config.. ");
        }
    }

    static class StaticInner{
        public void settings(){
            System.out.println("In Settings.. ");
        }
    }



}

class Main{
    public static void main(String[] args){
        // Creating an object of outer class

        Outer out = new Outer();
        out.show();
        // out.config();        // Will not work as it is out of scope
        // out.settings();      // Will not work as it is out of scope
        

        //  Creating an object of non-static inner class
        // We need to instantiate object of Outer to create an object of inner
        Outer.Inner in = new Outer(). new Inner();
        // in.show();   // Out of scope
        in.config();
        // in.settings();   // Out of scope
    
        // Creating an object of a static inner class

        Outer.StaticInner stin = new Outer.StaticInner();
        stin.settings();
    
    }
}