

import java.util.Arrays;

import bubblesort.Bubblesort;
import quicksort.Quicksort;

public class Solution {
    public static void main(String[] args) {
        
        int[] array = {5,6,2,1,4,7,8,9,3};
        int elementToSearch = 3;

        Quicksort.quicksort(array, 0, array.length-1);  
        System.out.println("Quicksort - Recursive binary search for " + elementToSearch + " = " 
        + recursiveBinarySearch(array, elementToSearch));


        int[] array2 = {5,6,2,1,4,7,8,9,3};
        Bubblesort.bubblesort(array2);
        System.out.println("Bubblesort - Iterative binary search for " + elementToSearch + " = " 
        + iterativeBinarySearch(array2, elementToSearch));
    }

    public static boolean recursiveBinarySearch(int[] array, int element) {
        System.out.println("step");
        int middle = array.length / 2;
        int pivot = array[middle];

        if (array[0] == element || 
            pivot == element ||
            array[array.length-1] == element) {
            return true;
        }

        if (middle == 0) {
            return false;
        }

        if (pivot > element) {
            int [] subarray = Arrays.copyOfRange(array, 0, middle);
            return recursiveBinarySearch(subarray, element);
        } else {
            int [] subarray = Arrays.copyOfRange(array, middle, array.length);
            return recursiveBinarySearch(subarray, element);
        }
    }

    public static boolean iterativeBinarySearch(int[] array, int element) {
        System.out.println("step");
        int start = 0;
        int end = array.length - 1;
        int middle = start + end / 2;

        if (array[start] == element || 
            array[end] == element ||
            array[middle] == element) {
            return true;
        }
        
        while (start <= end) {
            System.out.println("step");
            middle = (int) Math.floor((start + end) / 2);

            if (array[middle] < element) {
                start = middle + 1;
            } else if (array[middle] > element) {
                end = middle - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
