package quicksort;
import java.util.Arrays;

public class Quicksort {
    // public static void main(String[] args) {
    //     // do a binary search on array
    //     int[] array = {5,6,2,1,4,7,8,9,3};


    //     quicksort(array, 0, array.length-1);

    //     Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    // }

    public static void quicksort(int array[], int start, int end) {
        if (start <= end) {

            int pivotIndex = partition(array, start, end);

            quicksort(array, start, pivotIndex-1);
            quicksort(array, pivotIndex+1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        
        int pivot = array[end];
        int j = start - 1;

        for(int i = start; i < end; i++) {
            if (array[i] < pivot) { 
                j++;
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        j++;
        int aux = array[j];
        array[j] = array[end];
        array[end] = aux;

        return j;
    }
}