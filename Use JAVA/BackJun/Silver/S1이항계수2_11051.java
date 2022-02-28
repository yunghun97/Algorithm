package BackJun.Silver;

import java.io.*;
import java.util.StringTokenizer;
public class S1이항계수2_11051 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] dp = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=i; j++){
                if(j==0||j==i) dp[i][j] = 1;
                else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;

            }
        }
        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
    }

}
// https://www.acmicpc.net/problem/11051