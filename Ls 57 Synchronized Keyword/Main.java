class A extends Thread{
    public int count;

    public synchronized void incrementCount(){
        System.out.println("This is executing " + count);
        count++;
    }

    public void run(){
        System.out.println("Thread A is executing");
        incrementCount();
    }

}

public class Main{
    public static void main(String[] args) {
        A obj = new A();
        
        Thread thread1 = new Thread(() -> {
            for (int i=0; i< 1000000; i++) {
                System.out.println("Thread 1");
                obj.incrementCount();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i=0; i< 1000000; i++) {
                System.out.println("Thread 2");
                obj.incrementCount();
            }
        });

        thread1.start();
        thread2.start();


        try{
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(obj.count);
    }

}