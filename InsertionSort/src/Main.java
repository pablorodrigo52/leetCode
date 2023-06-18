import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 6, 3, 1, 8, 7, 2, 4};

        Arrays.stream(insertionSort(numbers)).forEach(e -> System.out.print(e + " "));
    }


    private static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int element = arr[i];
            int j = i;

            while ( j > 0 && arr[j-1] > element) {
                arr[j] = arr[j-1];
                j -= 1;
            }
            
            arr[j] = element;
        }
        return arr;
    }

}
