public class StringConcatenation{
    public static String withString(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "a"; 
        }
        return result;
    }
    public static String withStringBuilder(int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("a"); 
        }
        return result.toString();
    }
    public static String withStringBuffer(int n) {
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < n; i++) {
            result.append("a"); 
        }
        return result.toString();
    }
    public static void TimesComparsion(int n) {
        System.out.println("\nOperations Count: " + n);
        long startTime = System.currentTimeMillis();
        if (n <= 10000) { 
            withString(n);
            long endTimeString = System.currentTimeMillis();  
            System.out.println("String Concatenation Time: " + (endTimeString - startTime) + " ms");
        } else {
            System.out.println("Unusable");
        }
        long startTimeBuilder = System.currentTimeMillis();  
        withStringBuilder(n);
        long endTimeBuilder = System.currentTimeMillis();  
        System.out.println("StringBuilder Concatenation Time: " + (endTimeBuilder - startTimeBuilder) + " ms");
        long startTimeBuffer = System.currentTimeMillis();  
        withStringBuffer(n);
        long endTimeBuffer = System.currentTimeMillis();  
        System.out.println("StringBuffer Concatenation Time: " + (endTimeBuffer - startTimeBuffer) + " ms");
    }
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int size : sizes) {
            TimesComparsion(size);
        }
    }
}
