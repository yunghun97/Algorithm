/*
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1,o2));
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        int answer = 0;
        int num1=0;
        int num2=0;
        while(!pq.isEmpty()){
            num1 = pq.poll();
            if(num1>=K) break;
            if(pq.size()==0){
                answer = -1;
                break;
            } 
            num2 = pq.poll();
            pq.add(num1+num2*2);                
            answer++;
        }
        return answer;
    }
}
https://programmers.co.kr/learn/courses/30/lessons/42626 

*/