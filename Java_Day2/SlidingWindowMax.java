class MyDeque {
    int[] arr;
    int front, rear, size;

    public MyDeque(int capacity) {
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void addLast(int val) {
        arr[++rear] = val;
        size++;
    }

    public int removeLast() {
        size--;
        return arr[rear--];
    }

    public int removeFirst() {
        size--;
        return arr[front++];
    }

    public int peekFirst() {
        return arr[front];
    }

    public int peekLast() {
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
public class SlidingWindowMax {
    public static void maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        MyDeque deque = new MyDeque(n);
        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                System.out.print(nums[deque.peekFirst()] + " ");
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Sliding Window Maximums:");
        maxSlidingWindow(nums, k);
    }
}
