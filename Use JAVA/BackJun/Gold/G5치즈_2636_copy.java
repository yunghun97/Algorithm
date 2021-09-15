package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5치즈_2636_copy { // dfs 벽 제거 과정 X
        static int R, C, time, cheezeCount;
        static int[][] map, answerMap ;
        static boolean[][] isVisited;
        static int[] dx = {-1,0,0,1}, dy ={0,-1,1,0};
        static Queue<Node> q, q2;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        answerMap = new int[R][C];
        isVisited = new boolean[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q = new LinkedList<>();
        q2 = new LinkedList<>();
        cheezeCount = 0;
        int answer = 0;
        time = 0;
        dfs(0,0);
        while(cheezeCount!=0){
            answer = cheezeCount;
            cheezeCount = 0;
            time++;
            while(!q.isEmpty()){
                q2.add(q.poll());
            }
            while(!q2.isEmpty()){
                Node temp = q2.poll();
                dfs(temp.r,temp.c); // 기존에 벽이었던 좌표 탐색
            }
        }
        bw.write(""+time+"\n"+answer);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void dfs(int r, int c) {
        
        if(isVisited[r][c]) return;
        else if(map[r][c]==1) return;
        else{
            isVisited[r][c] = true;
            for(int d=0; d<4; d++){
                int nr = r+dx[d];
                int nc = c+dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(isVisited[nr][nc]) continue;
                if(map[nr][nc]==1){
                    map[nr][nc]=2;
                    cheezeCount++;
                    q.add(new Node(nr, nc));
                }
                if(map[nr][nc]==0) dfs(nr,nc);
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
//https://www.acmicpc.net/problem/2636