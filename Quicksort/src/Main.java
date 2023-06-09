public class Main {

    public static void main(String[] args) {
        int [] anyArray = {4,2,7,5,1,6,3};

        // divide and conqueror algorithm
        // recursive
        // 

        quicksort(anyArray, 0, anyArray.length-1);


        for(int num: anyArray) {
            System.out.print(num);
            System.out.print(" ");
        }
    }


    private static void quicksort(int[] array, int start, int end) { // O(n log n)
        if (start <= end) {
            for(int num: array) {
                System.out.print(num);
                System.out.print(" ");
            }
            System.out.println();
            int pivotIndex = partition(array, start, end);

            quicksort(array, start, pivotIndex-1);
            quicksort(array, pivotIndex+1, end);
        }
    }


    private static int partition(int[] array, int start, int end) { // O(n)
        
        int pivot = array[end];

        int i = start-1;

        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                int aux = array[i];
                array[i] = array[j];
                array[j] = aux;
            }
        }

        i++; 
        int aux = array[i];
        array[i] = array[end];
        array[end] = aux;
        return i;
    }
}