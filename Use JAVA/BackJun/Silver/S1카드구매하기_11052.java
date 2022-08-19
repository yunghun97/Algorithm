package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1카드구매하기_11052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }        
        for(int i=2; i<=N; i++){
            for(int j=1; j<=i/2; j++){
                dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
            }
        }
        bw.write(""+dp[N]);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/11052