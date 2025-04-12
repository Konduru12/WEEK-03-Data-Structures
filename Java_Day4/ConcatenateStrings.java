public class ConcatenateStrings{
    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!"};
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word);
        }
        System.out.println(sb.toString());

    }
}