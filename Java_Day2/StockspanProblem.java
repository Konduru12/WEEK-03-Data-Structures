class Stack {
    int[] arr;
    int top;
    int capacity;
    public Stack(int size) {
        arr = new int[size];
        top = -1;
        capacity = size;
    }
    public void push(int x) {
        if (top < capacity - 1) arr[++top] = x;
    }
    public int pop() {
        if (top == -1) return -1;
        return arr[top--];
    }
    public int peek() {
        if (top == -1) return -1;
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
public class StockspanProblem {
    public static void calculateSpan(int[] price, int n, int[] span) {
        Stack stack = new Stack(n);
        span[0] = 1;
        stack.push(0); 
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[i] >= price[stack.peek()]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        int[] price = {100, 80, 60, 70, 60, 75, 85};
        int n = price.length;
        int[] span = new int[n];

        calculateSpan(price, n, span);

        System.out.println("Stock Prices: ");
        for (int p : price) System.out.print(p + " ");
        System.out.println("\nSpans: ");
        for (int s : span) System.out.print(s + " ");
    }
}
