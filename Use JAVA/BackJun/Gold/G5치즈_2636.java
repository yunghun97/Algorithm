package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5치즈_2636 {
        static int R, C, time, cheezeCount;
        static int[][] map, answerMap ;
        static boolean[][] isVisited;
        static int[] dx = {-1,0,0,1}, dy ={0,-1,1,0};
        static Queue<Node> q;
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
        cheezeCount = 0;
        int answer = 0;
        time = 0;
        dfs(0,0);
        while(cheezeCount!=0){
            removeWall();
            answer = cheezeCount;
            cheezeCount = 0;
            time++;
            while(!q.isEmpty()){
                Node temp = q.poll();
                dfs(temp.r,temp.c); // 기존에 벽이었던 좌표 탐색
            }
        }
        bw.write(""+time+"\n"+answer);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void removeWall() {  // 벽 제거
        mapCopy(); //맵 복사(필요 없는 과정) 치즈 제거 확인용
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]==2){
                    map[r][c]=0;
                    q.add(new Node(r,c));   // 기존 벽이었던 좌표 큐에 넣기
                }
            }
        }
    }
    private static void mapCopy() { // 맵 복사(필요 없는 과정) 치즈 제거 확인용
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                answerMap[i][j] = map[i][j];
            }
        }
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