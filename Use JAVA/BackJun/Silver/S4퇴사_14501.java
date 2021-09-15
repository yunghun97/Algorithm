package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S4퇴사_14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int[] day = new int[size+2];    // 트래쉬값 1개 추가
        int[] score = new int[size+2];
        int[] dp = new int[size+2]; // size+1 까지 정답이므로
        int max =0;
        for(int i=1; i<=size; i++){  
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            score[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<=size+1; i++){
            dp[i] = Math.max(dp[i],max);    // 현재 좌표랑 좌표 오기전까지의 MAX 값 비교
            if(i+day[i]<=size+1){
                dp[day[i]+i] = Math.max(dp[day[i]+i],score[i]+dp[i]);   // 상담 후 금액 = Max(상담 안 했지만 상담 했을 때 위치하는 금액 vs 내가 상담한 금액(현재 금액+상담 금))
            }
            max = Math.max(max,dp[i]);  // 현재 일에서 최대 값 저장
        }
        bw.write(""+max);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/14501