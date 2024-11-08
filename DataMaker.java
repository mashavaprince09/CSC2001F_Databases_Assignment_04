import java.util.*;
import java.io.*;
public class DataMaker {

    private DataMaker() {}

    final static String FILE_NAME = "students.txt";
    private static boolean isInteger(final String string) {
        for(int i=0; i<string.length(); i++) {
            if (!Character.isDigit(string.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String sInput = sc.nextLine();
        String[] sInputArr = sInput.split(" ");
        sc.close();
        if (sInputArr.length!=2 || sInputArr[0].length()!=9 || !isInteger(sInputArr[1])) {
            System.out.println("Enter <Student Number> <List Length>");
        }
        else {
            String[] Names = new String[Integer.parseInt(sInputArr[1])];
            int i=1;
            String line;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
                while (((line=reader.readLine())!=null)) {
                    if (line.equals(sInputArr[0])){
                        Names[0] = line;
                        break;
                    }
                    else {
                        if (i<Integer.parseInt(sInputArr[0])){
                            Names[i] = line;
                        }
                        i++;
                    }
                }                
                reader.close();
                if (Names[0]==null){
                    System.out.println(sInputArr[0]+" is not in the students file.");
                }
                else {
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("mydata.txt"));
                        for (String ele : Names) {
                            writer.write(ele+"\n");
                        }
                        writer.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
    }

}
