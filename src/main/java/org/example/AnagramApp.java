package org.example;

public class AnagramApp {
    public static void main(String[] args) {
        AnagramParser anagramParser = new AnagramParser();

        anagramParser.processFile();
        anagramParser.print();
    }
}