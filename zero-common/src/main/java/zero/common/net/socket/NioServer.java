package zero.common.net.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class NioServer {

    private final ServerSocketChannel serverSocketChannel;
    private final Selector selector;

    public NioServer() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 7777));
        selector = Selector.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        start();
    }

    private void start() throws IOException {
        while (true) {
            selector.select(1000);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                if ((selectionKey.readyOps() & SelectionKey.OP_ACCEPT) != 0) {
                    SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                    System.out.println("accept complete");
                } else if ((selectionKey.readyOps() & SelectionKey.OP_READ) != 0) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true);
                    ByteBuffer byteBuffer = ByteBuffer.allocate(64);
                    if (socketChannel.read(byteBuffer) < 0) {
                        socketChannel.close();
                    } else {
                        println(byteBuffer);
                    }
                } else if ((selectionKey.readyOps() & SelectionKey.OP_WRITE) != 0) {
                    // TODO
                }
            }
            selectionKeys.clear();
        }
    }

    private void println(ByteBuffer byteBuffer) {
        byteBuffer.flip();
        StringBuilder sb = new StringBuilder();
        while (byteBuffer.position() < byteBuffer.limit()) {
            sb.append(byteBuffer.get());
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
    }
}
