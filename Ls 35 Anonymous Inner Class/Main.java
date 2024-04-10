/*
anonymous Inner class is an inner class without a name and for which only a single object is created. 
An anonymous inner class can be useful when making an instance of an object with certain “extras” such as overriding methods of a class or interface, without having to actually subclass a class. 
*/

class A{
    public void show(){
        System.out.println("in A show");
    }
}

class Main{
    public static void main(String[] args) {
        A obj = new A(){
            public void show(){
                System.out.println("in Anonymous Inner Class show");
            }
        };

        obj.show();

        A obj2 = new A();
        obj2.show();

        A obj3 = new A(){
            public void show(){
                System.out.println("in new show");
            }
        };

        obj3.show();
        
    }
}