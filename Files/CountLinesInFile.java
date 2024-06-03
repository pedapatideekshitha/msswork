import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountLinesInFile {
    public static void main(String[] args) {
        String filePath = "/home/miracle/Desktop/Readspecline.txt";   // Path to your file

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lineCount = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
            }

            System.out.println("Total number of lines in the file: " + lineCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
