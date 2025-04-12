import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CountingtheOccurenceofWord{
    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void main(String[] args){
        String path = "readingafile.txt";
        String wordTarget = "it";
        FileReader file = null;
        BufferedReader bfreader = null;
        int counter = 0;
        try {
            file = new FileReader(path);
            bfreader = new BufferedReader(file);
            String line;
            while((line = bfreader.readLine()) != null){
                String[] words = line.split("\\s+");
                for(String word: words){
                    if (word.equalsIgnoreCase(wordTarget)) {
                        counter++;
                    }
                } 
            }
            System.out.println("The word '" + wordTarget + "' appears " + counter + " times in the file.");
        } catch (IOException e) {
            return;
        }
        finally{
            try {
                if(bfreader != null){
                    bfreader.close();
                }
                if(file != null){
                    file.close();
                }
            } catch (IOException e) {
                return;
            }
        }

    }
}