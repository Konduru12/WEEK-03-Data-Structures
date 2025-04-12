import java.util.Scanner;
public class SearchTargetElement {
    public static boolean searchTarget(int[] arr, int target) {
        int numColumns = 6;
        @SuppressWarnings("unused")
        int rows = arr.length / numColumns; 
        int left = 0;
        int right = arr.length - 1;  
        while (left <= right) {
            int mid = (left + right) / 2;  
            int row = mid / numColumns;
            int col = mid % numColumns;
            System.out.println("Mid Index: " + mid + " Row: " + row + " Col: " + col);

            if (arr[mid] == target) {
                System.out.println("Element Found at Row: " + row + ", Column: " + col);
                return true;
            } else if (arr[mid] > target) {
                right = mid - 1;  
            } else {
                left = mid + 1;  
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println("Enter the Target Element in the given array:");
        int target = input.nextInt();
        boolean found = searchTarget(arr, target);
        if (found) {
            System.out.println("Target element " + target + " was found.");
        } else {
            System.out.println("Target element " + target + " was not found.");
        }
        input.close();
    }
}
}