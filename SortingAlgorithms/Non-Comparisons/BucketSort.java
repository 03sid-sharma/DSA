import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        BSorter bucketSort = new BSorter();
        bucketSort.sort(numbers, 3);
        System.out.println(Arrays.toString(numbers));
    }
}

class BSorter {
    public void sort(int[] arr, int numberOfBuckets) {
        int k=0;
        for(var bucket:createBuckets(arr,numberOfBuckets)){
            Collections.sort(bucket);
            for(var item:bucket)
                arr[k++]=item;
        }
    }

    private List<List<Integer>> createBuckets(int[] arr,int numberOfBuckets){
        List<List<Integer>> buckets = new LinkedList<>();
        for (var i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : arr)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }
}
