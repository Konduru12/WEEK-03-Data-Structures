import java.util.Scanner;
public class MergeSort{
    public void mergeSort(int[] prices,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(prices, l, m);
            mergeSort(prices, m+1, r);
            merge(prices,l,m,r);
        }
    }
    public void merge(int[] prices,int l,int m,int r){
        int n1=m-l+1;
        int n2=r-m;
        int[] larr=new int[n1];
        int[] rarr=new int[n2];
        for(int i=0;i<n1;i++){
            larr[i]=prices[i+l];
        }
        for(int i=0;i<n2;i++){
            rarr[i]=prices[m+1+i];
        }
        int i=0;
        int j=0;
        int k=l;
        while(i<n1 && j<n2){
            if(larr[i]<rarr[j]){
                prices[k]=larr[i];
                i++;
            }else{
                prices[k]=rarr[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            prices[k]=larr[i];
            i++;
            k++;
        }
        while(j<n2){
            prices[k]=rarr[j];
            k++;
            j++;
        }
    }
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int num=inp.nextInt();
        int[] prices=new int[num];
        for(int i=0;i<num;i++){
            System.out.print("Enter price of "+(i+1)+" book: ");
            prices[i]=inp.nextInt();
        }
        MergeSort b1=new MergeSort();
        b1.mergeSort(prices, 0, num-1);
         System.out.println("\nPrices after sorting in ascending order:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
    }
}
