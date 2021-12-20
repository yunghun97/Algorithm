package BackJun.Silver;

import java.io.*;
public class S32N타일링2_11727 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        bw.write(""+dp[N]);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/11727