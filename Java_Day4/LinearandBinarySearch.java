import java.util.Arrays;

public class LinearandBinarySearch {
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int val = Math.abs(arr[i]);
            if (val <= n) {
                arr[val - 1] = -Math.abs(arr[val - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;  
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;  
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, -1, 1};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int missingPositive = findFirstMissingPositive(arr1);
        System.out.println("First missing positive: " + missingPositive);
        Arrays.sort(arr2);  
        int target = 5;
        int targetIndex = binarySearch(arr2, target);
        if (targetIndex != -1) {
            System.out.println("Target " + target + " found at index: " + targetIndex);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
