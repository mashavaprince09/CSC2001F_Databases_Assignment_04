import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Optimize extends LPHashTable {
    public static void main(String[] args) {
        int minProbeCount = 0;
        int lowProbeCount_Counter= 0;
        System.out.println("Processing...");
        for (int a=0;a<5;a++) {
            for (int b=0;b<5;b++) {
                for (int c=0;c<5;c++) {
                    for (int d=0;d<5;d++) {
                        for (int e=0;e<5;e++) {
                            for (int f=0;f<5;f++) {
                                for (int g=0;g<5;g++) {
                                    for (int h=0;h<5;h++) {
                                        for (int i=0;i<5;i++) {
                                            int[] weights = new int[] {a,b,c,d,e,f,g,h,i};
                                            LPHashTable LPhashtable = new LPHashTable(37);
                                            LPhashtable.setWeights(weights);
                                            try {
                                                final Scanner file = new Scanner(new File("mydata.txt"));
                                                int quantity = 36;
                                                while (quantity > 0) {
                                                    LPhashtable.insert(file.nextLine());
                                                    quantity--;
                                                }
                                                file.close();
                                                if (minProbeCount == 0) {
                                                    minProbeCount = LPhashtable.getProbeCount();
                                                    minProbeCount = 1;
                                                } else {
                                                    if (LPhashtable.getProbeCount() < minProbeCount) {
                                                        lowProbeCount_Counter = 1;
                                                        minProbeCount = LPhashtable.getProbeCount();
                                                    } else if (LPhashtable.getProbeCount() == minProbeCount) {
                                                        lowProbeCount_Counter++;
                                                    }
                                                }
                                            } catch (FileNotFoundException fnfExep) {
                                                fnfExep.printStackTrace();
                                            } catch (IllegalStateException illExcep) {
                                                illExcep.printStackTrace();
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
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt"));
            writer.write(minProbeCount+ " " +lowProbeCount_Counter);
            writer.close();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
