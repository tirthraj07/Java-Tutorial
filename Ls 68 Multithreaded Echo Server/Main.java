// Refer: https://youtu.be/sFizpxHkIlI?si=RfKSvIwOnHiCWn8k
// We'll create a Multi-Threaded Echo Server with Virtual Threads

import java.util.Scanner;

public class Main {
    private static final int SERVER_PORT = 10000;
    public static void main(String[] args) throws Exception {
        try(Scanner sc = new Scanner(System.in);){
            System.out.println("Are you a server? (y/n) : ");
            if(sc.nextLine().equalsIgnoreCase("y")) {
                new MyServer().start(SERVER_PORT);
            }else{
                new MyClient().start(SERVER_PORT, sc);
            }
        }
    }
}
