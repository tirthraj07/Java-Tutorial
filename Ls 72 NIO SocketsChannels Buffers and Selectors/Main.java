package com.main;

import java.util.Scanner;

public class Main {
    public static final int PORT_NUMBER = 10_000;
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)){
            System.out.println("Are you a server? (y/n)");
            System.out.print(">> ");
            if(sc.nextLine().equalsIgnoreCase("y")){
                // start server
                new Server().start(PORT_NUMBER);
            }
            else{
                // start a client
                new Client().start(PORT_NUMBER, sc);
            }
        }
    }
}
