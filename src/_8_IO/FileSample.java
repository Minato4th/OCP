package _8_IO;

import java.io.File;

public class FileSample {

    public static void main(String[] args) {
        File file = new File(Streams.PATH);
        System.out.println(file.exists());

        File parent = new File("/home/smith");
        File child = new File(parent,"data/zoo.txt");
    }


}
