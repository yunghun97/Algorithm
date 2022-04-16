package Programmers.Lv1;

import java.util.*;
public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1,o2));
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0) pq.add(arr[i]);
        }
        int[] answer;
        if(pq.size()!=0){
            answer = new int[pq.size()];
            int size = pq.size();
            for(int i=0; i<size; i++){
                answer[i] = pq.poll();
            }
        }else{
            answer = new int[]{-1};
        }
        
        return answer;
    }
}
