package BackJun.Bronze;

import java.io.*;
import java.util.*;
public class B2블랙잭_2798 {
    static int N, SUM,answer;
    static int[] input;
    static boolean finish;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        SUM = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        answer =0; finish = false;
        combi(0,0,0);
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void combi(int cnt, int start, int sum) {
        
        if(cnt==3){
            if(sum>SUM) return;
            answer = Math.max(answer,sum);
            return;
        }
        for(int i=start; i<N; i++){
            combi(cnt+1,i+1, sum+input[i]);
        }
    }
}
//https://www.acmicpc.net/problem/2798
/**
 * 입력
10 500
93 181 245 214 315 36 185 138 216 295
결과 -> 497
 */