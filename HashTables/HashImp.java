import java.util.*;

/**
 * HashImp
 */
public class HashImp {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        // LinkedHashMap<Integer,String> m = new LinkedHashMap<>(4,0.6f,true);
        map.put(1,"Dustin");
        map.put(2,"Robin");
        map.put(3,"i");
        
        for(var item:map.entrySet()){
            System.out.println(item.getKey());
            // System.out.println(item.getValue());
        }


        System.out.println(map);
    }
}