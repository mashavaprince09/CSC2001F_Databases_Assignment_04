/*public class test {
    public static void main(String[] args) {
        String[] table = new String[5];
        int tableSize=5;
        table[4] = "yay";
        for (int i = 0; i < table.length-1; i++) {
            table[i] = "ele";
            System.out.println(table[i]);
        }
        System.out.println();
        String key="ele";
        int hash = 2;
        int index = hash;
        int i = 0;
        while(table[index]!=null){
            System.out.println("index "+index+" key is "+table[index]);
          if (table[index].equals(key)){
            //System.out.println(index);
            i = index;
            break;
          }
          if (index == hash){
            System.out.println("i = "+i);
            i++;
          }
          if (i>=2){
            index= -1;
            System.out.println("i = "+i);
            break;
          }
          if (table[index]==null){
            break;
          }         

          index = (index + 1) % 5;
        }
        System.out.println(index);
        
}
} */

// Java implementation of the Quadratic Probing
 
class test {
 
  // Function to print an array
  static void printArray(int arr[])
  {

      // Iterating and printing the array
      for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
      }
  }

  // Function to implement the
  // quadratic probing
  static void hashing(int table[], int tsize, int arr[],
                      int N)
  {

      // Iterating through the array
      for (int i = 0; i < N; i++) {

          // Computing the hash value
          int hv = arr[i] % tsize;

          // Insert in the table if there
          // is no collision
          if (table[hv] == -1)
              table[hv] = arr[i];
          else {

              // If there is a collision
              // iterating through all
              // possible quadratic values
              for (int j = 0; j < tsize; j++) {

                  // Computing the new hash value
                  int t = (hv + j * j) % tsize;
                  if (table[t] == -1) {

                      // Break the loop after
                      // inserting the value
                      // in the table
                      table[t] = arr[i];
                      break;
                  }
              }
          }
      }

      printArray(table);
  }

  // Driver code
  public static void main(String args[])
  {
      int arr[] = { 50, 700, 76, 85, 92, 73, 101 };
      int N = 7;

      // Size of the hash table
      int L = 7;
      int hash_table[] = new int[L];

      // Initializing the hash table
      for (int i = 0; i < L; i++) {
          hash_table[i] = -1;
      }

      // Function call
      hashing(hash_table, L, arr, N);
  }
}
