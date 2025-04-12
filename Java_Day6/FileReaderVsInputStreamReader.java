import java.io.*;

public class FileReaderVsInputStreamReader{
    public static void usingFileReader(String fileName) throws IOException {
        try(FileReader fr = new FileReader(fileName)){
        @SuppressWarnings("unused")
        int ch;
        while ((ch = fr.read()) != -1) {
        }
        fr.close();
    }
    }
    public static void usingInputStreamReader(String fileName) throws IOException {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(fileName))){
        @SuppressWarnings("unused")
        int ch;
        while ((ch = isr.read()) != -1) {
        }
        isr.close();
    }
    }
    public static void TimesComparsion(String fileName) {
        File file = new File(fileName);  
        if (!file.exists()) {
            System.out.println("The file does not exist at the specified path: " + fileName);
            return;
        }
        try {
            long startTime = System.currentTimeMillis();
            System.out.println("Reading with FileReader...");
            usingFileReader(fileName);
            long endTime = System.currentTimeMillis();
            System.out.println("FileReader Time: " + (endTime - startTime) + " ms");
            startTime = System.currentTimeMillis();
            System.out.println("Reading with InputStreamReader...");
            usingInputStreamReader(fileName);
            endTime = System.currentTimeMillis();
            System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ms");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String fileName = "sample.txt"; 
        TimesComparsion(fileName);
    }
}
