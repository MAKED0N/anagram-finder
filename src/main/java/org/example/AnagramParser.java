package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

public class AnagramParser {
    private static final String DEFAULT_FILE_PATH = "src/main/resources/sample.txt";

    private final Map<String, List<String>> anagramGroups = new HashMap<>();
    private final String filePath;

    public AnagramParser() {
        this.filePath = DEFAULT_FILE_PATH;
    }

    public AnagramParser(String filePath) {
        this.filePath = filePath;
    }

    public Map<String, List<String>> getAnagramGroups() {
        return anagramGroups;
    }

    public void processFile() {
        try {
            groupAnagrams(Files.readAllLines(Paths.get(filePath)));
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
            System.err.println("Please check file path and permissions");
        }
    }

    public void print() {
        anagramGroups
                .values()
                .stream()
                .map(it -> String.join(" ", it))
                .forEach(System.out::println);
    }

    private void groupAnagrams(List<String> words) {
        words.forEach(word -> {
            String key = generateAnagramKey(word);
            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }
            anagramGroups.get(key).add(word);
        });
    }

    private String generateAnagramKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return Arrays.toString(chars);
    }
}