package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5벼락치기_14728 {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;
       st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int time = Integer.parseInt(st.nextToken());
      
       Study[] arr = new Study[N+1];
       int[][] dp = new int[N+1][time+1];
       for(int i=1; i<=N; i++){
           st = new StringTokenizer(br.readLine());
           arr[i] = new Study(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));        
       }
       for(int i=1; i<=N; i++){
            for(int j=0; j<=time; j++){
                int nowTime = arr[i].time;
                int score = arr[i].score;
                if(j>=nowTime){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nowTime]+score);
                }else{
                    dp[i][j] = dp[i-1][j];
                }          
            }
       }
       bw.write(""+dp[N][time]);
       bw.flush();
    }

    static class Study {
        int time;
        int score;

        public Study(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
}
// https://www.acmicpc.net/problem/14728