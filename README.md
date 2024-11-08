# CSC2001F Assignment: Hashing

## Overview

This project focuses on the implementation and evaluation of two hash table probing techniques: **Linear Probing** and **Quadratic Probing**. Additionally, it includes optimizing a hash function for a specific dataset. The hash tables used store simple `String` data items and are designed to track whether an item is in the data structure.

### Objectives
1. Implement and evaluate Linear Probing and Quadratic Probing hash table methods.
2. Optimize a hash function using specific weights to minimize the number of probes required to insert items in the table.

## Framework

### Provided Classes
- **`HashTable`**: A base class for implementing hash tables. It includes:
  - A general-purpose `findIndex()` method for locating items.
  - A `hashFunction()` method for generating hash codes based on item keys.
- **`LPHashTable`**: Extends `HashTable` to implement **Linear Probing**.
- **`QPHashTable`**: Extends `HashTable` to implement **Quadratic Probing**.

Additional classes:
- **`AutoTest`, `LPAutoTest`, and `QPAutoTest`**: Test classes to evaluate hash table implementations.
- **`DataMaker`**: Generates a personalized list of usernames for the optimization task.

### Data File
The `students.txt` file contains a list of usernames to be used for hash table operations.

## Design Principles

The `HashTable` class is structured to simplify implementation by using `findIndex()` to handle both insertions and lookups. The method `findIndex()` relies on `hashFunction()` to determine the index for each item in the table.

```java
protected abstract int findIndex(String word);
protected int hashFunction(String key) { // Implementation... }
```

To implement Linear and Quadratic Probing, subclasses need only provide their specific version of `findIndex()`.

### Performance Evaluation

The performance of the hash tables is evaluated by tracking the number of probes (or attempts) made when inserting or searching. The `Monitorable` class provides methods to maintain and reset the probe count:

```java
public int getProbeCount();   // Returns probe count
public void incProbeCount();  // Increments probe count
public void resetProbeCount(); // Resets probe count
```

## Tasks

### Task One: Implement Hash Table Probing Techniques [50 marks]

Complete the `LPHashTable` and `QPHashTable` classes:
- **LPHashTable**: Implements **Linear Probing**.
- **QPHashTable**: Implements **Quadratic Probing**. If probing fails (i.e., the number of probes exceeds the table size), `findIndex()` should return `-1`.

### Task Two: Optimize the Hash Function [50 marks]

For the second task, the aim was to find an optimal combination of hash function weights to minimize probe counts.

1. Use `DataMaker.java` to generate a custom list of usernames.
   ```bash
   java DataMaker <your_username> <list_length> > mydata.txt
   ```

2. Implement `Optimize.java`:
   - Evaluate all possible weight combinations for a hash table size of 37.
   - Output the minimum number of probes and the number of weight combinations that achieve this minimum.
   - Example output:
     ```
     44 4
     ```
     This means that the least number of probes was 44, and four different weight combinations achieved this.

## Usage

### Running the AutoTest Programs
The `LPAutoTest` and `QPAutoTest` programs simulate hash table operations like insert, check if empty, size, contains, and probe count. Sample commands:

```plaintext
INSERT <string>
SIZE
DUMP
QUIT
```

To load data from `students.txt`:
```plaintext
LOAD students.txt 9
DUMP
PROBECOUNT
QUIT
```

### Example Usage (LPAutoTest)

```plaintext
11          # Initialize with table size 11
INSERT ABC123
SIZE
DUMP
QUIT
```

### Example Usage (QPAutoTest)

```plaintext
11          # Initialize with table size 11
LOAD students.txt 7
DUMP
QUIT
```

For more details, see the comments and sample output within each test program.
