package echoserver.client;

import java.io.IOException;
import java.net.InetAddress;


public class ClientRunner {
    public static void main(String[] args) throws IOException {
        InetAddress host = InetAddress.getByName("localhost");
        int port = 8080;

        if (args.length > 2) {
            host = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
        }

        ClientSocket clientSocket = new ClientSocket();
        EchoClient echoClient = new EchoClient(clientSocket);

        echoClient.start(host, port);

    }
}
