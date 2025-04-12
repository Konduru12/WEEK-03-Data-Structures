public class ReverseString{
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        sb.reverse();
        String result = sb.toString();
        System.out.println(result);
    }
}