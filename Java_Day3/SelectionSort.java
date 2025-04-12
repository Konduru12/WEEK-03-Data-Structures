import java.util.Scanner;
public class SelectionSort{
    public void selectionSort(int[] scores){
        int temp;
        int minIndex;
        int size=scores.length;
        for(int i=0;i<size-1;i++){
            minIndex=i;
            for(int j=i+1;j<size;j++){
                if(scores[minIndex]>scores[j]){
                    minIndex=j;
                }
            }
            temp=scores[minIndex];
            scores[minIndex]=scores[i];
            scores[i]=temp;
        }
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter no of students: ");
        int num=input.nextInt();
        int[] scores=new int[num];

        for(int i=0;i<num;i++){
            System.out.print("Enter the marks of exam "+(i+1)+" : ");
            scores[i]=input.nextInt();
        }

        SelectionSort e1=new SelectionSort();
        e1.selectionSort(scores);
        System.out.print("Sorted exam scores:");
        for (int score : scores) {
            System.out.print(score+" ");
        }
    }
}
