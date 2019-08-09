package _9_NIO2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
. A reference to the current directory
.. A reference to the parent of the current directory
 */

public class PathMethods {

    public static void main(String[] args) {
        Paths.get("/zoo/../home").getParent().normalize().toAbsolutePath();

        viewing();
        accessing();
        absolute();
        subpath();
        relativize();
        resolve();
        normalize();
        toRealPath();
    }

    public static void viewing() {
        Path path = Paths.get("/land/hippo/harry.happy");
        System.out.println("The Path Name is: " + path);

        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.println(" Element " + i + " is: " + path.getName(i));
        }
        /*
        The Path Name is: land/hippo/harry.happy
        Element 0 is: land
        Element 1 is: hippo
        Element 2 is: harry.happy
         */
    }

    public static void accessing() {

        Path path = Paths.get("/zoo/armadillo/shells.txt");

        System.out.println("Filename is: "+path.getFileName());
        System.out.println("Root is: "+path.getRoot());
        Path currentParent = path;
        while((currentParent = currentParent.getParent()) != null) {
            System.out.println(" Current parent is: "+currentParent);
        }

        /*
        Filename is: shells.txt
        Root is: /
        Current parent is: /zoo/armadillo
        Current parent is: /zoo
        Current parent is: /
         */
    }

    public static void absolute() {

        Path path1 = Paths.get("C:\\birds\\egret.txt");
        System.out.println("Path1 is Absolute? "+path1.isAbsolute());
        System.out.println("Absolute Path1: "+path1.toAbsolutePath());

        Path path2 = Paths.get("birds/condor.txt");
        System.out.println("Path2 is Absolute? "+path2.isAbsolute());
        System.out.println("Absolute Path2 "+path2.toAbsolutePath());

        /*
        Path1 is Absolute? true
        Absolute Path1: C:\birds\egret.txt

        Path2 is Absolute? false
        Absolute Path2 /home/birds/condor.txt
         */

        System.out.println(Paths.get("/stripes/zebra.exe").isAbsolute());
        System.out.println(Paths.get("c:/goats/Food.java").isAbsolute());
    }

    public static void subpath() {

        Path path = Paths.get("/mammal/carnivore/raccoon.image");
        System.out.println("Path is: "+path);
        System.out.println("Subpath from 0 to 3 is: "+path.subpath(0,3));
        System.out.println("Subpath from 1 to 3 is: "+path.subpath(1,3));
        System.out.println("Subpath from 1 to 2 is: "+path.subpath(1,2));
        /*
        Path is: /mammal/carnivore/raccoon.image
        Subpath from 0 to 3 is: mammal/carnivore/raccoon.image
        Subpath from 1 to 3 is: carnivore/raccoon.image
        Subpath from 1 to 2 is: carnivore
         */

        System.out.println("Subpath from 0 to 4 is: "+path.subpath(0,4)); // THROWS EXCEPTION AT RUNTIME
        System.out.println("Subpath from 1 to 1 is: "+path.subpath(1,1)); // THROWS EXCEPTION AT RUNTIME
    }

    public static void relativize() {
        Path path1 = Paths.get("fish.txt");
        Path path2 = Paths.get("birds.txt");

        System.out.println(path1.relativize(path2));    //..\birds.txt
        System.out.println(path2.relativize(path1));    //..\fish.txt

        Path path3 = Paths.get("E:\\habitat");
        Path path4 = Paths.get("E:\\sanctuary\\raven");

        System.out.println(path3.relativize(path4));    //..\sanctuary\raven
        System.out.println(path4.relativize(path3));    //..\..\habitat

        Path pathEX1 = Paths.get("/primate/chimpanzee");
        Path pathEX2 = Paths.get("bananas.txt");
        pathEX1.relativize(pathEX2); // THROWS EXCEPTION AT RUNTIME

        Path pathEX3 = Paths.get("c:\\primate\\chimpanzee");
        Path pathEX4 = Paths.get("d:\\storage\\bananas.txt");
        pathEX3.relativize(pathEX4); // THROWS EXCEPTION AT RUNTIME
    }

    public static void resolve() {
        final Path path1 = Paths.get("/cats/../panther");
        final Path path2 = Paths.get("food");

        System.out.println(path1.resolve(path2));       // /cats/../panther/food

        final Path path3 = Paths.get("/turkey/food");
        final Path path4 = Paths.get("/tiger/cage");
        System.out.println(path3.resolve(path4));       ///tiger/cage
    }

    public static void normalize() {
        Path path3 = Paths.get("E:\\data");
        Path path4 = Paths.get("E:\\user\\home");
        Path relativePath = path3.relativize(path4);

        System.out.println(path3.resolve(relativePath));    // E:\\data\..\\user\\home

        System.out.println(path3.resolve(relativePath).normalize());    // E:\\user\\home
    }

    public static void toRealPath() {
        ///zebra/food.source → /horse/food.txt

        try {
            System.out.println(Paths.get("/zebra/food.source").toRealPath());   // /horse/food.txt
            System.out.println(Paths.get(".././food.txt").toRealPath());        // /horse/food.txt
            System.out.println(Paths.get(".").toRealPath());
        } catch (IOException e) {
            // Handle file I/O exception...
        }

    }

}
