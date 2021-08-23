package SSFAlgorithmLearn.Day8;

import java.io.*;
import java.util.*;

public class AdjListTest {
    static class Node{
        int vertex; // 인접 정점 인덱스
        Node link;  
        public Node(int vertex, Node link){
            this.vertex = vertex;
            this.link = link;
        }
        @Override
        public String toString() {
            return "Node [link=" + link + ", vertex=" + vertex + "]";
        }
        
    }
    static int N;
    static Node[] adList;   // 인접 리스트
    public static void main(String[] args)  throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adList = new Node[N];
        int C = Integer.parseInt(in.readLine());
        for(int i=0; i<C; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adList[from] = new Node(to, adList[from]);
            adList[to] = new Node(from, adList[to]);
            
        }
        System.out.println("==============bfs=================");
        bfs();
        System.out.println("===============dfs===================");
        boolean[] vistied = new boolean[N];
        dfs(0, vistied);
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visit = new boolean[N];

        queue.offer(0);
        visit[0] = true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println((char)(current+65));
        
        for(Node temp = adList[current]; temp!=null ; temp =temp.link){
            if(!visit[temp.vertex]){
                queue.offer(temp.vertex);
                visit[temp.vertex] = true;
            }
        }    
            
    }
    
}
    private static void dfs(int current, boolean[] visited){
        visited[current] =true;
        System.out.println((char)(current+65));

            for(Node temp = adList[current]; temp !=null; temp = temp.link){
                if(!visited[temp.vertex]){
                    dfs(temp.vertex, visited);
                }   
            }
    }
}
