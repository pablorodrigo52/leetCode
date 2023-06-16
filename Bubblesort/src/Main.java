import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,3,4,5,1,2};
        Arrays.stream(bubbleSort(nums)).forEach(el -> System.out.print(el));
    }


    private static int[] bubbleSort(int [] nums) { // O(n^2)

        for (int i = 0; i < nums.length; i++) { // O(n)

            for (int j = 0; j < nums.length - 1; j++) { // O(n - 1)
                if (nums[j] > nums[j+1]) {
                    int aux = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = aux;
                }
            }
        }

        return nums;
    }
}