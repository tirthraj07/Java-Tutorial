import Package.*;

class Child extends Driver {
    public void show(){
        System.out.printf("%n%nCalling Child Class method show: %n");
        publicDriverFunction();
        protectedDriverFunction();
        // defaultDriverFunction();
        // privateDriverFunction();
    }
}

public class Main {
    public void show(){
        System.out.printf("%n%nCalling Main Class method show: %n");
        Driver d = new Driver();
        d.publicDriverFunction();
        // d.protectedDriverFunction();
        // d.defaultDriverFunction();
        // d.privateDriverFunction();
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.show();

        Other other = new Other();
        other.show();

        Child child = new Child();
        child.show();

        Main main = new Main();
        main.show();
    }    

}
