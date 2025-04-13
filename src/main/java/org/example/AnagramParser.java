package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AnagramParser {
    private Map<String, List<String>> anagramGroups;

    public AnagramParser() {
        this.anagramGroups = new HashMap<>();
    }

    public void processFile(String filePath) throws IOException {
        List<String> words = Files.readAllLines(Paths.get(filePath));
        groupAnagrams(words);
    }

    private void groupAnagrams(List<String> words) {
        for (String word : words) {
            String key = generateAnagramKey(word);
            if (!anagramGroups.containsKey(key)) {
                anagramGroups.put(key, new ArrayList<>());
            }
            anagramGroups.get(key).add(word);
        }
    }

    private String generateAnagramKey(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public void printAnagrams() {
        for (List<String> group : anagramGroups.values()) {
            System.out.println(String.join(" ", group));
        }
    }
}
