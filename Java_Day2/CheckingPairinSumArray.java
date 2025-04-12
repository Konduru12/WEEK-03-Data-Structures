import java.util.HashSet;

public class CheckingPairinSumArray {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println("Pair found: (" + num + ", " + complement + ")");
                return true;
            }
            set.add(num);
        }
        System.out.println("No pair found with the given sum.");
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int target = 10;
        hasPairWithSum(arr, target);
    }
}
