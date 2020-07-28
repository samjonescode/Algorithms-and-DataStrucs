package Sorting;

public class Quicksort {

    public static void main(String[] args) {
        int[] nums = { 1, -9, 2, 4, -20, 3, 30, 20, 11, 203 };
        quickSort(nums, 0, nums.length - 1);

        for (int i : nums) {
            System.out.println(i);
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot)
                left++;

            while (arr[right] > pivot)
                right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}