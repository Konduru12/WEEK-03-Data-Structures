import java.util.Scanner;
public class FirstNegativeNumber{
    public static int calculate(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println("Enter the numbers:");
        Scanner input = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = input.nextInt();
        }
        int result=FirstNegativeNumber.calculate(arr);
        if(result!=-1){
            System.out.println("Element  is found at " + result + " is " +  arr[result]);
        }
        else{
            System.out.println("Not found");
        }
        
    }
}
