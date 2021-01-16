import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        MSorter mergeSort = new MSorter();
        mergeSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

class MSorter {
    public void sort(int[] arr) {
        //Base condition
        if(arr.length <2)
            return;

        //Divide this array into half
        int middle=arr.length/2;

        int[] left= new int[middle];
        for(int i=0;i<middle;i++){
            left[i]=arr[i];
        }

        int[] right=new int[arr.length-middle];
        for(int i=middle;i<arr.length;i++){
            right[i-middle]=arr[i];
        }

        //Sort each half
        sort(left);
        sort(right);

        //Merge the result
        merge(left,right,arr);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }

    }
}
