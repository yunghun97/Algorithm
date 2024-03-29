package BackJun.Silver;

import java.io.*;

public class S1오르막수_11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];

        for(int i=0; i<10; i++){
            dp[0][i] = 1;            
        }

        for(int i = 1; i <= N; i++){
            for(int j=0; j<10; j++){
                for(int k = j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        bw.write(""+dp[N][0]);
        bw.flush();
    }    
}
// https://www.acmicpc.net/problem/11057