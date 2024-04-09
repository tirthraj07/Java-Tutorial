class Base{
    public void function(){
        System.out.println("This function is defined in Base Class");
    }
}

class Derived extends Base{
    public void function(){
        System.out.println("This function is overridden in Derived Class");
    }
}



class Main{
    public static void main(String[] args) {
        Derived d = new Derived();
        d.function();
    }
}