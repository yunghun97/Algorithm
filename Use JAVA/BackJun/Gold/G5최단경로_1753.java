package BackJun.Gold;
import java.io.*;
import java.util.*;
public class G5최단경로_1753 {
    public static void main(String[] args) throws IOException{
        ArrayList<Node>[] list ;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken())+1;
        int N = Integer.parseInt(st.nextToken());
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];
        int start = Integer.parseInt(br.readLine());
        list = new ArrayList[V+1];
        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
        }
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선 순위 큐로하면 더 빨리 가능
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(visited[temp.endNode]) continue;

            visited[temp.endNode] = true;
            for(Node nd : list[temp.endNode]){
                if(distance[nd.endNode] > distance[temp.endNode]+nd.weight){
                    distance[nd.endNode] = distance[temp.endNode]+nd.weight;
                    pq.add(new Node(nd.endNode, distance[nd.endNode]));
                }
            }
        }

        for(int i=1; i<V; i++){
            if(distance[i]!=Integer.MAX_VALUE){
                bw.write(distance[i]+"\n");
            }else{
                bw.write("INF\n");
            }
        }
        bw.flush();
    }
    static class Node implements Comparable<Node>{
        int endNode;
        int weight;
        public Node(int endNode, int weight) {
            this.endNode = endNode;
            this.weight = weight;
        }
        public int compareTo(Node o){
            return Integer.compare(this.weight, o.weight);
        }
    }
}
//https://www.acmicpc.net/problem/1753