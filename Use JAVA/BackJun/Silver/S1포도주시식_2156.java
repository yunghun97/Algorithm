package BackJun.Silver;

import java.io.*;
public class S1포도주시식_2156 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 처음 dp값 제일 처음 잔으로 세팅
        if(N>=1){
            dp[0] = arr[0];
        }
        // 두번쨰 dp 값 가장 크게 만들기 위해 처음잔+두번째 잔
        if(N>=2){
            dp[1] = arr[0]+arr[1];
        }
        if(N>=3){
            dp[2] = Math.max(dp[1],Math.max(arr[0]+arr[2],arr[1]+arr[2]));
        }
        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        bw.write(""+dp[N-1]);
        bw.flush();
    }
}
//https://www.acmicpc.net/problem/2156
