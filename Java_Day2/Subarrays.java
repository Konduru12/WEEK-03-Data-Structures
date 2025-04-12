import java.util.*;

public class Subarrays{

    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumIndexMap = new HashMap<>();
        int sum = 0;
        sumIndexMap.put(0, new ArrayList<>());
        sumIndexMap.get(0).add(-1); 
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumIndexMap.containsKey(sum)) {
                for (int startIdx : sumIndexMap.get(sum)) {
                    System.out.println("Subarray found from index " + (startIdx + 1) + " to " + i);
                }
            }
            sumIndexMap.putIfAbsent(sum, new ArrayList<>());
            sumIndexMap.get(sum).add(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        System.out.println("Subarrays with zero sum:");
        findZeroSumSubarrays(arr);
    }
}
