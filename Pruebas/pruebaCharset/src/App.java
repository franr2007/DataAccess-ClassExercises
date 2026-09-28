import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) throws Exception {
        byte[] bytes = "€".getBytes(StandardCharsets.UTF_8);

        InputStream in = new ByteArrayInputStream(bytes);

        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);

        int c = reader.read();
        
        System.out.println((char) c);
    }
}
