package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4서강그라운드_14938 {
    static int N, M, R;
    static int[] dir, items;
    static ArrayList<Node>[] list;
    static int MAX;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        dir = new int[N];
        items = new int[N];
        st = new StringTokenizer(br.readLine());
        list = new ArrayList[N];        
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
            items[i] = Integer.parseInt(st.nextToken());
        }
        MAX = Integer.MIN_VALUE;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int time = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, time));
            list[end].add(new Node(start,time));
        }
        for(int i=0; i<N; i++){
            Arrays.fill(dir, 9999999);
            dir[i] = 0;
            dijkstra(i);
            int tmpMax = sum();
            MAX = Math.max(MAX, tmpMax);
        }
        bw.write(""+MAX);
        bw.flush();
    }
    private static int sum() {
        int result = 0;
        for(int i=0; i<N; i++){
            if(dir[i]<=M)  result+=items[i];
        }
        return result;
    }
    private static void dijkstra(int num) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.time, o2.time));
        pq.add(new Node(num,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(int i=0; i<list[node.end].size(); i++){
                Node dirNode = list[node.end].get(i);
                if(dir[dirNode.end]>dir[node.end]+dirNode.time){
                    if(dir[node.end]+dirNode.time>M) continue;
                    else{
                        dir[dirNode.end] = dir[node.end]+dirNode.time;
                        pq.add(new Node(dirNode.end,dir[dirNode.end]));
                    }
                }
            }
        }
    }
    static class Node{
        int end;
        int time;
        public Node(int end, int time){
            this.end = end;
            this.time = time;
        }
    }
}
// https://www.acmicpc.net/problem/14938