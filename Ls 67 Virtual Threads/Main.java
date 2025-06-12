/*
Refer: https://youtu.be/aXGrR8Q9_ak?si=kv3DGNMY_1Mw7qzp
-- Types of Threads in Java --

In Java 21, threads are classified more clearly due to the introduction of Virtual Threads as a stable feature.
Java 21 supports two primary types of threads:

1. Platform Threads:
Traditional threads, backed by native OS threads.
Each Java platform thread maps directly to an operating system thread.
Heavier and more expensive to create/manage.

2. Virtual Threads (Stable in Java 21)
New lightweight threads, introduced in Project Loom.
Managed by the JVM, not backed by OS threads.
Use a small number of carrier threads internally.
Ideal for high-concurrency applications (e.g., servers, async I/O).
---
Note:
Virtual threads are powerful, but not a magic fix for all concurrency problems. They dramatically improve scalability for blocking I/O,
1. Use Virtual Threads for Blocking Tasks
    Ideal for I/O-bound work (e.g., HTTP calls, DB access, file I/O).
    They’re cheap to block because they don’t block an OS thread

2. Use Thread.sleep() or I/O with Virtual Threads
    These are "safe blocking" operations that park the virtual thread instead of consuming an OS thread.
    The JVM handles them efficiently.

3. Use Virtual Threads with Executors
    Use Executors.newVirtualThreadPerTaskExecutor() to spawn one per task.
    Better than manually creating threads in a loop.

4. Don’t Do CPU-Intensive Work on Virtual Threads
    They're not for heavy computation (e.g., video encoding, hashing loops).
    Use a bounded thread pool or ForkJoinPool for CPU-bound tasks.

5. Don’t Synchronize on Long Blocking Code
    'synchronized' blocks hold carrier threads.
    Virtual threads don’t help here — they get pinned.
    Instead: Use ReentrantLock or Semaphore, which can avoid pinning in most cases.

6. Don’t Use Virtual Threads for High-Throughput Low-Latency Real-Time Systems
    Platform threads may still be more predictable in real-time or low-latency scenarios.

---
-- Threads based on the behavior --
Regardless of being platform or virtual, Java threads can also be:
3. User Threads
- Default type of thread.
- JVM waits for all user threads to finish before it exits.

4. Daemon Threads
- Background threads (e.g., garbage collector).
- JVM does not wait for daemon threads to finish.
*/

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        System.out.println("Is main thread virtual? : " + Thread.currentThread().isVirtual());    // false

        // Platform Thread
        new Thread(()->{
            System.out.println("Is this thread virtual? : " + Thread.currentThread().isVirtual());    // false
        }).start();

        // Virtual Thread
        Thread.startVirtualThread(()->{
            System.out.println("Is this thread virtual? : " + Thread.currentThread().isVirtual());    // true
        }).join();

        // Let's do benchmark. Spawn in 100_000 threads and see how much time it takes.

        Runnable foo = () -> {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        };

        // Platform thread.
        // Create new platform threads as needed, but will reuse idle ones
        var begin = Instant.now();
        try(ExecutorService executor = Executors.newCachedThreadPool();){
            IntStream.range(0,100_000).forEach(i -> executor.submit(foo));
        }
        var end = Instant.now();
        System.out.println("Duration: " + Duration.between(begin, end));
        // Duration: PT9.7821529S ~ 10S
        // That's reasonable — the executor couldn't launch 100,000 threads instantly but batched them well.

        // Platform thread
        // Attempts to pre-allocate 100,000 platform threads up front.
        // Note: Don't run this - it will fry your pc
        begin = Instant.now();
        try(ExecutorService executor = Executors.newFixedThreadPool(100_000);){
            IntStream.range(0,100_000).forEach(i -> executor.submit(foo));
        }
        end = Instant.now();
        System.out.println("Duration: " + Duration.between(begin, end));
        // Above 2 minutes (my PC fried so had to stop)
        // Each thread takes ~1MB stack space by default → ~100 GB virtual memory (even if not resident).
        // OS scheduler can’t handle that many active threads smoothly.
        // conclusion: platform threads don’t scale like that.

        // Virtual Threads
        begin = Instant.now();
        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();){
            IntStream.range(0,100_000).forEach(i -> executor.submit(foo));
        }
        end = Instant.now();
        System.out.println("Duration: " + Duration.between(begin, end));
        // Duration: PT4.3152795S ~ 4S
        // 100,000 virtual threads created almost instantly.
        // Easily scalable
    }
}
