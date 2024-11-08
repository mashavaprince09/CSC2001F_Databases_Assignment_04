public class LPAutoTest extends AutoTest {
    protected HashTable makeTable(final int size) {
        return new LPHashTable(size);
    }

    public static void main(final String[] args) {
        (new LPAutoTest()).run();
    }

}
// passed trial 1,2,3,4,5,6,7
// probes for contain are wrong