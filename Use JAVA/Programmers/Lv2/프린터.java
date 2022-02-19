package Programmers.Lv2;

import java.util.*;
public class 프린터 {
    public int solution(int[] priorities, int location) {
        int[] arr = new int[10];
        Queue<Node> q = new LinkedList<>();
        int index = 0;
        for(int num : priorities){
            arr[num]++;
            q.add(new Node(num,index++));
        }
        int answer = 1;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(maxCheck(node.priority, arr)){ // 뒤에 더 큰 값이 남아 있는 경우
                q.add(node);
            }else{  // 안 남아 있는 경우
                arr[node.priority]--;   // 해당 값 목록에서 제외하기
                if(node.order==location){   // 원하는 값이 출력 되었을 때
                    q.clear();
                    return answer;
                }else answer++; // 아니면 다음 꺼 탐색
                
            }
        }
        
        return 1;
    }
    private boolean maxCheck(int num, int[] input){
        for(int i = num+1; i<=9; i++){
            if(input[i]>=1) return true;
        }
        return false;
    }
    
    class Node{        
        int priority;
        int order;
        public Node(int priority, int order){
            this.priority = priority;
            this.order = order;
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/42587