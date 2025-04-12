public class RecursiveFiboVsIteratuveFibo{
    public static int recursive(int n) {
        if (n <= 1) return n;
        return recursive(n - 1) + recursive(n - 2);
    }
    public static int iterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void TimesComparsion(int n) {
        long startTime = System.currentTimeMillis();
        if (n <= 30) { 
            recursive(n);
            long endTime = System.currentTimeMillis();
            System.out.println("Recursive Fibonacci Time for " + n + ": " + (endTime - startTime) + " ms");
        } 
        startTime = System.currentTimeMillis();
        iterative(n);
        long endTime = System.currentTimeMillis();
        System.out.println("Iterative Fibonacci Time for " + n + ": " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) {
        int[] sizes = {10, 30, 50};
        for (int size : sizes) {
            TimesComparsion(size);
        }
    }
}
