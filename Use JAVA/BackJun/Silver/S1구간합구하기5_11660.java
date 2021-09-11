package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1구간합구하기5_11660 {    // DP 배우면 풀 것
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken())-1;
            int a2 = Integer.parseInt(st.nextToken())-1;
            int b1 = Integer.parseInt(st.nextToken())-1;
            int b2 = Integer.parseInt(st.nextToken())-1;
            int answer =0;
            for(int x=a1; x<=b1; x++){
                for(int y=a2; y<=b2; y++){
                    answer+=arr[x][y];
                }
            }
            bw.write(""+answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/11660