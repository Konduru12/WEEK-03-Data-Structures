public class BubbleSort{
    public static void main(String[] args){
        int marks[] = {100,98,54,79,80};
        int size = marks.length;
        int temp;
        System.out.println("Before Sorting:");
        for(int mark:marks){
            System.out.print(mark + " ");
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size-i-1; j++){
                if(marks[j] > marks[j+1]){
                temp = marks[j];
                marks[j] = marks[j+1];
                marks[j+1] = temp;
            }
        }
    }
    System.out.println();
    System.out.println("After Sorting:");
    for(int mark : marks){
        System.out.print(mark + " ");
    }
}
}
