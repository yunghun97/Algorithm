package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1퇴사2_15486 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] time = new int[N+1];
        int[] price = new int[N+1];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }   
        int max = 0;         
        for(int i=0; i<=N; i++){
            if(max<dp[i]) max = dp[i];
            int day = i+time[i];
            if(day < N+1){
                dp[day] = Math.max(dp[day], max+price[i]);
            }
        }
        bw.write(""+max);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/15486