package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5평범한배낭_12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        int[][] dp = new int[count+1][weight+1];

        for(int i=1; i<=count; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            for(int j=0; j<=weight; j++){
                if(w<=j){   // 가방에 물품을 넣기 가능
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+score);

                }else{ // 불가능
                    dp[i][j] = dp[i-1][j];
                }
            }

        }
        bw.write(""+dp[count][weight]);
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/12865