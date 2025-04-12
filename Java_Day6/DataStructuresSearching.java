import java.util.*;
public class DataStructuresSearching{
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        for (int N : sizes) {
            System.out.println("Dataset Size: " + N);
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = i;
            }
            long startTime = System.nanoTime();
            array(array, N - 1); 
            long endTime = System.nanoTime();
            System.out.println("Array Search: " + (endTime - startTime) / 1_000_000.0 + " ms");
            HashSet<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < N; i++) {
                hashSet.add(i);
            }
            startTime = System.nanoTime();
            hashSet(hashSet, N - 1);
            endTime = System.nanoTime();
            System.out.println("HashSet Search: " + (endTime - startTime) / 1_000_000.0 + " ms");
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                treeSet.add(i);
            }
            startTime = System.nanoTime();
            treeSet(treeSet, N - 1); 
            endTime = System.nanoTime();
            System.out.println("TreeSet Search: " + (endTime - startTime) / 1_000_000.0 + " ms");
            System.out.println();
        }
    }
    public static void array(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return; 
            }
        }
    }
    public static void hashSet(HashSet<Integer> hashSet, int target) {
        hashSet.contains(target); 
    }
    public static void treeSet(TreeSet<Integer> treeSet, int target) {
        treeSet.contains(target); 
    }
}
