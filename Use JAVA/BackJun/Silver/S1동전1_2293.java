package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1동전1_2293 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());

        int arr[] = new int[N+1];
        int dp[] = new int[price+1];
        dp[0] = 1;

        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            for(int j=arr[i]; j<=price; j++){
                dp[j] = dp[j] + dp[j-arr[i]];
            }
        }
        bw.write(""+dp[price]);
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://www.acmicpc.net/problem/2293