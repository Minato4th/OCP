package _9_NIO2;

import _8_IO.Streams;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import static _8_IO.Streams.*;

public class PathIntroducing {

    public static void main(String[] args) throws URISyntaxException {
        Path path1 = Paths.get("pandas/cuddly.png");
        Path path2 = Paths.get("c:\\zooinfo\\November\\employees.txt");
        Path path3 = Paths.get("/home/zoodirector");

        Path path4 = Paths.get(PATH);

        Path path11 = Paths.get("pandas","cuddly.png");
        Path path22 = Paths.get("c:","zooinfo","November","employees.txt");
        Path path33 = Paths.get("/","home","zoodirector");

//        Paths path1 = Paths.get("/alligator/swim.txt"); // DOES NOT COMPILE
//        Path path2 = Path.get("/crocodile/food.csv"); // DOES NOT COMPILE

        Path path5 = Paths.get(new URI("file://pandas/cuddly.png")); // THROWS EXCEPTION  AT RUNTIME
        Path path6 = Paths.get(new URI("file:///c:/zoo-info/November/employees.txt"));
        Path path7 = Paths.get(new URI("file:///home/zoodirectory"));

        Path path8 = Paths.get(new URI("http://www.wiley.com"));
        Path path9 = Paths.get(new URI("ftp://username:password@ftp.the-ftp-server.com"));
    }

    public static void fileSystem() throws URISyntaxException {

        Path path1 = FileSystems.getDefault().getPath("pandas/cuddly.png");
        Path path2 = FileSystems.getDefault().getPath("c:","zooinfo","November",
                "employees.txt");
        Path path3 = FileSystems.getDefault().getPath("/home/zoodirector");

        FileSystem fileSystem = FileSystems.getFileSystem(new URI("http://www.selikoff.net"));
        Path path = fileSystem.getPath("duck.txt");

    }

    public static void filePath() throws URISyntaxException {

        File file = new File("pandas/cuddly.png");
        Path path = file.toPath();

        Path path1 = Paths.get("cuddly.png");
        File file1 = path.toFile();

    }

}
