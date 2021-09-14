package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1RGB거리_1149 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());

        int[][] dp = new int[size+1][3];    // dp 저장용
        for(int i=1; i<=size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=2; j++){
                if(j==0){
                    dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2]) + Integer.parseInt(st.nextToken());    // 색깔 1
                }else if(j==1){
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][2]) + Integer.parseInt(st.nextToken());    // 색깔 2
                }else{
                    dp[i][j] = Math.min(dp[i-1][0], dp[i-1][1]) + Integer.parseInt(st.nextToken());    // 색깔 3
                }
            }
        }
        bw.write(""+Math.min(Math.min(dp[size][0],dp[size][1]),dp[size][2])); // 마지막 색깔 1,2,3 중에서 가장 최솟값
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/1149