package echoserver.server;


public class ServerRunner {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);

        ServerSocketWrapper serverSocket = new ServerSocketWrapper();
        EchoServer echoServer = new EchoServer(serverSocket);

        echoServer.run(portNumber);


    }
}
