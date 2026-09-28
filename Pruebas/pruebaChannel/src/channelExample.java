import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class channelExample {
    public static void main(String[] args) throws Exception {

        //channel: conexion con el archivo
        FileChannel channel = new FileInputStream("hello.txt").getChannel();

        //buffer: area de memoria donde la info estara guardada
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //lee la info del archivo dentro del buffer
        channel.read(buffer);

        //prepara el buffer para leer
        buffer.flip();

        //lee la info del buffer
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

        channel.close();
    }
}
