package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G3파티_1238 {
    static ArrayList<Node>[] map;
    static int N,X,destination;
    static int[] answer,dis;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());
        answer = new int[N+1];
        dis = new int[N+1];
        map = new ArrayList[N+1];

        for(int i=0; i<=N; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<X; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            map[start].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        for(int i=1; i<=N; i++){
            if(i==destination) continue;
            answer[i]=move(i);
        }
         
        int result = 0;
        moveHome(destination);
        for(int i=1; i<=N; i++){
           result = Math.max(answer[i], result);
        }
        bw.write(""+result);
        bw.flush();
    }    

    private static void moveHome(int num) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[num] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1],o2[1]));            pq.add(new int[]{num,0});
            while(!pq.isEmpty()){
                int start = pq.poll()[0];
                for(int i=0; i<map[start].size(); i++){
                    Node node = map[start].get(i);

                    if(dis[node.end]>dis[start]+node.weight){
                        dis[node.end]=dis[start]+node.weight;
                        pq.add(new int[]{node.end,dis[node.end]});
                    }
                }
            }
        for(int i=1; i<=N; i++){
            answer[i]+=dis[i];
        }  
        return;
    }

    private static int move(int num) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[num] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1[1],o2[1]));
        pq.add(new int[]{num,0});
        while(!pq.isEmpty()){
            int start = pq.peek()[0];
            int weight = pq.poll()[1];

            if(start==destination){
                return weight;
            }
            for(int i=0; i<map[start].size(); i++){
                Node node = map[start].get(i);

                if(dis[node.end]>dis[start]+node.weight){
                    dis[node.end]=dis[start]+node.weight;
                    pq.add(new int[]{node.end,dis[node.end]});
                }
            }
        }
        return 0;
    }
    static class Node{
        int end;
        int weight;
        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
}
//https://www.acmicpc.net/problem/1238