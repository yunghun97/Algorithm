package SSFAlgorithmLearn.Day11;

import java.util.Scanner;

public class DP_KnapsackTest1Arr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W  =sc.nextInt();
    
        int[] weights = new int[N+1];
        int[] profits = new int[N+1];   

        for(int i=0; i<N; i++){
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }
        
        int[] dp = new int[W+1];

        for(int i=1; i<N; i++){
            for(int w= W ; w>=weights[i]; w--){
                dp[w] = Math.max(dp[w], dp[w-weights[i]]+profits[i]);
            }
        }
        System.out.println(dp[N]);
        sc.close();
        
    }
}
/*
4
10
5 10
4 40
6 30
3 50

*/

