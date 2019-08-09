package _8_IO;

import java.io.*;

public class Streams {

    public static String PATH = "D:\\Projects\\Interns\\OCP\\src\\_8_IO\\zoo.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());

            System.out.println(new File(".").getAbsolutePath());
        }

        try (ObjectInputStream objectStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(PATH)))) {
            System.out.println(objectStream.readObject());
        }
    }

    public static void examples() {
//        new BufferedInputStream(new FileReader("zoo-data.txt"));      // DOES NOT COMPILE
//        new BufferedWriter(new FileOutputStream("zoo-data.txt"));     // DOES NOT COMPILE
//        new ObjectInputStream(new FileOutputStream("zoo-data.txt"));  // DOES NOT COMPILE
//        new BufferedInputStream(new InputStream());                   // DOES NOT COMPILE
    }

    /*
    Review of java.io Class Properties
    ■■ A class with the word InputStream or OutputStream in its name is used for reading or
    writing binary data, respectively.
    ■■ A class with the word Reader or Writer in its name is used for reading or writing
    character or string data, respectively.
    ■■ Most, but not all, input classes have a corresponding output class.
    ■■ A low-level stream connects directly with the source of the data.
    ■■ A high-level stream is built on top of another stream using wrapping.
    ■■ A class with Buffered in its name reads or writes data in groups of bytes or characters
    and often improves performance in sequential file systems.
     */
}
