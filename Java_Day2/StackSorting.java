class Stack{
    int[] arr;
    int top;
    int capacity;

    public Stack(int size) {
        arr = new int[size];
        top = -1;
        capacity = size;
    }

    public void push(int x) {
        if (top < capacity - 1) {
            arr[++top] = x;
        }
    }

    public int pop() {
        if (isEmpty()) return -1;
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
public class StackSorting {
    static void sort(Stack stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sort(stack);
            insertInSortedOrder(stack, temp);
        }
    }
    static void insertInSortedOrder(Stack stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, element);
            stack.push(temp);
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);

        System.out.println("Original Stack:");
        stack.printStack();
        sort(stack);
        System.out.println("Sorted Stack (Ascending):");
        stack.printStack();
    }
}
