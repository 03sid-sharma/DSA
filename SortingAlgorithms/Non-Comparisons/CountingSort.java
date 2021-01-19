import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        CSorter countingSort = new CSorter();
        countingSort.sort(numbers, 7);
        System.out.println(Arrays.toString(numbers));
    }
}

class CSorter {
    public void sort(int[] arr, int max) {
        int counts[] = new int[max + 1];
        for (int item : arr) {
            counts[item]++;
        }

        // Refill the array
        int k = 0;
        for (int i = 0; i < counts.length; i++)
            for (int j = 0; j < counts[i]; j++)
                arr[k++] = i;
    }
}
