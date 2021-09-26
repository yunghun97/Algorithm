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
        int w =0;
        int score = 0;
        int[] dp = new int[weight+1];
        for(int i=0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            score= Integer.parseInt(st.nextToken());

            for(int j=weight; j>=1; j--){
                if(j>=w) dp[j] = Math.max(dp[j],dp[j-w]+score);
                else continue;
            }
        }

    
        bw.write(""+dp[weight]);
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://www.acmicpc.net/problem/12865