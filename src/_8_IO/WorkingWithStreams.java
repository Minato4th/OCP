package _8_IO;

import java.io.*;

public class WorkingWithStreams {

    public static final String SOURCE = "D:\\Projects\\Interns\\OCP\\src\\_8_IO\\zoo.txt";
    public static final String DESTINATION = "D:\\Projects\\Interns\\OCP\\src\\_8_IO\\zooCopy.txt";

    public static void main(String[] args) throws IOException {
        File source = new File(SOURCE);
        File destination = new File(DESTINATION);
        copy(source, destination);
        copyDuff(source, destination);

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

    public static void copyDuff(File source, File destination) throws IOException {
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
}
