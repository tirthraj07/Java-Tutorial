/*
    Java AtomicInteger Tutorial
    This tutorial explains AtomicInteger, why it's used, and how it differs from regular integers.
*/

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    /*
     * AtomicInteger is a part of java.util.concurrent.atomic package.
     * It provides a way to perform atomic operations on an int value.
     * Unlike a normal int, AtomicInteger ensures thread-safety without
     * synchronization.
     */

    // Creating an AtomicInteger instance
    private static AtomicInteger atomicInt = new AtomicInteger(0);

    /*
     * This method increments the atomic integer safely.
     * Since AtomicInteger uses low-level CPU instructions (CAS - Compare And Swap),
     * it avoids race conditions in multithreaded environments.
     */
    public static void increment() {
        atomicInt.incrementAndGet(); // Atomically increments the value by 1
    }

    public static void main(String[] args) {
        /*
         * Demonstrating how AtomicInteger works in a multi-threaded scenario.
         * We spawn multiple threads that increment the same AtomicInteger.
         */

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         * The final value should be 2000 because AtomicInteger ensures atomic
         * operations.
         * If we had used a normal int with incrementing inside multiple threads,
         * the result might have been inconsistent due to race conditions.
         */
        System.out.println("Final value: " + atomicInt.get()); // Output: 2000
    }
}
