package _9_NIO2;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;

public class FileAttributes {

    public static void main(String[] args) throws IOException {
        readAttributes();
        isHidden();
        fileAccessibility();
        fileModifications();
        ownership();
    }

    public static void readAttributes() {
        System.out.println(Files.isDirectory(Paths.get("/canine/coyote/fur.jpg"))); //true
        System.out.println(Files.isRegularFile(Paths.get("/canine/types.txt")));    //true
        System.out.println(Files.isSymbolicLink(Paths.get("/canine/coyote")));      //true
    }

    public static void isHidden() {
        try {
            System.out.println(Files.isHidden(Paths.get("/walrus.txt")));
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void fileAccessibility() {
        System.out.println(Files.isReadable(Paths.get("/seal/baby.png")));
        System.out.println(Files.isExecutable(Paths.get("/seal/baby.png")));
    }

    public static void size() {
        try {
            System.out.println(Files.size(Paths.get("/zoo/c/animals.txt")));
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void fileModifications() {
        try {
            final Path path = Paths.get("/rabbit/food.jpg");
            System.out.println(Files.getLastModifiedTime(path).toMillis());
            Files.setLastModifiedTime(path,
                    FileTime.fromMillis(System.currentTimeMillis()));
            System.out.println(Files.getLastModifiedTime(path).toMillis());
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }

    public static void ownership() throws IOException {
        final Path path1 = Paths.get("/rabbit/food.jpg");

        UserPrincipal owner1 = FileSystems.getDefault().getUserPrincipalLookupService()
                .lookupPrincipalByName("jane");

        UserPrincipal owner2 = path1.getFileSystem().getUserPrincipalLookupService()
                .lookupPrincipalByName("jane");

        try {
            // Read owner of file
            Path path = Paths.get("/chicken/feathers.txt");
            System.out.println(Files.getOwner(path).getName());
            // Change owner of file
            UserPrincipal owner = path.getFileSystem()
                    .getUserPrincipalLookupService().lookupPrincipalByName("jane");
            Files.setOwner(path, owner);
            // Output the updated owner information
            System.out.println(Files.getOwner(path).getName());
        } catch (IOException e) {
            // Handle file I/O exception...
        }
    }
}
