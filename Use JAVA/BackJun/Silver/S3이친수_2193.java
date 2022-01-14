package BackJun.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S3이친수_2193 {
    /*
    1자리 수 일때는 1 만 올 수 있다. (1개)
    2자리 수 일때는 10 만 올 수 있다. (1개)
    3자리 수 일때는 101, 100 이 올 수 있다. (2개)
    4자리 수 일때는 1010, 1000, 1001 이 올 수 있다. (3개)
    5자리 수 일때는 10100, 10101, 10000, 10001, 10010 이 올 수 있다. (5개)
    6자리 수 일때는 101000, 101001, 101010, 100000, 100001, 100010, 100100, 100101 이 올 수 있다. (8개)     
    1,2,3,5,8 -> 피보나치 수
     */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long dp[] = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        bw.write(""+dp[N]);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2193
