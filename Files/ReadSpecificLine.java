import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadSpecificLine {
    public static void main(String[] args) {
        int lineno=3;
        String filePath = "/home/miracle/Desktop/Readspecline.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lineCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                while (lineno-1==lineCount) {
                System.out.println("Read line " + lineCount + ": " + line); 
                break;
            }
            lineCount++;

        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
