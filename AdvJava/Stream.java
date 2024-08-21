package AdvJava;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String args[]) {
        // var list = new ArrayList<Integer>();
        // list.add(10);
        // list.add(20);
        // list.add(30);
        // list.add(40);

        // list.stream().filter(num -> num > 20).forEach(System.out::println);

        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        // IntPredicate great = n->n>2;
        // Arrays.stream(arr).filter(great).limit(1).forEach(System.out::println);

        // Reducing a stream

        var ans = Arrays.stream(arr).findAny().getAsInt();
        // System.out.println(ans);
        var sum = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println(sum);

        // Collectors
        
        var res = Arrays.stream(arr).boxed().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(res);

        // Primitive type stream
        
        IntStream.rangeClosed(1,5).forEach(System.out::println);
    }
}
