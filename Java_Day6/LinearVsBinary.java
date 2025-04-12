import java.util.Arrays;
import java.util.Random;

public class LinearVsBinary{
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1; 
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

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
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size); 
        }
        return arr;
    }
    public static void compareSearchAlgorithms(int size) {
        int[] linearArr = generateRandomArray(size);
        int[] binaryArr = Arrays.copyOf(linearArr, linearArr.length);
        Arrays.sort(binaryArr);
        int target = linearArr[2]; 
        long startTime = System.nanoTime();
        linearSearch(linearArr, target);
        long endTime = System.nanoTime();
        long linearSearchTime = endTime - startTime;
        startTime = System.nanoTime();
        binarySearch(binaryArr, target);
        endTime = System.nanoTime();
        long binarySearchTime = endTime - startTime;
        System.out.println("Dataset Size: " + size);
        System.out.println("Linear Search Time: " + linearSearchTime + " ns");
        System.out.println("Binary Search Time: " + binarySearchTime + " ns");
        System.out.println("------------------------------------------");
    }
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};

        for (int size : datasetSizes) {
            compareSearchAlgorithms(size);
        }
    }
}
