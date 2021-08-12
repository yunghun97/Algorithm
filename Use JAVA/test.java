import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//import java.util.PriorityQueue;

public class test {
    public static void main(String[] args) {
        int flag = 0;
        for(int i=0; i<5; i++){
            flag = 1<<i;
            System.out.println(flag);
        }
        
        HashSet<String> hMap = new HashSet<>();

        /*PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);
        pq.add(1);
        pq.add(5);
        pq.add(3);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());*/
    }
}
