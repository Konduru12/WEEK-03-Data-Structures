import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadandWrite {
    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void main(String[] args) {
        String file = "output.txt"; 
        BufferedReader bfreader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = null;
        try {
            writer = new FileWriter(file, true);  
            String inputLine;
            System.out.println("Enter text to write to the file. Type 'exit' to stop.");
            while (true) {
                inputLine = bfreader.readLine();
                if ("exit".equalsIgnoreCase(inputLine)) {
                    System.out.println("Exiting program.");
                    break;
                }
                writer.write(inputLine + "\n");
            }
        } catch (IOException e) {
            return;
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                return;
            }
        }
    }
}
