package Package;

public class Driver {
    public void publicDriverFunction(){
        System.out.println("--- Public ---");
        System.out.println("This function is Public, so visible everywhere (inside and outside the package)");
    }

    protected void protectedDriverFunction(){
        System.out.println("--- Protected ---");
        System.out.println("This function is Protected, so only visible within the package and outside the package through child class.");
        System.out.println("If you do not make the child class, it cannot be accessed from outside the package.");
    }

    void defaultDriverFunction(){
        System.out.println("--- Default ---");
        System.out.println("The access level of a default modifier is only within the package.");
        System.out.println("It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.");
    }

    private void privateDriverFunction(){
        System.out.println("--- Private ---");
        System.out.println("The access level of a private modifier is only within the class. It cannot be accessed from outside the class.");
    }

    public void show(){
        System.out.printf("%n%nCalling Driver Class method show: %n");
        publicDriverFunction();
        protectedDriverFunction();
        defaultDriverFunction();
        privateDriverFunction();
    }

}
