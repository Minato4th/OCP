package _8_IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializingDeserializing {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Serializables> animals = new ArrayList<Serializables>();
        animals.add(new Serializables("Tommy Tiger", 5, 'T',"some",4));
        animals.add(new Serializables("Peter Penguin", 8, 'P', "not", 6));
        File dataFile = new File("animal.data");
        createAnimalsFile(animals, dataFile);
        System.out.println(getAnimals(dataFile));

    }

    public static List<Serializables> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
        List<Serializables> animals = new ArrayList<Serializables>();
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                Object object = in.readObject();
                if (object instanceof Serializables)
                    animals.add((Serializables) object);
            }
        } catch (EOFException e) {
            // File end reached
        }
        return animals;
    }

    public static void createAnimalsFile(List<Serializables> animals, File dataFile)
            throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Serializables animal : animals)
                out.writeObject(animal);
        }
    }
}
