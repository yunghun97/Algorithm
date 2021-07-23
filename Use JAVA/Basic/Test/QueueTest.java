package Basic.Test;
import java.util.*;
public class QueueTest {
    public static void mainQueueTest(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(10);
        q.add(20);
        q.add(30);
        int a ;
        for(int i =0; i<q.size();){
            a = q.poll();
            //q.remove();
            System.out.println(a);
        }
        
    }
}
