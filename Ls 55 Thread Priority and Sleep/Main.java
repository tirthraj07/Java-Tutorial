import javax.xml.datatype.Duration;

class A extends Thread{
    public void run(){
        for(int i=0; i<100; i++){
            this.setPriority(Thread.MAX_PRIORITY);
            System.out.println("Hello "+i);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            this.setPriority(Thread.MIN_PRIORITY);
        }
    }

}

class B extends Thread{
    public void run(){
        for(int i=0; i<100; i++){
            this.setPriority(Thread.MAX_PRIORITY);
            System.out.println("Hi "+i);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            this.setPriority(Thread.MIN_PRIORITY);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        A objA = new A();
        B objB = new B();

        objA.start();
        objB.start();

        System.out.println("objA Priority -> "+objA.getPriority());
        System.out.println("objB Priority -> "+objB.getPriority());

    }
}
