package BackJun.Silver;

import java.util.*;
import java.io.*;
public class S1동전2_2294 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int[] coin = new int[n];
        for(int i=0; i<n; i++){
            coin[i]=sc.nextInt();
        }
        int[] dp = new int[k+1];
        Arrays.fill(dp, 100001);
        dp[0]=0;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=k; j++){
                dp[j] = Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }
        System.out.println(dp[k]==100001 ? -1 : dp[k]);
        sc.close();
    }
}
//https://www.acmicpc.net/problem/2294