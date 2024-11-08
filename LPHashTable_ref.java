// import java.util.List;

/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable_ref extends HashTable {

  /**
   * Create an LPHashTable with DEFAULT_SIZE table.
   */
  public LPHashTable_ref() {
    super();
  }

  /**
   * Create an LPHashTable with the given default size table.
   */
  public LPHashTable_ref(final int size) {
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
    int index = hashFunction(key);
    for (int i = 0; i < tableSize(); ++i) {
      if (table[index] == null) {
        incProbeCount();
        return index;
      } else if (key.equals(table[index])) {
        incProbeCount();
        return index;
      } else {
        incProbeCount();
        index = (index + 1) % tableSize();
      }
    }
    return -1;
  }
}
