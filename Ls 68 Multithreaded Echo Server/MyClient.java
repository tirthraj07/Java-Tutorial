import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public void start(final int SERVER_PORT, Scanner sc){
        try(
                Socket socket = new Socket("localhost", SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            System.out.println("Socket created.");
            String userInput;
            do {
                System.out.print(">> ");
                userInput = sc.nextLine();
                out.println(userInput);
                String serverResponse = serverInput.readLine();
                System.out.println("Server >> " + serverResponse);
            }while(userInput!=null&&!userInput.isBlank());

        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }
}
