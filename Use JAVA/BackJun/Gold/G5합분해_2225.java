package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5합분해_2225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long MOD = 1000000000;
        int result = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        long[][] dp = new long[201][201];
        
        for(int i=1; i<=count; i++){
            dp[i][0] = 1;   // N개로 0을 만드는 횟수 = 모두 0 일때이므로 0으로 초기화 시켜준다.
        }
        for(int i=1; i<=count; i++){    // i = 사용 횟수
            for(int j=1; j<=result; j++){   // j는 목표값
                dp[i][j] = (dp[i][j-1]+dp[i-1][j])%MOD; // 사용횟수-1에서 자신까지의 목표값(토큰 1개를쓰고 만들 수 있는 경우 의 수) + 사용횟수가 같고 자기보다 작은 목표값 +
            }
        }
        bw.write(""+dp[count][result]);
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/2225