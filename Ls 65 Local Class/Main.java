/*
Local Classes in Java

A local class is a class defined within a block of code—typically inside a method, constructor, or an initializer block. 
Because they are defined within a method, their scope is limited to that block. 
They’re similar to inner classes but with even more restrictive access.

- No Static Declarations: A local class cannot have static declarations (except for constant variables—static final fields). This restriction exists because a local class is tied to a specific invocation context.
- The local class is not visible outside the method (or block) where it is defined, which can sometimes limit its utility.
*/

// Example Snippet

class Outer {
    public void method() {

        class LocalClass {
            public void display() {
                System.out.println("Inside LocalClass");
            }
        }

        LocalClass local = new LocalClass();
        local.display();

    }
}

public class Main {
    public static void main(String[] args) {
        new Outer().method(); // Inside LocalClass
    }
}

/*
Access to Variables and Members

A local class can access all members (even private ones) of its enclosing
class.
A local class can also access variables and parameters defined in the
enclosing method—but with an important condition: They must be final or
effectively final.

*/

// Example Snippet

class Outer {
    private int privateValue = 100;

    public void method(int paramValue) {
        int localVar = 50; // 'localVar' is effectively final if not changed after initialization

        class LocalClass {
            public void display() {

                System.out.println("privateValue = " + privateValue);

                System.out.println("paramValue = " + paramValue);

                System.out.println("localVar = " + localVar);

            }
        }

        LocalClass local = new LocalClass();
        local.display();
    }

}

public class Main {
    public static void main(String[] args) {
        new Outer().method(75);
        // privateValue = 100
        // paramValue = 75
        // localVar = 50
    }
}

/*
Lifetime
They live as long as there are references to them and are managed by Java’s
garbage collector.

A local class instance can live longer than the method execution if a
reference to it "escapes" from the method.
This happens when the method returns an instance of the local class or stores
it in a field that outlives the method’s execution.
*/

// Example Snippet

interface Task {
    void execute();
}

class Outer {
    public Task getTask() {

        class LocalTask implements Task {
            @Override
            public void execute() {
                System.out.println("Executing LocalTask..");
            }
        }

        return new LocalTask();
    }

}

class Main {
    public static void main(String[] args) {
        // Getting a reference to the local class instance
        Task task = new Outer().getTask();

        // The method 'getTask' has already finished, but we can still use the object
        task.execute(); // Executing LocalTask..
    }
}
