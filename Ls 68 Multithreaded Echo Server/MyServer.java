import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {
    public void start(final int SERVER_PORT) {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT);){
            System.out.println("Server started");


            // Create a new virtual thread to handle each request
            try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()){
                while(true){
                    // Get the client socket
                    Socket clientSocket = serverSocket.accept();

                    // handle the client socket in the virtual thread.
                    executor.submit(()->{
                        System.out.println("Client Connected");
                        String clientIp = clientSocket.getInetAddress().getHostAddress();
                        int clientPort = clientSocket.getPort();
                        String clientAddress = "(" + clientIp + ":" + clientPort + ")";

                        try(
                                BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                        ){
                            String inputLine;
                            do{
                                inputLine = clientInput.readLine();
                                System.out.println(clientAddress + ": " + inputLine);
                                // Echo back the reverse of the input
                                out.println(new StringBuilder(inputLine).reverse());
                            }while(!inputLine.isBlank());
                        }catch (IOException e){
                            throw new RuntimeException(e);
                        }
                    });
                }
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
