import java.util.*;

class MyClass {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n= scan.nextInt();
        int res[] = new int[n];
        for(int i = 0;i<n;i++)
            res[i] = scan.nextInt();
        
        Sorter srt = new Sorter();
        srt.mergeSort(res);
        // selectionSort(res);
        // insertionSort(res);

        System.out.println("Sorted array after merge sort: " + Arrays.toString(res));
      }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j>=0 && arr[j]>current) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            var temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
      
}
class Sorter{
    public void mergeSort(int[] arr) {
        if(arr.length<2)
            return;

        int middle = arr.length/2;
        int left[] = new int[middle];
        int right[] = new int[arr.length - middle];

        for (int i = 0; i < middle; i++) 
            left[i] = arr[i];
            
        for (int i = middle; i < arr.length; i++) 
            right[i-middle] = arr[i];
        
        mergeSort(left);
        mergeSort(right);

        sort(arr, left, right);
    }

    private void sort(int[] result, int[] left, int[] right) {
        int i=0,j=0,k=0;

        while(i<left.length && j<right.length){
            if(left[i] <= right[j])
                result[k++] = left[i++];
            else
                result[k++] = right[j++];
        }
        while (i<left.length) 
            result[k++] = left[i++];
        
        while (j<right.length) 
            result[k++] = right[j++];
        
    }
}