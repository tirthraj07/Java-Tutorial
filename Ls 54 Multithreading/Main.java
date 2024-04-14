/*

Multithreading is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of CPU. 
Each part of such program is called a thread. So, threads are light-weight processes within a process.

Threads can be created by using two mechanisms : 

- Extending the Thread class 
- Implementing the Runnable Interface

Here we will focus on the 1st type
*/

class A extends Thread{
    @Override
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println("Hi "+ i);
        }

    }
}

class B extends Thread{
    @Override
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println("Hello " + i);
        }
    }
}

class Main{
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();

        obj1.start();
        obj2.start();

    }
}