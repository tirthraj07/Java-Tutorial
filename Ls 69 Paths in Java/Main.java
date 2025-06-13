// Refer: https://www.youtube.com/live/2_m5X4HUUTI?si=obeBaGUIgMcmLtGn
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        // Path is an interface. It automatically detects the file system and uses specific implementation
        Path p1 = Paths.get("a/b/c/d");

        // Example: If I am running on windows, then it would automatically use: class sun.nio.fs.WindowsPath
        System.out.println(p1.getClass());

        // Ways of defining paths
        Path p2 = Paths.get("a/b/c/d");
        Path p3 = Paths.get("a","b","c","d");
        // Both are the same
        System.out.println(p2);                                                   // a\b\c\d
        System.out.println(p3);                                                   // a\b\c\d
        System.out.println(p1.equals(p3));                                        // true

        // Absolute Paths
        // For windows, you start with the Drive
        Path p4 = Paths.get("C:/Users/LENOVO");
        System.out.println("p4 = " + p4);                                         // C:\Users\LENOVO
        System.out.println("p4.getRoot() = " + p4.getRoot());                     // C:\
        System.out.println("p4.getFileName() = " + p4.getFileName());             // LENOVO

        // For linux/unix systems, the absolute path starts from root '/'
        Path p5 = Paths.get("/a/b/c/d/e/f");
        System.out.println("p5 = " + p5);                                         // \a\b\c\d\e\f
        System.out.println("p5.getRoot() = " + p5.getRoot());                     // \
        System.out.println("p5.getFileName() = " + p5.getFileName());             // f

        // You can also normalize any file paths
        // Example
        Path p6 = Paths.get("/a/b/c/./././d/../../g");
        // Now './' means the same directory and '../' means the parent directory
        // Therefore: /a/b/c/./././d/../../g -> /a/b/g
        System.out.println("p6 = " + p6);                                         // \a\b\c\.\.\.\d\..\..\g
        System.out.println("p6.normalize() = " + p6.normalize());                 // \a\b\g


        // You can also combine any two paths
        Path p7 = Paths.get("a/b/c/d");
        Path p8 = Paths.get("e/f/g/h");
        System.out.println("p7.resolve(p8) = " + p7.resolve(p8));                 // a\b\c\d\e\f\g\h
        System.out.println("p8.resolve(p7) = " + p8.resolve(p7));                 // e\f\g\h\a\b\c\d
    }
}
