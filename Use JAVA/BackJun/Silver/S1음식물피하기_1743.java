package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1음식물피하기_1743 {
    static boolean[][] map, isVisited;
    static int R,C,M, answer, result;
    static int[] dx= {-1,0,0,1}, dy ={0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        isVisited = new boolean[R][C];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r-1][c-1] = true;
        }
        answer = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]&&!isVisited[r][c]){
                    result = 1;
                    isVisited[r][c] = true;
                    dfs(r,c);
                    answer = Math.max(answer,result);
                }
            }
        }
        bw.write(""+answer);
        bw.flush();
    }
    private static void dfs(int r, int c) {
        for(int d=0; d<4; d++){
            int nr = r+dx[d];
            int nc = c+dy[d];
            if(nr<0||nr>=R||nc<0||nc>=C||!map[nr][nc]||isVisited[nr][nc]) continue;
            else{
                isVisited[nr][nc] = true;
                result++;
                dfs(nr,nc);
            }
        }
    }
}
//https://www.acmicpc.net/problem/1743