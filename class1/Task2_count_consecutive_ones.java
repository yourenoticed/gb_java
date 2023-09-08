public class Task2_count_consecutive_ones {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 0, 1};
        int counter = countConsecutiveOnes(nums);
        System.out.println(counter);
    }
    
    public static int countConsecutiveOnes(int[] binary_nums) {
        int max_consecutive_ones = 0;
        int ones = 0;
        for (int value : binary_nums) {
            if (value == 1) ones++;
            else if (max_consecutive_ones < ones) {
                max_consecutive_ones = ones;
                ones = 0;
            }
        }
        return ones;
    }  
}