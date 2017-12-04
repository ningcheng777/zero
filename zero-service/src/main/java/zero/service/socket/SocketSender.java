package zero.service.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketSender {

    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream os = null;
        try {
            socket = new Socket("127.0.0.1", 1234);
            os = new ObjectOutputStream(socket.getOutputStream());
            os.writeUTF("999");
            os.close();
            socket.close();
        } catch (IOException e) {
            //
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                //
            }
        }
    }

}
