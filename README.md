# Anagram Finder

A Java application that identifies and groups anagrams from an input file.

## Features

- Reads words from a text file (one word per line)
- Groups words by their anagram relationships
- Prints grouped anagrams to standard output
- Simple and clean implementation

## Requirements

- Java 11 or later
- Maven (for building)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/MAKED0N/anagram-finder.git
   cd anagram-finder

## Usage
1. Place your input file at src/main/resources/####.txt
   - File should contain one word per line
   
2. Run the application:
```bash
java -cp target/classes org.example.AnagramApp
````

3.To use a different file path, modify the code:
```java
// In AnagramApp.java, change:
AnagramParser anagramParser = new AnagramParser("your/file/path.txt");
```
## Run the Program
### In IntelliJ IDEA:
- Open the project

- Right-click AnagramApp.java

- Select "Run AnagramApp.main()" or press Shift+F10

## Example
### Input file (src/main/resources/sample.txt):
```bash
act
cat
tree
race
care
acre
bee
```
### Output:
```bash
act cat
race care acre
tree
bee
```

## Troubleshooting
### If you get "File not found" errors, double-check:

- The file path is correct

- The file exists at the specified location

- You have proper file permissions