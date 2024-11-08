import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Optimize4Liz extends LPHashTable {
    public static String fileName = "mydata.txt";
    public static String resultsFile = "results.txt";
    public static int lowestProbeCount = 0;
    public static int lowProbeCountTimes = 0;

    public static void main(String[] args) {
        generateOptimalWeights();
        writeResultsToFile();
    }

    /**
     * Generates all possible weight combinations and evaluates their probe counts
     */
    public static void generateOptimalWeights() {
        System.out.println("Processing...");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        for (int m = 0; m < 5; m++) {
                            for (int n = 0; n < 5; n++) {
                                for (int o = 0; o < 5; o++) {
                                    for (int p = 0; p < 5; p++) {
                                        for (int q = 0; q < 5; q++) {
                                            int[] weights = new int[]{i, j, k, l, m, n, o, p, q};
                                            LPHashTable table = new LPHashTable(37);
                                            table.setWeights(weights);
                                            evaluateProbeCount(table);
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

    /**
     * Evaluates the probe count for a given LPHashTable
     *
     * @param table The LPHashTable object
     */
    public static void evaluateProbeCount(LPHashTable table) {
        try {
            final Scanner fileIn = new Scanner(new File(fileName));
            int quantity = 36;
            while (quantity > 0) {
                table.insert(fileIn.nextLine());
                quantity--;
            }
            fileIn.close();
            updateLowestProbeCount(table.getProbeCount());
        } catch (IOException e) {
            System.out.println("File not found.");
        } catch (IllegalStateException e) {
            System.out.println("Insert failure. Table full?");
        }
    }

    /**
     * Updates the lowest probe count and count of weight combinations achieving it
     *
     * @param probeCount The probe count to compare
     */
    public static void updateLowestProbeCount(int probeCount) {
        if (lowestProbeCount == 0) {
            lowestProbeCount = probeCount;
            lowProbeCountTimes = 1;
        } else {
            if (probeCount < lowestProbeCount) {
                lowProbeCountTimes = 1;
                lowestProbeCount = probeCount;
            } else if (probeCount == lowestProbeCount) {
                lowProbeCountTimes++;
            }
        }
    }

    /**
     * Writes the lowest probe count and count of weight combinations to a file
     */
    public static void writeResultsToFile() {
        try {
            FileWriter fileWriter = new FileWriter(resultsFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(lowestProbeCount + " " + lowProbeCountTimes);
            writer.close();
            System.out.println("Done...");
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}
