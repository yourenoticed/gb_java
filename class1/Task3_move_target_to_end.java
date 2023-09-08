public class Task3_move_target_to_end {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 3, 3, 1, 2, 5, 4, 3, 6};
        moveTargetToEnd(numbers, 3);
        printArray(numbers);
    }

    public static void moveTargetToEnd(int[] array, int target) {
        int movedTargets = 0;
        for (int i = 0; i < array.length - movedTargets; i++) {
            if (array[i] == target) {
                for (int k = i; k < array.length - 1 - movedTargets; k++) {
                    swap(array, k, k + 1);
                }
                movedTargets++;
                i--;
            }
        }
    }

    public static void swap(int[] array, int swappedIndexL, int swappedIndexR) {
        int temp = array[swappedIndexL];
        array[swappedIndexL] = array[swappedIndexR];
        array[swappedIndexR] = temp;
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
}