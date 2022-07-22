package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5Coins_3067 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] coinArr = new int[N];
            for(int i=0; i<N; i++){
                coinArr[i] = Integer.parseInt(st.nextToken());
            }
            int money = Integer.parseInt(br.readLine());
            int[] dp = new int[money+1];
            dp[0] = 1;

            for(int coin : coinArr){
                for(int j=coin; j<=money; j++){
                    dp[j] += dp[j-coin];
                }
            }
            bw.write(""+dp[money]);
            bw.newLine();
        } // 테케 끝
        bw.flush();
    }    
}
// https://www.acmicpc.net/problem/3067