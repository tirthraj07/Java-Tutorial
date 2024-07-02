class A implements Runnable{
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("hi");
            try{
                Thread.sleep(5);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable{
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println("hello");
            try{
                Thread.sleep(5);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable obj1 = new A();
        Runnable obj2 = new B();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        // You can also instantiate the runnable class using anonymous objects
        Runnable obj3 = new Runnable() {
            public void run(){
                for(int i=0; i<5; i++){
                    System.out.println("Bye");
                }
                try{
                    Thread.sleep(5);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        obj3.run();

        // Since Runnable interface only has 1 function, i.e it is a functional interface, you can use lambda expressions

        Runnable obj4 = () -> {
            for(int i=0; i<5; i++){
                System.out.println("Goodbye");
                try{
                    Thread.sleep(5);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        obj4.run();

    }
    
}
