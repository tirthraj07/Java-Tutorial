/*
Anonymous Inner class can be used to implement the methods which are defined abstract in abstract class
*/

abstract class A{
    public abstract void show();
    public abstract void config();
}


class Main{
    public static void main(String[] args) {
        A obj = new A(){
            public void show(){
                System.out.println("In new show.. ");
            }
            public void config(){
                System.out.println("In new config.. ");
            }
        };

        obj.show();
        obj.config();
    }
}