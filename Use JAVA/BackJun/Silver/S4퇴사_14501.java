package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S4퇴사_14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int[] day = new int[size+1];
        int[] score = new int[size+1];
        for(int i=1; i<=size; i++){  
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(score));
        // System.out.println(Arrays.toString(day));
        int[][] dp = new int[size+1][size+1];

        for(int i=1; i<=size; i++){
            for(int j=1; j<=size; j++){
                if(day[i]+i-1<=j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-day[i]]+score[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            System.out.println(Arrays.deepToString(dp));
        }
        
        int answer = dp[size][size];
        bw.write(""+answer);
        bw.flush();
    }
}
