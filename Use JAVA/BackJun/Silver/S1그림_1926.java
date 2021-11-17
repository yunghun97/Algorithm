package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1그림_1926 {
    static int[] dx ={-1,0,0,1}, dy= {0,-1,1,0};
    static int count, max,R,C, result;
    static boolean[][] map, isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        isVisited = new boolean[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1) map[i][j] = true;
            }
        }
        count = 0;
        max = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]&&!isVisited[r][c]){
                    count++;
                    result = 1;
                    dfs(r,c);
                    max = Math.max(result,max);
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.newLine();
        bw.write(String.valueOf(max));
        bw.flush();
    }
    private static void dfs(int r, int c) {
        isVisited[r][c] = true;
        for(int d=0; d<4; d++){
            int nr = r+dx[d];
            int nc = c+dy[d];
            if(nr<0||nr>=R||nc<0||nc>=C||!map[nr][nc]||isVisited[nr][nc]) continue;
            isVisited[nr][nc] = true;
            result++;
            dfs(nr,nc);
        }
    }    
}
// https://www.acmicpc.net/problem/1926