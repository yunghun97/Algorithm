package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4말이되고픈원숭이_1600 {
    static int limit, R, C, answer;
    static int[][] map, limitMap;
    static boolean[][][] isVisited;
    static int[] nx = {-1,-2,-2,-1,1,2,2,1}, ny ={-2,-1,1,2,-2,-1,1,2}, dx ={-1,0,0,1}, dy = {0,-1,1,0};
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        limit = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isVisited = new boolean[limit+1][R][C]; // 3차원 배열 (말 처럼 이동했는지)

        
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
        br.close();
        bw.close();
    }
    private static void bfs() throws IOException{
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,0,0));
        isVisited[0][0][0] = true;

        while(!q.isEmpty()){
            Point point = q.poll();

            if(point.r==R-1 && point.c == C-1){
                bw.write(""+point.cnt);
                return;
            }

            for(int d=0; d<4; d++){ // 원숭 그냥 이동
                int nr = point.r + dx[d];
                int nc = point.c + dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(map[nr][nc]==1) continue;
                if(isVisited[point.k][nr][nc]) continue;
                isVisited[point.k][nr][nc] = true;
                q.add(new Point(nr,nc,point.k,point.cnt+1));
            }
            if(point.k<limit){
            for(int d=0; d<8; d++){ // 말 처럼 이동
                int nr = point.r + nx[d];
                int nc = point.c + ny[d];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(map[nr][nc]==1) continue;
                if(isVisited[point.k+1][nr][nc]) continue;
                isVisited[point.k+1][nr][nc] = true;
                q.add(new Point(nr,nc,point.k+1,point.cnt+1));
                }
            }
        }
        bw.write(""+-1);
        bw.flush();
    }
    static class Point{
        int r,c, k, cnt;

        public Point(int r, int c, int k, int cnt) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.cnt = cnt;
        }
        
    }
}
//https://www.acmicpc.net/problem/1600
