import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class channelExample {
    public static void main(String[] args) throws Exception {

        // Channel: connection to the file
        FileChannel channel = new FileInputStream("hello.txt").getChannel();

        // Buffer: memory area where the data will be stored
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // Read data from the file INTO the buffer
        channel.read(buffer);

        // Prepare buffer for reading
        buffer.flip();

        // Read data FROM the buffer
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        channel.close();
    }
}
