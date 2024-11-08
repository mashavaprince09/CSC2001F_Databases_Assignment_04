/**
 * Simple hash table implementation using quadratic probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class QPHashTable_ref extends HashTable {

  /**
   * Create an QPHashTable with DEFAULT_SIZE table.
   */
  public QPHashTable_ref() {
    super();
  }

  /**
   * Create an QPHashTable with the given default size table.
   */
  public QPHashTable_ref(final int size) {
    super(size);
  }

  /**
   * Find the index for entry: if entry is in the table, then returns its
   * position;
   * if it is not in the table then returns the index of the first free slot.
   * Returns -1 if a slot is not found (such as when the table is full under LP).
   *
   */
  protected int findIndex(String key) {
    // Implement using quadratic probing.
    int i = 1;
    int count = 0;
    int index = hashFunction(key);
    while (count < tableSize()) {
      if (table[index] == null) {
        incProbeCount();
        return index;
      } else if (key.equals(table[index])) {
        incProbeCount();
        return index;
      } else {
        incProbeCount();
        count++;
        index = (hashFunction(key) + (i * i)) % tableSize();
        i++;
      }
    }
    return -1;
  }
}
