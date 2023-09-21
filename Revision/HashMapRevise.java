import java.util.HashMap;
import java.util.Map;

class HashMapRevise {
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,1,1,1,1,2,2,3,3,3,4,4,4,4,4};
        Map<Integer,Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.containsKey(i)? map.get(i) + 1 : 1);
        }
        int max = 0;
        int index = 0;
        for (var entry : map.entrySet()) {
            if(entry.getValue() > max){
                max = entry.getValue();
                index = entry.getKey();
            }
        }
        System.out.println(index);
    }
}
