package _6_Exceptions_and_Assertions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) {

    }

    public void oldApproach(Path path1, Path path2) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
            in = Files.newBufferedReader(path1);
            out = Files.newBufferedWriter(path2);
            out.write(in.readLine());
        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }

    public void newApproach(Path path1, Path path2) throws IOException {
        try (BufferedReader in = Files.newBufferedReader(path1);
             BufferedWriter out = Files.newBufferedWriter(path2)) {

            out.write(in.readLine());
        }
    }

    public static void oldStyle() {
        try (Scanner s = new Scanner(System.in)) {
            s.nextLine();
        } catch (Exception e) {
//            s.nextInt(); // DOES NOT COMPILE
        } finally {
//            s.nextInt(); // DOES NOT COMPILE
        }
    }

//    public static void oldStyle() {
//
//    }
//
//    public static void oldStyle() {
//
//    }
//
//    public static void oldStyle() {
//
//    }
//
//    public static void oldStyle() {
//
//    }
}
