import java.util.*;
public class SetsImp {

    public static void main(String[] args) {
        Set<Integer> set =new HashSet<>();
        int []numbers={5,4,5,3,2,2,1,1,2};
        for(int num:numbers){
            set.add(num);
        }
        System.out.println(set);
    }
}