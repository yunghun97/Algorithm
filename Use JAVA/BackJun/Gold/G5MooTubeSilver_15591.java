package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5MooTubeSilver_15591 {
    static int N, Q;
    static ArrayList<Node>[] list;
    static int[][] result;
    static boolean[] isVisited;
    static Queue<Video> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        result = new int[N][N];
        list = new ArrayList[N];
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[N];
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());            
            list[start].add(new Node(start, end, weight));
            list[end].add(new Node(end,start,weight));
        }
        for(int x=0; x<N; x++){
            Arrays.fill(result[x], Integer.MAX_VALUE);
        }
        q = new LinkedList<>();
        for(int i=0; i<N; i++){
            Arrays.fill(isVisited, false);
            bfs(i);
        }
        for(int i=0; i<Q; i++){
            int answer = 0;
            st = new StringTokenizer(br.readLine());
            int k =Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken())-1;
            for(int x=0; x<N; x++){
                if(result[v][x]==Integer.MAX_VALUE) continue;
                if(result[v][x]>=k) answer++;
            }
            bw.write(String.valueOf(answer)+"\n");
        }
        bw.flush();
    }
    private static void bfs(int num) {
        q.clear();
        int min = Integer.MAX_VALUE;
        q.add(new Video(num,min));
        isVisited[num] = true;
        while(!q.isEmpty()){
            Video video = q.poll();
            for(int i=0; i<list[video.nodeNum].size(); i++){
                Node node = list[video.nodeNum].get(i);     
                if(isVisited[node.end]) continue;
                isVisited[node.end] = true;      
                     
                result[num][node.end] = Math.min(node.weight, video.min);
                q.add(new Video(node.end, Math.min(node.weight, video.min)));
            }
        }
        result[num][num] = Integer.MAX_VALUE;        
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
    static class Video{
        int nodeNum;
        int min;
        public Video(int nodeNum, int min) {
            this.nodeNum = nodeNum;
            this.min = min;
        }
    }
}
// https://www.acmicpc.net/problem/15591
// ?????? ?????? ???????????? K?????? ??????
// DFS??? ?????? ???????????? ???????????? k ???????????? ??? ????????????????????? ???????????? ???????????? ??? ??????????????? ????????? ????????????.