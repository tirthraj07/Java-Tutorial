/*
Explain the Garbage Collection concept in Java Programming with code example
*/

public class GarbageCollectionExample {
    public static void main(String[] args) {
        GarbageCollectionExample obj1 = new GarbageCollectionExample();
        GarbageCollectionExample obj2 = new GarbageCollectionExample();

        // Nullifying the reference
        obj1 = null;

        // Assigning reference to another object
        obj2 = new GarbageCollectionExample();

        // Requesting JVM for running Garbage Collector
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collector called and object collected");
    }
}

/*
Output:
Garbage collector called and object collected
Garbage collector called and object collected


Nullifying obj1:
The object initially referenced by obj1 becomes eligible for garbage collection because there are no more references to it.

Reassigning obj2:
The object initially referenced by obj2 also becomes eligible for garbage collection when obj2 is assigned a new GarbageCollectionExample object.

Calling System.gc():
This method suggests that the JVM runs the garbage collector, but it does not guarantee immediate execution.


The call to System.gc() is merely a suggestion, and the garbage collection might not occur immediately or even within the program's execution time.
The finalize() method is not guaranteed to be called.
*/