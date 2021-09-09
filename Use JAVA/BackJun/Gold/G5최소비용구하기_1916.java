package BackJun.Gold;
import java.io.*;
import java.util.*;
public class G5최소비용구하기_1916 {
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());
        list = new ArrayList[size+1];
        for(int i=0; i<=size; i++){
            list[i] = new ArrayList<>();
        }
        int[] distance = new int[size+1];
        boolean[] isVisited = new boolean[size+1];
        for(int i=0; i<busCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> 
            Integer.compare(o1.weight,o2.weight)
        );
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Node(start, 0));
        // 다익스트라 구현
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(isVisited[temp.endPoint]) continue;

            isVisited[temp.endPoint] = true;

            for(Node nd : list[temp.endPoint]){
                if(distance[nd.endPoint] > distance[temp.endPoint]+nd.weight){
                    distance[nd.endPoint] = distance[temp.endPoint]+nd.weight;
                    pq.add(new Node(nd.endPoint, distance[nd.endPoint]));
                }
            }
        }
        bw.write(""+distance[end]);
        bw.flush();
        br.close();
        bw.close();
        
    }
    static class Node{
        int endPoint;
        int weight;
        public Node(int endPoint, int weight) {
            this.endPoint = endPoint;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "Node [endPoint=" + endPoint + ", weight=" + weight + "]";
        }
        
    }
}

//https://www.acmicpc.net/problem/1916