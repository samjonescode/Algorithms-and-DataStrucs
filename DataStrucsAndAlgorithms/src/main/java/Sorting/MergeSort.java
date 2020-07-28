package Sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = { 1, -9, 2, 4, -20, 3, 30, 20, 11, 203 };

        mergesort(nums);

        for (int i : nums) {
            System.out.println(i);
        }
    }

    static void mergesort(int[] array) {
        int[] helper = new int[array.length];

        mergesort(array, helper, 0, array.length - 1);

    }

    static void mergesort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergesort(array, helper, low, middle);
            mergesort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }

    static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = high;
        int current = low;

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperLeft];
                helperRight++;
            }
            current++;
        }

        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}