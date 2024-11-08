import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Optimize1 extends LPHashTable {
    public static String fileName = "mydata.txt";
    public static String resultsfile = "results.txt";
    public static int lowestProbeCount = 0;
    public static int lowProbeCountTimes = 0;

    public static void main(String[] args) {
        System.out.println("Processing");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        for (int m = 0; m < 5; m++) {
                            for (int n = 0; n < 5; n++) {
                                for (int o = 0; o < 5; o++) {
                                    for (int p = 0; p < 5; p++) {
                                        for (int q = 0; q < 5; q++) {
                                            int[] weights = new int[] { i, j, k, l, m, n, o, p, q };
                                            LPHashTable table = new LPHashTable(37);
                                            table.setWeights(weights);
                                            try {
                                                final Scanner fileIn = new Scanner(new File(fileName));
                                                int quantity = 36;
                                                while (quantity > 0) {
                                                    table.insert(fileIn.nextLine());
                                                    quantity--;
                                                }
                                                fileIn.close();
                                                if (lowestProbeCount == 0) {
                                                    lowestProbeCount = table.getProbeCount();
                                                    lowProbeCountTimes = 1;
                                                } else {
                                                    if (table.getProbeCount() < lowestProbeCount) {
                                                        lowProbeCountTimes = 1;
                                                        lowestProbeCount = table.getProbeCount();
                                                    } else if (table.getProbeCount() == lowestProbeCount) {
                                                        lowProbeCountTimes++;
                                                    }

                                                }
                                            } catch (FileNotFoundException fnfExep) {
                                                System.out.println("File not found.");
                                            } catch (IllegalStateException illExcep) {
                                                System.out.println("Insert failure. Table full?");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(resultsfile);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(lowestProbeCount + " " + lowProbeCountTimes);

            writer.close();
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
