public class PeakElement{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,10};
        int left = 0;
        int right = arr.length - 1;
        int peak = -1;
        while(left <= right){
            int mid = (left+right)/2;
            boolean isPeak = (mid == 0 || arr[mid] >= arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);
            if (isPeak) {
                peak = arr[mid]; 
                break;  
            }
            else if(arr[mid] < arr[mid - 1]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if (peak != -1) {
            System.out.println("The peak element is: " + peak);
        } else {
            System.out.println("No peak element found.");
        }
    }
}