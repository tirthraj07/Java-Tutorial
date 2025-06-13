// Refer: https://www.youtube.com/live/4Tke9LKQ0UQ?si=HA7Z9TRBQTU1MmcT

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("demo.txt");
        if(Files.notExists(filePath)){
            Files.createFile(filePath);
        }
        Path copyFilePath = Paths.get("copy.txt");


        System.out.println("Files.isDirectory(filePath) = " + Files.isDirectory(filePath));         // false
        System.out.println("Files.isExecutable(filePath) = " + Files.isExecutable(filePath));       // true
        System.out.println("Files.isRegularFile(filePath) = " + Files.isRegularFile(filePath));     // true
        System.out.println("Files.isHidden(filePath) = " + Files.isHidden(filePath));               // false
        System.out.println("Files.isReadable(filePath) = " + Files.isReadable(filePath));           // true
        System.out.println("Files.isWritable(filePath) = " + Files.isWritable(filePath));           // true

        List<String> lines = List.of("Hello!","My Name is Tirthraj!", "I am a student at PICT, Pune");
        // Write contents in the file
        Files.write(filePath, lines);

        // Copy Contents
        Files.copy(filePath, copyFilePath);

        // Read Contents of File
        List<String> contents = Files.readAllLines(copyFilePath);

        for(String s: contents){
            System.out.println(s);
        }

        Files.deleteIfExists(filePath);
        Files.deleteIfExists(copyFilePath);
    }
}
