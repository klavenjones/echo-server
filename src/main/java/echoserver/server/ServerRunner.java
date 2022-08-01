package echoserver.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerRunner {
    static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try {

            serverSocket = new ServerSocket(portNumber);
            serverSocket.setReuseAddress(true);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                ServerSocketWrapper serverSocketWrapper =
                        new ServerSocketWrapper(clientSocket);
                EchoServer echoServer = new EchoServer(serverSocketWrapper);
                new Thread(echoServer).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }


    }
}
