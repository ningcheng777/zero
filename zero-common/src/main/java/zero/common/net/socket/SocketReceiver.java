package zero.common.net.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author ningcheng
 */
public class SocketReceiver {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        ObjectInputStream is = null;
        try {
            server = new ServerSocket(7777);
            socket = server.accept();
            is = new ObjectInputStream(socket.getInputStream());
            String msg = is.readUTF();
            System.out.print(msg);
            while (true) {

            }
        } catch (IOException e) {
            System.out.println(1);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (socket != null) {
                    socket.close();
                }
                if (is != null) {
                    server.close();
                }
            } catch (IOException e) {
                //
            }
        }
    }
}
