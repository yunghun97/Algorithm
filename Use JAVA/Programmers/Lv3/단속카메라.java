package Programmers.Lv3;

import java.util.*;

public class 단속카메라 {
    public int solution(int[][] routes) {
        
        int answer = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(o1.end, o2.end); // 끝나는 시간 기준으로 오름차순 정렬
        }); 
        for(int i = 0; i<routes.length; i++){
            pq.add(new Node(routes[i][0], routes[i][1]));   
        }
        
        int now = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.start>now){ // 다음 차의 시작지점이 과속 카메라에 걸리지 않으면 해당 차의 끝난 점으로 설정하기
                answer++;
                now = node.end;
            }
        }
        return answer;
    }
    
    class Node{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/42884