package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1구간합구하기5_11660 {    // 열 마다가 아니라 총 합을 구하면 개선 가능할 듯
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                if(j>=1) arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j-1];    // 첫 번째가 아니면 그전 값과 현재 값 + 배열에 저장
                else arr[i][j] = Integer.parseInt(st.nextToken());  // 첫번째이면 그냥 바로 그 값 저장
            }
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken())-1;
            int a2 = Integer.parseInt(st.nextToken())-1;
            int b1 = Integer.parseInt(st.nextToken())-1;
            int b2 = Integer.parseInt(st.nextToken())-1;
            int answer =0;
            for(int x=a1; x<=b1; x++){
                if(a2==0){  
                    answer += arr[x][b2];
                }else{
                    answer += arr[x][b2] - arr[x][a2-1];
                }
            }
            bw.write(""+answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/11660