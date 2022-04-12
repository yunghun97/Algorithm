package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5택배배송_5972 {
    static int N;
    static int[] dir;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken())-1;
        int M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        dir = new int[N+1];
        for(int i=0; i<N+1; i++) list[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int time = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,time));
            list[end].add(new Node(start,time));
        }
        Arrays.fill(dir, Integer.MAX_VALUE);
        dir[0] = 0;
        int sum = dijkstra(0);
        bw.write(""+sum);
        bw.flush();
    }
    private static int dijkstra(int cnt) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.time, o2.time));
        pq.add(new Node(cnt,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.end==N){
                return dir[N];
            }
            for(int i=0; i<list[node.end].size(); i++){
                Node dirNode = list[node.end].get(i);
                if(dir[dirNode.end]>dir[node.end]+dirNode.time){
                    dir[dirNode.end] =dir[node.end]+dirNode.time;
                    pq.add(new Node(dirNode.end, dir[dirNode.end]));
                }
            }
        }
        return 0;
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
// https://www.acmicpc.net/problem/5972