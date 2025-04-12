import java.util.Scanner;
public class CountingSort{
    public void countingsort(int[] ages){
        int max=ages[0];
        for(int age:ages){
            if(age>max){
                max=age;
            }
        }
        int[] count=new int[max+1];
        for(int age:ages){
            count[age]++;
        }
        int index=0;
        for(int i=0;i<=max;i++){
            while(count[i]-->0){
                ages[index++]=i;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of Students: ");
        int n = input.nextInt();

        int[] arr = new int[n];
        System.out.print("Enter " + n + " ages of students: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        CountingSort sorter = new CountingSort();
        sorter.countingsort(arr);

        System.out.println("\nSorted ages:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
