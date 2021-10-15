package BackJun.Gold;

import java.io.*;
import java.util.*;


public class G4해킹_10282 {
    static int V, M, hacked;
    static ArrayList<Node>[] list;
    static int[] dis;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            hacked = Integer.parseInt(st.nextToken());
            list = new ArrayList[V+1];
            dis = new int[V+1];
            Arrays.fill(dis, Integer.MAX_VALUE);
            for(int i=0; i<=V; i++){
                list[i] = new ArrayList<>();
            }
            for(int i=0; i<M; i++){ // 2 1 5 는  1번컴퓨터가 감염되면 2번컴퓨터에 퍼지는 구조
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[b].add(new Node(a,c));
            }
            int count = 0;
            int time = 0;
            check(hacked);
            for(int i=1; i<=V; i++){    // 전체 다익스트라 탐색 후 초기값 = MAX_VALUE가 아닌것 중 가장 오랜시간걸린거, 아닌 갯수
                if(dis[i]==Integer.MAX_VALUE) continue;
                time = Math.max(dis[i],time);
                count++;
            }
            bw.write(""+count+" "+time+"\n");
            bw.flush();
        }
    }
    private static void check(int num) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[]{num,0});
        dis[num] = 0;
        while(!pq.isEmpty()){
            int start= pq.poll()[0];
            for(int i=0; i<list[start].size(); i++){
                int end = list[start].get(i).end;
                int weight = list[start].get(i).weight;
                if(dis[end]>dis[start]+weight){
                    dis[end]=dis[start]+weight;
                    pq.add(new int[]{end, dis[end]});
                }
            }

        }
        return;
    }
    static class Node{
        int end;
        int weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "Node [end=" + end + ", weight=" + weight + "]";
        }
    }
}
//https://www.acmicpc.net/problem/10282