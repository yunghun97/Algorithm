package BackJun.Gold;

import java.io.*;
import java.util.*;
// DFS 2번 사용
// 한 정점에서 제일 먼 트리의 정점은 가장 먼 트리 정점 2개 사이를 무조건 거친다.
public class G3트리의지름_1167 {
    static int N;
    static int[] disArr;
    static ArrayList<Node>[] list;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        disArr = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int endPoint = Integer.parseInt(st.nextToken());
                if(endPoint==-1) break;
                int distance = Integer.parseInt(st.nextToken());
                list[num].add(new Node(endPoint, distance));
                list[endPoint].add(new Node(num, distance));
            }
        }
        isVisited = new boolean[N+1];
        dfs(1);
        int index = 0;
        int max = 0;
        for(int i=1; i<=N; i++){
            if(disArr[i]>max){
                max = disArr[i];
                index = i;
            }            
        }
        Arrays.fill(isVisited, false);
        dfs(index);
        int answer = 0;
        for(int i=1; i<=N; i++){
            answer = Math.max(answer, disArr[i]);
        }
        bw.write(""+answer);
        bw.flush();
    }
    private static void dfs(int cnt) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.dis, o1.dis));
        Arrays.fill(disArr, 0);
        isVisited[cnt] = true;
        pq.add(new Node(cnt,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            isVisited[node.endPoint] = true; // 현재 도착부분은 해당 노드의 최대 
            for(int i=0; i<list[node.endPoint].size(); i++){
                Node tmpNode = list[node.endPoint].get(i);
                if(isVisited[tmpNode.endPoint]) continue;
                if(disArr[tmpNode.endPoint]<node.dis+tmpNode.dis){
                    disArr[tmpNode.endPoint] =node.dis+tmpNode.dis;                    
                    pq.add(new Node(tmpNode.endPoint, disArr[tmpNode.endPoint]));
                }
            }
        }
    }
    static class Node{
        int endPoint;
        int dis;
        public Node(int endPoint, int dis){
            this.endPoint = endPoint;
            this.dis = dis;
        }
    }
}
// https://www.acmicpc.net/problem/1167