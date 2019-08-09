package _9_NIO2;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesMetods {

    public static void main(String[] args) {
        exists();
        isSameFile();
        createDirectory();
        copy();
        delete();
        move();
        newBufferedReaderWriter();
        readAllLines();
    }

    public static void exists() {
        System.out.println(Files.exists(Paths.get("/ostrich/feathers.png")));
        System.out.println(Files.exists(Paths.get("/ostrich")));

    }

    public static void isSameFile() {
        try {
            System.out.println(Files.isSameFile(Paths.get("/user/home/cobra"),
                    Paths.get("/user/home/snake")));
            System.out.println(Files.isSameFile(Paths.get("/user/tree/../monkey"),
                    Paths.get("/user/monkey")));
            System.out.println(Files.isSameFile(Paths.get("/leaves/./giraffe.exe"),
                    Paths.get("/leaves/giraffe.exe")));
            System.out.println(Files.isSameFile(Paths.get("/flamingo/tail.data"),
                    Paths.get("/cardinal/tail.data")));
        } catch (IOException e) {
            // Handle file I/O exception...
        }

    }

    public static void createDirectory() {
        try {
            Files.createDirectory(Paths.get("/bison/field"));
            Files.createDirectories(Paths.get("/bison/field/pasture/green"));
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void copy() {
        try {
            Files.copy(Paths.get("/panda"), Paths.get("/panda-save"));
            Files.copy(Paths.get("/panda/bamboo.txt"),
                    Paths.get("/panda-save/bamboo.txt"));
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        //IO vs NIO
        try (InputStream is = new FileInputStream("source-data.txt");
             OutputStream out = new FileOutputStream("output-data.txt")) {
            // Copy stream data to file
            Files.copy(is, Paths.get("c:\\mammals\\wolf.txt"));
            // Copy file data to stream
            Files.copy(Paths.get("c:\\fish\\clown.xsl"), out);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void move() {
        try {
            Files.move(Paths.get("c:\\zoo"), Paths.get("c:\\zoo-new"));
            Files.move(Paths.get("c:\\user\\addresses.txt"),
                    Paths.get("c:\\zoo-new\\addresses.txt"));
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void delete() {
        try {
            Files.delete(Paths.get("/vulture/feathers.txt"));
            Files.deleteIfExists(Paths.get("/pigeon"));
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void newBufferedReaderWriter() {

        Path path = Paths.get("/animals/gopher.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("US-ASCII"))) {
            // Read from the stream
            String currentLine = null;
            while ((currentLine = reader.readLine()) != null)
                System.out.println(currentLine);
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        path = Paths.get("/animals/gorilla.txt");
        List<String> data = new ArrayList<>();
        try (BufferedWriter writer = Files.newBufferedWriter(path, Charset.forName("UTF-16"))) {
            writer.write("Hello World");
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void readAllLines() {
        Path path = Paths.get("/fish/sharks.log");
        try {
            final List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }
}
