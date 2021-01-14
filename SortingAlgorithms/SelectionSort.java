import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers={7,3,1,4,6,2,3};
        SelSorter selectionSort = new SelSorter();
        selectionSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}

class SelSorter {
    
    public void sort(int[] array){
        for(int i=0; i<array.length; i++){
            int minIndex = findMinIndex(array, i);
            swap(array,minIndex,i);
        }
    }

    private int findMinIndex(int[] array, int i) {
        int minIndex=i;
        for(int j=i; j<array.length; j++)
            if(array[j]<array[minIndex])
            minIndex=j;
        return minIndex;
    }
    
    private void swap(int[] array, int index1,int index2) {
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
}
