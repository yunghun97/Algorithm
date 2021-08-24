package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S5색종이2_2567 {       // 너비가 아니라 테두리라서 사방탐색 실시
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static int answer;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        map = new boolean[101][101];
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = a+10;
            int c = 100-Integer.parseInt(st.nextToken()); int d = c-10;

            for(int i=a; i<b; i++){
                for(int j=c; j>d; j--){
                    map[i][j]=true;
                }
            }
        }
        answer=0;
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                if(map[i][j]) find(i, j);
            }
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void find(int r, int c) {
        for(int d=0; d<4; d++){
            int nr = r+dx[d];
            int nc = c+dy[d];
            if(!map[nr][nc]) answer++;
        }
    }
}
//https://www.acmicpc.net/problem/2567
/*
4
3 7
5 2
15 7
13 14

결과 -> 96

*/
