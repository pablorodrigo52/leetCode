public class Main {

    public static void main(String[] args) {
        int nums[] = {1,2,2,3};
        System.out.println(isIncreasing(nums) || isDecreasing(nums));
    }

    private static boolean isIncreasing(int[] nums) {
        for (int i=0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isDecreasing(int[] nums) {
        for (int i=0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                return false;
            }
        }
        return true;
    }
}
