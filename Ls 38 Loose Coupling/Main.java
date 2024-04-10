/*
The code example demonstrates loose coupling through the use of interfaces

*/

interface Computer{
    void code();
}

class Desktop implements Computer{
    public void code(){
        System.out.println("Code, Compile, Run -> Faster");
    }
}

class Laptop implements Computer{
    public void code(){
        System.out.println("Code, Compile, Run -> Slower");
    }
}

class Employee{
    /*
        The Employee class only depends on the Computer interface, rather than concrete implementations (Desktop or Laptop), thus achieves loose coupling. 
    */
    public void Development(Computer c){
        c.code();
    }
}

class Main{
    public static void main(String[] args){
        Employee e1 = new Employee();
        e1.Development(new Desktop());

        Employee e2 = new Employee();
        e2.Development(new Laptop());

    }
}