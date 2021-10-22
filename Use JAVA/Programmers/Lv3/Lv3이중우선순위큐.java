package Programmers.Lv3;

public class Lv3이중우선순위큐 {
    /*
    import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        // 총 넣은 숫자 - 남은 max 큐
        // 총 넣은 숫자 - 남은 min 큐
        // -> 위에 연산이 총 넣은 숫자 보다 많으면 0 0;
        PriorityQueue<Integer> MaxQ = new PriorityQueue<>((o1,o2)-> Integer.compare(o2,o1));
        PriorityQueue<Integer> MinQ = new PriorityQueue<>((o1,o2)-> Integer.compare(o1,o2));
        StringTokenizer st;
        int[] answer = new int[2];
        int count =0;
        int minusCount = 0;
        for(int i=0; i<operations.length; i++){
            char order = operations[i].charAt(0);
            if(order=='I'){
                st = new StringTokenizer(operations[i]);
                st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                MaxQ.add(a);
                MinQ.add(a);
                count++;
            }else{
                minusCount++;
                if(count<=minusCount){
                    count=0;
                    minusCount=0;
                    MinQ.clear();
                    MaxQ.clear();
                }
                if(operations[i].charAt(2)=='-'){   // 최솟값 삭제
                    MinQ.poll();
                }else{  // 최대값 삭제
                    MaxQ.poll();
                }
            }
        }
        if(!MaxQ.isEmpty()){
            answer[0] = MaxQ.poll();
        }
        if(!MinQ.isEmpty()){
            answer[1] = MinQ.poll();
        }
        return answer;
    }
}
    */
}
//https://programmers.co.kr/learn/courses/30/parts/12117