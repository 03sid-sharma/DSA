import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers={7,3,1,4,6,2,3};
        Sorter bubbleSort = new Sorter();
        bubbleSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}

class Sorter {
    public void sort(int[] array){
        boolean isSorted;

        for(int i=0; i<array.length; i++) {
            isSorted = true;

            for(int j=1; j<array.length-i; j++)
                if(array[j]<array[j-1]){
                    swap(array, j, j-1);
                    isSorted=false;
                }

            if(isSorted)
                return;
        }
    }

    private void swap(int[] array, int index1,int index2) {
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
}