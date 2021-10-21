package Programmers.Lv3;

public class Lv3네트워크 {
    /*
    import java.util.*;
class Solution {    
    static int answer;
    static ArrayList<Node>[] list;
    static boolean[] isVisited; // 방문 체크용
    public int solution(int n, int[][] computers) {
        answer = 0;
        list = new ArrayList[n];
        isVisited = new boolean[n];
        for(int i=0; i<n; i++){ // 리스트 초기화
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<n ;i++){ // 리스트 넣는 작업
            for(int j=0; j<n; j++){ // 자기자신은 넣지 않는다.
                if(i==j) continue;
                if(computers[i][j]!=0) list[i].add(new Node(i,j));
            }
        }
        for(int i=0; i<n; i++){ // 방문안한거 BFS 탐색
            if(!isVisited[i]){
                BFS(i);        
                answer++;
            }
        }
        
        return answer;
    }
    void BFS(int num){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=0; i<list[tmp].size(); i++){
                Node node = list[tmp].get(i);
                if(isVisited[node.end]) continue;
                isVisited[node.end] = true;
                q.add(node.end);
            }
        }
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
    */
}
