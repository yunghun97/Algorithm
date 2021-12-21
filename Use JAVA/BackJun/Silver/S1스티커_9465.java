package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1스티커_9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N+1];
            int[][] result = new int[2][N+1];
            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            result[0][1] = arr[0][1];
            result[1][1] = arr[1][1];
            for(int x=2; x<=N; x++){
                result[0][x] = Math.max(result[1][x-1], result[1][x-2]) + arr[0][x];
                result[1][x] = Math.max(result[0][x-1], result[0][x-2]) + arr[1][x];
            }
            bw.write(""+Math.max(result[0][N], result[1][N])+"\n");
        }
        bw.flush();
        
    }
}
//https://www.acmicpc.net/problem/9465