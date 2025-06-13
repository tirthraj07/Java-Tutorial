package com.main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {

    public void start(final int PORT_NUMBER, Scanner sc){
        try(SocketChannel serverChannel = SocketChannel.open()){
            serverChannel.connect(new InetSocketAddress(PORT_NUMBER));
            System.out.println("Connection Established");

            // Create a byte buffer to read and write to the channel.
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(true){
                System.out.print(">> ");
                String line = sc.nextLine();
                if(line.equalsIgnoreCase("quit")){
                    break;
                }
                line += System.lineSeparator();
                buffer.clear();
                // We want to send the line to the server
                // So we need to do the following tasks
                // 1. Convert the line into bytes
                // 2. Put the bytes in ByteBuffer
                // 3. Change from write mode (into buffer) to read mode (from buffer)
                // 4. Read from buffer -> write to channel

                // Now insert the bytes into the bytebuffer
                buffer.put(line.getBytes());

                // Now switch from write mode (into buffer) to read mode (from buffer)
                buffer.flip();

                // write to the channel
                while(buffer.hasRemaining()){
                    serverChannel.write(buffer);
                }

                // Now switch from read mode (from buffer) to write mode (into buffer)
                buffer.clear();
                int bytesRead = serverChannel.read(buffer);
                if (bytesRead == -1) {
                    System.out.println("Server closed the connection.");
                    break;
                }

                buffer.flip();
                byte[] responseBytes = new byte[buffer.remaining()];
                buffer.get(responseBytes);
                String serverResponse = new String(responseBytes);
                System.out.println(serverResponse.trim());
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
