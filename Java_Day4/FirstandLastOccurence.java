public class FirstandLastOccurence {
    public static int first(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int firstOccurrence = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                firstOccurrence = mid;
                right = mid - 1;  
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return firstOccurrence;
    }
    public static int last(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int lastOccurrence = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                lastOccurrence = mid;
                left = mid + 1;  
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return lastOccurrence;
    }
    public static int[] FirstAndLast(int[] arr, int target) {
        int first = first(arr, target);
        if (first == -1) {
            return new int[] {-1};  
        } 
        int last = last(arr, target);
        return new int[] {first, last};
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 2, 2, 3, 4, 5, 5, 6};
        int target = 2;
        int[] result = FirstAndLast(arr, target);
        if (result[0] != -1) {
            System.out.println("First occurrence: " + result[0] + ", Last occurrence: " + result[1]);
        } else {
            System.out.println("Target not found");
        }
    }
}
