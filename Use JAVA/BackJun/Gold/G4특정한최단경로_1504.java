package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4특정한최단경로_1504 {
    static int N,V, des1, des2, answer;
    static int[] dis;
    static ArrayList<Node>[] list;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        dis = new int[N+1];
        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<V; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end,w));
            list[end].add(new Node(start,w));
        }
        st = new StringTokenizer(br.readLine());
        des1 = Integer.parseInt(st.nextToken());
        des2 = Integer.parseInt(st.nextToken());

        Arrays.fill(dis, Integer.MAX_VALUE);
        answer = Integer.MAX_VALUE;        
        int result = 0;
        boolean check1 = false;
        boolean check2 = false;

        move(1, des1);  // 1번 경유지 부터
        if(dis[des1]!=Integer.MAX_VALUE){
            result = dis[des1];
            move(des1, des2);
            if(dis[des2]!=Integer.MAX_VALUE){
                result+=dis[des2];
                move(des2, N);
                if(dis[N]!=Integer.MAX_VALUE){
                    check1 = true;
                    result+=dis[N];
                }
            }
        }
        
        if(check1) answer = result; // 1번 경유지 부터 출발해서 끝까지 가면
        result = 0;

        move(1,des2);   // 2번 경유지 부터
        if(dis[des2]!=Integer.MAX_VALUE){
            result = dis[des2];
            move(des2, des1);
            if(dis[des1]!=Integer.MAX_VALUE){
                result+=dis[des1];
                move(des1, N);
                if(dis[N]!=Integer.MAX_VALUE){
                    check2 = true;
                    result+=dis[N];
                }
            }
        }
        if(check2){ // 2번 경유지 부터 출발해서 끝까지 가면
            if(answer==Integer.MAX_VALUE) answer = result;  // 처음이면 answer = result
            else answer = Math.min(answer, result); // 두번째면 최소값
        }
        if(answer==Integer.MAX_VALUE) answer = -1;  // answer가 갱신되지 않음(다 갈 수 없는경우 -1)
        bw.write(""+answer);
        bw.flush();
    }
    private static void move(int start, int destination) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(start, 0));
        dis[start] = 0;
        while(!pq.isEmpty()){
            int now = pq.poll().end;
            if(now==destination) return;    // 목적지가 큐에서 꺼내짐(목적지에 도착하는 가장 짧은 경우이므로 return)
            
            for(int i=0; i<list[now].size(); i++){
                Node node = list[now].get(i);
                if(dis[node.end]>dis[now]+node.weight){
                    dis[node.end] = dis[now]+node.weight;                   
                    pq.add(new Node(node.end, dis[node.end]));
                }
            }

        }
    }
    static class Node{
        int end;
        int weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
}
//https://www.acmicpc.net/problem/1504