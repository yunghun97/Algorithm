package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4LCS2_9252 {
    private static String a, b;
    private static int N, M;
    private static int[][] dp;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = br.readLine();
        b = br.readLine();
        N = a.length();
        M = b.length();
        dp = new int[N + 1][M + 1];

        int answer = LCS();
        bw.write("" + answer + "\n");
        getWord();
        bw.flush();
    }

    private static int LCS() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[N][M];
    }

    private static void getWord() throws IOException {
        Stack<Character> stack = new Stack<>(); // 역순으로 탐색하므로
        int n = N;
        int m = M;
        while (n != 0 && m != 0) {
            if (dp[n][m] == dp[n - 1][m]) {
                n--;
            } else if (dp[n][m] == dp[n][m - 1]) {
                m--;
            } else {
                stack.push(a.charAt(n - 1));                
                n--;
                m--;
            }
        }
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }
}
// https://www.acmicpc.net/problem/9252
// 참고 자료
// https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence
// https://loosie.tistory.com/183