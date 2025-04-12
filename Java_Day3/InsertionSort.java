import java.util.Scanner;
public class InsertionSort{
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        System.out.print("Enter the no of employees: ");
        int num=inp.nextInt();
        int[] id=new int[num];
        System.out.println("Enter the id's of "+ num +"employees");
        for(int i=0;i<num;i++){
            System.out.print("Enter the id of employee " +(i+1)+ " : ");
            id[i]=inp.nextInt();
        }
        for(int i=1;i<num;i++){
            int key=id[i];
            int j=i-1;
            while(j>=0 && id[j]>key){
                id[j+1]=id[j];
                j=j-1;
            }
        id[j+1]=key;
        }
        System.out.print("After sorting using insertion sort: ");
        for (int ids:id){
            System.out.print(ids+" ");
        }
    }
}
