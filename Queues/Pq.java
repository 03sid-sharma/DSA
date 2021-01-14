import java.util.*;

public class Pq {

    public static void main(String[] args) {
        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        namePriorityQueue.add("A");
        namePriorityQueue.add("D");
        namePriorityQueue.add("C");
        namePriorityQueue.add("B");
        namePriorityQueue.add("E");
        namePriorityQueue.add("F");

        while (!namePriorityQueue.isEmpty()) {
            System.out.println(namePriorityQueue.remove());
        }

    }
}