public class RotatedSortedArray{
    private static int sortedArray(int[] arr) {
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(arr[mid]>arr[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
         return left;
    }
    public static void main(String[] args) {
        int[] arr={4, 5, 6, 0, 1, 2, 3}; 
        int result=sortedArray(arr);
        System.out.println("Index is at: "+result);
        System.out.println("Element is: "+arr[result]);
        System.out.print("Rotated array starting from smallest element: ");
        for (int i = result; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int i = 0; i < result; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}