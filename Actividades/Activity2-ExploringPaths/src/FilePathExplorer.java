
import java.io.File;

public class FilePathExplorer {

    public static void main(String[] args) throws Exception {
        
        File file = new File( "data","students.txt");
        System.out.println("Ruta: " + file.getPath());
        System.out.println("Ruta absoluta: " + file.getAbsolutePath());
    }
}
