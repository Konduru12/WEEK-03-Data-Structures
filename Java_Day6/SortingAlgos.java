import java.util.Arrays;
import java.util.Random;

public class SortingAlgos{
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            arr[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; 
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = temp;
        return i + 1;
    }
    public static int[] RandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size);
        return arr;
    }
    public static void TimesComparsion(int size) {
        System.out.println("\nDataset Size: " + size);
        int[] baseData = RandomArray(size);
        if (size <= 10000) { 
            int[] bubbleArray = Arrays.copyOf(baseData, baseData.length);
            long start = System.currentTimeMillis();
            bubbleSort(bubbleArray);
            long end = System.currentTimeMillis();
            System.out.println("Bubble Sort: " + (end - start) + " ms");
        } else {
            System.out.println("Bubble Sort: Skipped (too slow)");
        }
        int[] mergeArray = Arrays.copyOf(baseData, baseData.length);
        long start = System.currentTimeMillis();
        mergeSort(mergeArray);
        long end = System.currentTimeMillis();
        System.out.println("Merge Sort: " + (end - start) + " ms");
        int[] quickArray = Arrays.copyOf(baseData, baseData.length);
        start = System.currentTimeMillis();
        quickSort(quickArray, 0, quickArray.length - 1);
        end = System.currentTimeMillis();
        System.out.println("Quick Sort: " + (end - start) + " ms");
    }
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000}; 
        for (int size : sizes) {
            TimesComparsion(size);
        }
    }
}
