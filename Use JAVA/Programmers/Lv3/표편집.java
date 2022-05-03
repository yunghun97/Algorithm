package Programmers.Lv3;

import java.util.*;
public class 표편집 {
    private static int[] pre, next;
    private static boolean[] isAlright;
    private static Stack<Node> stack;
    private static int nowLocate;
    public String solution(int n, int k, String[] cmd) {
        pre = new int[n]; // 이전노드
        next = new int[n]; // 다음 노드
        nowLocate = k;
        isAlright = new boolean[n];
        Arrays.fill(isAlright,true);
        for(int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;            
        }
        next[n - 1] = -1; // 마지막에는 다음 노드가 없음
        
        stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cmd.length; i++) {
            String order = cmd[i];
            if(order.contains("U")||order.contains("D")) {
                select(order);                
            }else if(order.equals("C")) { // 삭제
                pop();                
            } else { // 추가
                push();
            }
        }
        for(int i=0; i<n; i++){
            if(isAlright[i]) sb.append("O");
            else sb.append("X");
        }
        return sb.toString();
    }
    private static void select(String order){
        StringTokenizer st = new StringTokenizer(order," ");
        String kind = st.nextToken();
        int count = Integer.parseInt(st.nextToken());
        if(kind.equals("U")){ // 위로      
            while(count-- > 0) {
                    nowLocate = pre[nowLocate];
            }
        }else{ // 아래로
            while(count-- > 0) {
                    nowLocate = next[nowLocate];
            }
        }
    }
    private static void pop(){
        stack.push(new Node(pre[nowLocate], nowLocate, next[nowLocate])); // 현재 이전노드 위치, 현재위치, 다음 노드 위치 설정
        if(pre[nowLocate] != -1) next[pre[nowLocate]] = next[nowLocate];  // 맨 앞이 아니면 내 앞에 있는 노드에게 내 뒤의 좌표를 할당
        if(next[nowLocate] != -1) pre[next[nowLocate]] = pre[nowLocate]; // 맨 뒤가 아니면 내 뒤에있는 노드에게 내 앞에 좌표를 할당
        isAlright[nowLocate] = false;
        
        if(next[nowLocate] != -1) nowLocate = next[nowLocate]; // 내가 마지막이 아니면 아래 행 선택
        else nowLocate = pre[nowLocate]; //마지막 행인 경우에 윗 행 선택
    }
    private static void push(){
        Node node = stack.pop();  // 연결 정보 복구
        if(node.pre != -1) next[node.pre] = node.cur; // 내가 처음 노드가 아니엇을 때 : next[node.pre] 이전 노드가 가르키는 next 노드 좌표를 나로 설정
        if(node.next != -1) pre[node.next] = node.cur; // 내가 마지막 노드가 아니었을 때 : pre[node.ntext] 내 다음 노드가 가르키는 prev 노드 좌표를 나로 설정
        isAlright[node.cur] = true;
    }
    
    public static class Node{
        int pre, cur, next;
        
        public Node(int pre, int cur, int next) {
            this.pre = pre;
            this.cur = cur;
            this.next = next;
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/81303