package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S2연속합_1912 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0]; // 처음 부분
        int max = dp[0];  // 맨 처음 수 최대값 설정

        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);   // 이전까지의 최대값+다음 수 or 현재 해당하는 수
            max = Math.max(dp[i], max);
        }

        bw.write(""+max);
        bw.flush();
    }    
}
// https://www.acmicpc.net/problem/1912