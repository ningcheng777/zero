package zero.common.net.socket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketSender {

    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            socket = new Socket("127.0.0.1", 7777);
            os = new BufferedOutputStream(socket.getOutputStream());
            os.write(111);
            while (true) {

            }
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
