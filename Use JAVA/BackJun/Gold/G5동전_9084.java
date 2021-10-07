package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5동전_9084 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int price = Integer.parseInt(br.readLine());
            int[] dp = new int[price+1];
            dp[0] = 1;  // 초기값 0 
            for(int i=0; i<N; i++){
                for(int w=arr[i]; w<=price; w++){
                        dp[w] += dp[w-arr[i]];  // 현재 동전을 사용한다 가정한 이전 좌표에서 현재 좌표를 가능하게 하는 것이므로 기존 경우의수 + 현재 동전을 사용하기 전의 경우 의수
                }
            }
            bw.write(""+dp[price]+"\n");
        }// 테케끝
        bw.flush();
    }    
}
//https://www.acmicpc.net/problem/9084