package _8_IO;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class SystemInSample {

    public static void main(String[] args) {

        Console console = System.console();
        console.writer().format(new Locale("fr", "CA"), "Hello World");

        console = System.console();
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            console.writer().println("Welcome to Our Zoo!");
            console.format("Our zoo has 391 animals and employs 25 people.");
            console.writer().println();
            console.printf("The zoo spans 128.91 acres.");
        }

        console.flush();

    }

    public static void oldWay() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        System.out.println("You entered the following: " + userInput);
    }

    public static void newWay() {
        Console console = System.console();
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("You entered the following: " + userInput);
        }
    }

    public static void redLine() throws IOException {

        Console console = System.console();

        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            console.writer().print("How excited are you about your trip today? ");
            console.flush();
            String excitementAnswer = console.readLine();
            String name = console.readLine("Please enter your name: ");
            Integer age = null;
            console.writer().print("What is your age? ");
            console.flush();
            BufferedReader reader = new BufferedReader(console.reader());
            String value = reader.readLine();
            age = Integer.valueOf(value);
            console.writer().println();
            console.format("Your name is " + name);
            console.writer().println();
            console.format("Your age is " + age);
            console.printf("Your excitement level is: " + excitementAnswer);
        }
    }
}