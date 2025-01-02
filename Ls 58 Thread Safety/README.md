# Thread Safety

When multiple threads are working on the same data, and the value of our data is changing, that scenario is not thread-safe and we will get inconsistent results. 

When a thread is already working on an object and preventing another thread on working on the same object, this process is called Thread-Safety. 

There are <b>four ways</b> to achieve <b>Thread Safety</b> in Java. These are:

1. Using Synchronization.
2. Using Volatile Keyword.
3. Using Atomic Variable.
4. Using Final Keyword.

### <u> Using Synchronization </u>

Synchronization is the process of allowing only <b>one thread at a time</b> to complete the particular task. It means when <b>multiple threads</b> executing simultaneously, and want to access the <b>same resource</b> at the same time, then the problem of inconsistency will occur. so synchronization is used to resolve inconsistency problem by <b>allowing only one thread at a time</b>.   

Synchronization uses a <b>synchronized</b> keyword. Synchronized is the modifier that creates a block of code known as a critical section. 


### <u> Using Volatile keyword </u>

For Java, “volatile” tells the compiler that the value of a variable must never be cached as its value may change outside of the scope of the program itself

Before we move on let’s take a look at two important features of locks and synchronization. 

1. __Mutual Exclusion__: It means that only one thread or process can execute a block of code (critical section) at a time.

2. __Visibility__: It means that changes made by one thread to shared data are visible to other threads.

Java’s synchronized keyword guarantees both mutual exclusion and visibility. If we make the blocks of threads that modify the value of the shared variable synchronized only one thread can enter the block and changes made by it will be reflected in the main memory. All other threads trying to enter the block at the same time will be blocked and put to sleep. 

In some cases, we may only desire visibility and not atomicity. The use of synchronized in such a situation is overkill and may cause scalability problems. Here volatile comes to the rescue. Volatile variables have the visibility features of synchronized but not the atomicity features. The values of the volatile variable will never be cached and all writes and reads will be done to and from the main memory. 

However, the use of volatile is limited to a very restricted set of cases as most of the times atomicity is desired. 

For example, a simple increment statement such as x = x + 1; or x++ seems to be a single operation but is really a compound read-modify-write sequence of operations that must execute atomically. 

### <u> Using Atomic Variable </u>

Using an atomic variable is another way to achieve thread-safety in java. When variables are shared by multiple threads, the atomic variable ensures that threads don’t crash into each other. 

### <u> Using Final keyword  </u>

Final Variables are also thread-safe in java because once assigned some reference of an object It cannot point to reference of another object.