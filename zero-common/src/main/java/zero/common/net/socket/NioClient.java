package zero.common.net.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 7777));
        socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true);
        socketChannel.write(ByteBuffer.wrap(new byte[]{8}));
        socketChannel.write(ByteBuffer.wrap(new byte[]{9}));
        socketChannel.close();
    }
}
