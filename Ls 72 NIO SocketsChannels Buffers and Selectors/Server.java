package com.main;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Set;

public class Server {

    public void start(final int PORT_NUMBER){
        System.out.println("Server starting..");
        Set<SocketChannel> clients = new HashSet<>();
        try (
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                Selector selector = Selector.open();
        ) {
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(PORT_NUMBER));
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while(true){
                if(selector.select() == 0){
                    continue;
                }

                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                for(SelectionKey key: selectedKeys){
                    if(key.isAcceptable()){
                        if(key.channel() instanceof ServerSocketChannel channel){
                            SocketChannel client = channel.accept();
                            client.configureBlocking(false);

                            Socket clientSocket = client.socket();
                            String clientAddress = getClientAddress(clientSocket);
                            System.out.println("Client Connected: " + clientAddress);

                            // Now register this socketChannel with the selector.
                            // The selector will notify us when the client has sent something to server to "read"
                            client.register(selector, SelectionKey.OP_READ);
                            // So now we have to listen to a READ event from a SocketChannel

                            // add the client to the clients hashset
                            clients.add(client);
                        }
                    }
                    else if(key.isReadable()){
                        if(key.channel() instanceof SocketChannel client){
                            Socket clientSocket = client.socket();
                            String clientAddress = getClientAddress(clientSocket);
                            // We want to read the data from the client
                            // 1. Read from channel to buffer
                            // 2. Switch from write mode (into buffer) to read mode (from buffer)
                            // 3. Read the bytes from the buffer
                            // 4. Convert the bytes into String

                            buffer.clear(); // Prepare to read

                            int bytesRead = client.read(buffer);
                            if(bytesRead == -1){
                                System.out.println("DISCONNECTED " + clientAddress);
                                client.close();
                                clients.remove(client);
                            }

                            buffer.flip();      // Switch to read mode
                            byte[] data = new byte[buffer.remaining()];
                            buffer.get(data);
                            String clientInput = new String(data).trim();
                            System.out.println(clientAddress + " : " + clientInput);

                            // echo back to the client
                            ByteBuffer echoBuffer = ByteBuffer.wrap((clientInput + System.lineSeparator()).getBytes());
                            while (echoBuffer.hasRemaining()) {
                                client.write(echoBuffer);
                            }
                        }
                    }

                }
                selectedKeys.clear();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            for (SocketChannel client : new HashSet<>(clients)) {
                if (client.isOpen()) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            clients.clear();
        }
    }

    private String getClientAddress(Socket clientSocket){
        String clientIp = clientSocket.getInetAddress().getHostAddress();
        int clientPort = clientSocket.getPort();
        String clientAddress = "(" + clientIp + ":" + clientPort + ")";
        return clientAddress;
    }


}
