package BackJun.Bronze;

import java.io.*;
import java.util.*;
public class B1이항계수1_11050 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int[][] dp = new int[11][11];
        dp[0][0]=1;
        for(int i=1;i<11; i++){
            dp[i][0] = 1;
            dp[i][i] = 1;
            for(int j=1; j<i; j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
            }
        }
        bw.write(""+dp[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
        bw.flush();
        bw.close();
        br.close();
    }  
}
/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1



*/


//https://www.acmicpc.net/problem/11050