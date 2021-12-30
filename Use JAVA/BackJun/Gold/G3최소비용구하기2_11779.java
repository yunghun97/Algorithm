package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G3최소비용구하기2_11779 {
    static ArrayList<Node>[] list;
    static int[] dist;
    static String[] answer;
    static boolean[] isVisited;
    static int N,M, START,END;
    static PriorityQueue<City> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine())+1;
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[N];
        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.weight, o2.weight));
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(start, end, weight));  // 버스 정보 저장하기
        }
        st = new StringTokenizer(br.readLine());
        START = Integer.parseInt(st.nextToken());
        END = Integer.parseInt(st.nextToken());
        dist[START] = 0;
        pq.add(new City(String.valueOf(START),START,0));    // 처음 시작좌표

        dijkstra();
        
        bw.write(String.valueOf(dist[END])+"\n"+answer.length+"\n");    // 출력
        for(int i=0; i<answer.length; i++){
            bw.write(answer[i]+" ");
        }
        bw.flush();
    }
    private static void dijkstra() {    // 다익스트라 실시
        while(!pq.isEmpty()){            
            City city = pq.poll();
            if(isVisited[city.start]) continue;
            isVisited[city.start]=true;            
            if(city.start==END){    // 시작 도시가 도착 도시인 경우 -> 우선순위 큐 이므로 가장 최소값이 된다.
                answer = city.order.split(" ");
                return;     // 목적지 도착
            }
            for(int i=0; i<list[city.start].size(); i++){   // 버스 노선만큼 탐색
                Node node = list[city.start].get(i);            
                if(dist[node.end]>dist[city.start]+node.weight){    // 거리가 더 먼 경우에만 거리 정보 최신화 및 String으로 탐색한 노드 추가해주기
                    String tmpOrder = city.order;
                    dist[node.end] = dist[city.start]+node.weight;
                    tmpOrder +=" "+String.valueOf(node.end);
                    pq.add(new City(tmpOrder, node.end, dist[node.end]));
                }
            }            
        }
    }
    static class Node{
        int start;
        int end;
        int weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    static class City{
        String order;
        int start;
        int weight;        
        public City(String order, int start, int weight) {
            this.order = order;
            this.start = start;
            this.weight = weight;
        }
        
    }   
}
//https://www.acmicpc.net/problem/11779