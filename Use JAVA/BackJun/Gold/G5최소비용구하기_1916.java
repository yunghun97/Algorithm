package BackJun.Gold;
import java.io.*;
import java.util.*;
public class G5최소비용구하기_1916 {
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());
        list = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<=size; i++){
            list.add(new ArrayList<Node>());
        }
        int[] distance = new int[size+1];
        boolean[] isVisited = new boolean[size+1];
        for(int i=0; i<busCount; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(start).add(new Node(end, weight));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> 
            Integer.compare(o1.weight,o2.weight)    // 가중치 순으로 정렬
        );
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        pq.add(new Node(start, 0)); // 시작 정점 + 가중치 0 넣기
        // 다익스트라 구현
        while(!pq.isEmpty()){   // pq에서 endPoint는 시작정점을 의미한다.
            Node temp = pq.poll();
            if(isVisited[temp.endPoint]) continue;  // 시작 정점 탐색했으면 다른거 탐색

            isVisited[temp.endPoint] = true;    // 방문 표시

            for(Node nd : list.get(temp.endPoint)){ // 현재 출발 정점서 연결되어있는 모든 정점 구하기
                if(distance[nd.endPoint] > distance[temp.endPoint]+nd.weight){  // 도착정점이 현재 정점+가중치랑 비교해서 작으면 갱신 + pq에 출발정점 넣기
                    distance[nd.endPoint] = distance[temp.endPoint]+nd.weight;
                    pq.add(new Node(nd.endPoint, distance[nd.endPoint]));   // 갱신된 도착 정점 + 도착정점까지 걸린 시간 -> 시간이 작은거 순으로 pq 자동 정렬
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