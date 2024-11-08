/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() { super(); }

    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    /*protected int findIndex(String key) {
      int index = hashFunction(key);
      int i=-1;
      
        do {
          incProbeCount();
          if (table[index]!=null)
          {
            //incProbeCount(); 
            if (table[index].equals(key)){
             
              return index;
          }
          }     
          
          if ((table[index]==null)) {       
            //incProbeCount();      
            return (index-1);   
          }
                        
          
          index = (index + 1) % tableSize();  
        } while (index!=hashFunction(key));
        //incProbeCount();
        return i;
      }*/
      protected int findIndex(String key) {
        int hash = hashFunction(key);
        int index = hash;
        int i = 0;
        while(table[index]!=null){
          incProbeCount();
          if (table[index].equals(key)){
            //incProbeCount();
            i = index;
            return index;
            //break;
          }
          if (index == hash){
            //incProbeCount();
            i++;
          }
          if (i>=2){
            //incProbeCount();
            index= -1;
            return index;
            //break;
          }
          if (table[index]==null){
            //incProbeCount();
            return index;
            //break;
          }         

          index = (index + 1) % tableSize();
        }
        incProbeCount();
        return index;        
        }
}