class MyStack {
    int[] arr;
    int top;
    int capacity;
    public MyStack(int size) {
        arr = new int[size];
        top = -1;
        capacity = size;
    }
    public void push(int x) {
        if (top < capacity - 1) {
            arr[++top] = x;
        } else {
            System.out.println("Stack Overflow");
        }
    }
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
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
public class QueueUsingStacks{
    MyStack stack1;
    MyStack stack2;
    public QueueUsingStacks(int size) {
        stack1 = new MyStack(size);
        stack2 = new MyStack(size);
    }
    public void enqueue(int x) {
        stack1.push(x);
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks(10);
        queue.enqueue(5);
        queue.enqueue(10);
        queue.enqueue(15);
        System.out.println("Dequeued: " + queue.dequeue()); 
        System.out.println("Dequeued: " + queue.dequeue()); 
        System.out.println("Dequeued: " + queue.dequeue()); 
        System.out.println("Dequeued: " + queue.dequeue()); 
    }
}
