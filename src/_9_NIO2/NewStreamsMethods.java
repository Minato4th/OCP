package _9_NIO2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.FileVisitOption.FOLLOW_LINKS;

public class NewStreamsMethods {

    public static void main(String[] args) throws IOException {
        directoryWalking();
        searching();
        listing();
        special();
    }

    public static void directoryWalking() {
        Path path = Paths.get("/bigcats");
        try {
            Files.walk(path)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        /*
        /bigcats/version1/backup/Lion.java
        /bigcats/version1/Lion.java
        /bigcats/version1/Tiger.java
        /bigcats/Lion.java
         */

        try {
            Files.walk(path, 10, FOLLOW_LINKS)
                    .filter(p -> p.toString().endsWith(".java"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void searching() {
        Path path = Paths.get("/bigcats");
        long dateFilter = 1420070400000L;

        try {
            Stream<Path> stream = Files.find(path, 10,
                    (p, a) -> p.toString().endsWith(".java")
                            && a.lastModifiedTime().toMillis() > dateFilter);
            stream.forEach(System.out::println);
        } catch (Exception e) {
            // Handle file I/O exception...
        }
    }

    public static void listing() {
        try {
            Path path = Paths.get("ducks");
            Files.list(path)
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toAbsolutePath())
                    .forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }
        /*
        /zoo/ducks/food.txt
        /zoo/ducks/food-backup.txt
        /zoo/ducks/weight.txt
         */
    }

    public static void lines() {
        Path path = Paths.get("/fish/sharks.log");
        try {
            Files.lines(path).forEach(System.out::println);
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        try {
            System.out.println(Files.lines(path)
                    .filter(s -> s.startsWith("WARN "))
                    .map(s -> s.substring(5))
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            // Handle file I/O exception...
        }

        /*
        INFO Server starting
        DEBUG Processes available = 10
        WARN No database could be detected
        DEBUG Processes available reset to 0
        WARN Performing manual recovery
        INFO Server successfully started

        [No database could be detected, Performing manual recovery]
         */
    }

    public static void special() throws IOException {
        Path path = Paths.get("/fish/sharks.log");

        Files.readAllLines(path).stream().filter(s -> s.length()>2).forEach(System.out::println);
        Files.lines(path).filter(s -> s.length()>2).forEach(System.out::println);
    }

}
