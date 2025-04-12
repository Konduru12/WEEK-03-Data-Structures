import java.util.Scanner;
public class QuickSort{
    public void quicksort(int[] prices,int low,int high){
        if(low<high){
            int pivot=partition( prices,low,high);
            quicksort(prices, low, pivot-1);
            quicksort(prices, pivot+1, high);
        }
    }
    public static int partition(int[] prices,int low,int high){
        int i=low-1;
        int pivot=prices[high];
        for(int j=low;j<high;j++){
            if(prices[j]<pivot){
                i++;
                int temp=prices[i];
                prices[i]=prices[j];
                prices[j]=temp;
            }
        }
        int temp=prices[i+1];
        prices[i+1]=prices[high];
        prices[high]=temp;
        return i+1;
    }
    public static void main(String[] args) {
        Scanner inp =new Scanner(System.in);
        System.out.print("Enter the number of products: ");
        int num=inp.nextInt();
        int[] prices=new int[num];
        System.out.println("Enter prices of "+num);
        for(int i=0;i<num;i++){
            System.out.print("Enter price of "+(i+1)+": ");
            prices[i]=inp.nextInt();
        }
        QuickSort p1=new QuickSort();
        p1.quicksort(prices, 0, num-1);
        System.out.println("Sorted prices in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
