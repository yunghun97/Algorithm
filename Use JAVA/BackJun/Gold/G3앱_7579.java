package BackJun.Gold;

import java.io.*;
import java.util.*;
// N개 앱  A1 A2
// A1 메모리 사용 M1 추가 비옹 C1
// B 실행 위해 M 바이트 메모리 필요
// A를 죽여서 M 바이트의 메모리 확보 -> A1의 재시작의 비용을 최소화
public class G3앱_7579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] memory, restart;

        memory = new int[N + 1];
        restart = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i + 1] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            restart[i + 1] = Integer.parseInt(st.nextToken());
        }
        int column = N * 100 + 1;
        int[][] dp = new int[N + 1][column];
        // 기본 값 초기화 해주기
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int c = 0; c < column; c++) {
                if(c>answer) break;
                if (c >= restart[i]) dp[i][c] = Math.max(dp[i-1][c], dp[i - 1][c - restart[i]] + memory[i]);
                else dp[i][c] = dp[i-1][c];

                if(dp[i][c]>=M) answer = Math.min(c,answer);
            }

        }
        bw.write(""+answer);
        bw.flush();
    }
}
//https://www.acmicpc.net/problem/7579
