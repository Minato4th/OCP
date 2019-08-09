package _8_IO;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithStreams {

    public static final String SOURCE = "D:\\Projects\\Interns\\OCP\\src\\_8_IO\\zoo.txt";
    public static final String DESTINATION = "D:\\Projects\\Interns\\OCP\\src\\_8_IO\\zooCopy.txt";

    Charset usAsciiCharset = Charset.forName("US-ASCII");
    Charset utf8Charset = Charset.forName("UTF-8");
    Charset utf16Charset = Charset.forName("UTF-16");

    public static void main(String[] args) throws IOException {
        File source = new File(SOURCE);
        File destination = new File(DESTINATION);
        copy(source, destination);
        inputOutputStream(source, destination);
        inputOutputReader(source, destination);

    }

    public static void copy(File source, File destination) throws IOException {
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }

    public static void inputOutputStream(File source, File destination) throws IOException {
        try (
                InputStream in = new BufferedInputStream(new FileInputStream(source));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(destination))) {
            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }
    }

    public static void inputOutputReader(File source, File destination) throws IOException {
        List<String> data = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String s;
            while((s = reader.readLine()) != null) {
                data.add(s);
            }
        }

        data.forEach(System.out::println);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            for(String s: data) {
                writer.write(s);
                writer.newLine();
            }
        }
    }

}
