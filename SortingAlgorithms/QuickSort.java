import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 5, 2 };
        QSorter quickSort = new QSorter();
        quickSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

class QSorter {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        // Base Condition
        if (start >= end)
            return;

        // Partition
        int boundary = partition(arr, start, end);
        // Sort Left
        sort(arr, start, boundary - 1);
        // Sort Right
        sort(arr, boundary + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int boundary = start - 1;
        for (int i = start; i <= end; i++)
            if (arr[i] <= pivot)
                swap(arr, i, ++boundary);

        return boundary;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}