import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class AllStreams {
    public static void main(String[] args) {
        System.out.println("String Concatenation using StringBuilder:");
        UsingStringBuilder();
        System.out.println("String Concatenation using StringBuffer:");
        UsingStringBuffer();
        String filePath = "output.txt";  
        System.out.println("Word count in large file:");
        CountWords(filePath);
    }
    private static void UsingStringBuilder() {
        StringBuilder builder = new StringBuilder();
        String sample = "hello";
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            builder.append(sample);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken with StringBuilder: " + duration + " nanoseconds");
    }
    private static void UsingStringBuffer() {
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer buffer = new StringBuffer();
        String sample = "hello";  
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            buffer.append(sample);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken with StringBuffer: " + duration + " nanoseconds");
    }
    private static void CountWords(String filePath) {
        BufferedReader reader = null;
        long startTime = System.nanoTime();
        int wordCount = 0;
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("The file does not exist at the specified path: " + filePath);
            return; 
        }
        try {
            FileReader fileReader = new FileReader(filePath);
            reader = new BufferedReader(fileReader);  
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (words.length > 0) {
                    wordCount += words.length;
                }
            }

        } catch (IOException e) {
            return; 
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                return;
            }
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Time taken to read and count words: " + duration + " nanoseconds");
        System.out.println("Total words in the file: " + wordCount);
    }
}
