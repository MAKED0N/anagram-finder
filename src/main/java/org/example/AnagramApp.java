package org.example;

import java.io.IOException;

public class AnagramApp {
    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.out.println("Usage: java AnagramApp <input-file-path>");
            System.out.println("Example: java AnagramApp src/main/resources/sample.txt");
            return;
        }

        AnagramParser parser = new AnagramParser();

        try {
            parser.processFile(args[0]);
            parser.printAnagrams();

        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
            System.err.println("Please check file path and permissions");

        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}
