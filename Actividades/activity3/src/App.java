import java.io.File;

public class App {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("usage: java SettingPermissions filespec");
            return;
        }

        File file = new File(args[0]);

        System.out.println("Checking permissions for " + args[0]);

        System.out.println(" Execute = " + file.canExecute());
        System.out.println(" Read = " + file.canRead());
        System.out.println(" Write = " + file.canWrite());

        file.setReadable(false);
        file.setWritable(false);
        file.setExecutable(false);

        System.out.println("\nAfter changing permissions:");

        System.out.println(" Execute = " + file.canExecute());
        System.out.println(" Read = " + file.canRead());
        System.out.println(" Write = " + file.canWrite());
    }
}