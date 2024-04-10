class A{
    public void aShow(){
        System.out.println("in A show");
    }
}

class B extends A{
    public void bShow(){
        System.out.println("in B show");
    }
}

class Main{
    public static void main(String[] args){
        A ref = new B();
        ref.aShow();
        //ref.bShow();        // error: cannot find symbol

        /*
         * Why does this happen?
         * When you say 'new B()' -> it creates an object of B
         * However, it is assigned to reference of class A
         * Thus implicitly, Java converts the object of B to object of A
         * So it type casts the object of B to A
         * This is called "upcasting" 
        */

        A obj = (A) new B();        // This is what is happening internally

        /*
         * Due to this, the object doesn't know that the method 'bShow()' exists
         * If we still want to use it, we need to convert the object in object of B
         * This is called 'downcasting'
        */

        B obj1 = (B) obj; // Converting the object of A into B. This is downcasting

        obj1.bShow();

    }
}