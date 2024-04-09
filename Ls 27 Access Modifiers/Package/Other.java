package Package;

public class Other {
    public void show(){
        System.out.printf("%n%nCalling Other Class method show: %n");
        Driver d = new Driver();
        d.publicDriverFunction();
        d.protectedDriverFunction();
        d.defaultDriverFunction();
        // d.privateDriverFunction(); // You cannot access the private variables/functions outside of the class
    }
}
