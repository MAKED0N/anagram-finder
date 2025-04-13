# Anagram Finder - Design Decisions

## 1. Architecture Overview

The solution consists of two main components:
- `AnagramParser`: Core logic for processing and grouping anagrams
- `AnagramApp`: Entry point with main method

## 2. Key Design Choices

### Anagram Detection Algorithm
- Uses character sorting approach for reliable anagram identification
- Each word is converted to a canonical form by:
    1. Converting to character array
    2. Sorting characters alphabetically
    3. Using the sorted result as a grouping key

### Data Processing
- File reading uses `Files.readAllLines()` for simplicity
- Words are stored in memory using `HashMap<String, List<String>>`:
    - Key: Sorted character string (canonical form)
    - Value: List of original words sharing the same canonical form

### Error Handling
- Basic file I/O exceptions are caught and reported
- System continues operation with valid data if possible

## 3. Performance Characteristics

### Time Complexity
- O(N * M log M) where:
    - N = number of words
    - M = average word length
- Dominated by character sorting for each word

### Space Complexity
- O(N) - Stores all words in memory
- Additional storage for map structure and temporary arrays

## 4. Scalability Considerations

### Current Limitations
- In-memory processing limits maximum file size
- Single-threaded implementation

### Scaling Strategies

#### For 10 Million Words:
1. Memory Optimization:
    - Stream processing (line-by-line)
    - More efficient data structures
2. Performance:
    - Parallel processing
    - Optimized string operations

#### For 100 Billion Words:
1. Distributed Processing:
    - MapReduce architecture
    - Partitioning by word length or hash
2. Storage:
    - Disk-backed structures
    - Database with proper indexing

## 5. Extension Points

### Future Enhancements
1. **Configuration Options**:
    - Case sensitivity control
    - Minimum group size filtering
2. **Output Formats**:
    - JSON/CSV output
    - File writing capability
3. **Performance**:
    - Parallel stream processing
    - Memory-mapped file support

### Public API Methods
- `getAnagramGroups()`: Exposes internal structure for:
    - Testing and validation
    - Further processing by other components
    - Custom output generation
    - Statistical analysis


## 6. Trade-offs Made

1. **Simplicity vs Performance**:
    - Chose clearer code over micro-optimizations
    - Adequate for expected input sizes

2. **Memory vs Speed**:
    - Accepted higher memory usage for cleaner implementation
    - Can be optimized later if needed

3. **Functionality vs Scope**:
    - Focused on core requirements first
    - Left extensions for future needs