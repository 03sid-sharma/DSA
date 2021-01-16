import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers={7,3,1,4,6,2,3};
        InsSorter insertionSort = new InsSorter();
        insertionSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

class InsSorter{
    public void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int current=arr[i];
            int j=i-1;
            while(j>=0&&arr[j]>current){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=current;
        }
    }
}
