package echoserver.server;

import java.io.IOException;



public class EchoServer implements Runnable {
    private ServerSocketInterface socketWrapper;

    public EchoServer(ServerSocketInterface socket) {
        this.socketWrapper = socket;
    }


    public void run() {
        try {
            String clientMessage;
            while ((clientMessage = socketWrapper.receiveData()) != null) {
                socketWrapper.sendData(clientMessage);
            }
            socketWrapper.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
