package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1유기농배추_1012 {
    static boolean[][] map;
    static boolean[][] isVisited;
    static int R,C, count,answer;
    static ArrayList<Node> list;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
            answer = 0;
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            count = Integer.parseInt(st.nextToken());
            map = new boolean[R][C];
            isVisited = new boolean[R][C];
            for(int i=0; i<count; i++){
                st = new StringTokenizer(br.readLine());
                int b = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                map[a][b] = true;
                list.add(new Node(a,b));
            }
            for(int i=0; i<count; i++){
                Node node = list.get(i);
                if(!isVisited[node.r][node.c]){ // 방문하지 않은 dfs 탐색할 때 마다 +1
                    dfs(node.r, node.c);
                    answer++;
                }
            }
            bw.write(""+answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int r, int c) {
        if(isVisited[r][c]) return;

        isVisited[r][c] = true;
        for(int d=0; d<4; d++){
            int nr = r+dx[d];
            int nc = c+dy[d];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(isVisited[nr][nc]) continue;

            if(map[nr][nc]){
                if(!isVisited[nr][nc]){
                    dfs(nr,nc);
                }
            }
        }
    }
    
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
//https://www.acmicpc.net/problem/1012