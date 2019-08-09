package _8_IO;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PrintStremWriter {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("zoo.log");
        out.print(5); // PrintWriter method
        out.write(String.valueOf(5)); // Writer method
        out.print(2.0); // PrintWriter method
        out.write(String.valueOf(2.0)); // Writer method
        Serializables animal = new Serializables("Tommy Tiger", 5, 'T',"some",4);
        out.print(animal); // PrintWriter method
        out.write(animal==null ? "null": animal.toString()); // Writer method
    }
}
