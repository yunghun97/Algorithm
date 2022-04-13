package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4트리의지름_1967 {
    static int N, max, maxIdx;
    static ArrayList<Node>[] list;
    static boolean[] isVisited;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        max = 0;
        maxIdx = 0;
        q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, time));
            list[end].add(new Node(start,time));
        }
        if(N==1){
            bw.write(""+0);
        }else{
            Arrays.fill(isVisited, false);
            isVisited[1] = true;
            dfs(1,0);
    
            Arrays.fill(isVisited, false);
            isVisited[maxIdx] = true;
            dfs(maxIdx,0);
            bw.write(""+max);
        }
        bw.flush();
    }
    private static void dfs(int cnt, int cost) {
        if(max<cost){
            max = cost;
            maxIdx = cnt;
        }
        for(Node node : list[cnt]){
            if(isVisited[node.end]) continue;
            isVisited[node.end] = true;
            dfs(node.end, node.time+cost);
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
// https://www.acmicpc.net/problem/1967