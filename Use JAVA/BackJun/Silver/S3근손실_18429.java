package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S3근손실_18429 {
    static int N, K, answer;
    static int[] kit;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        answer = 0;        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        kit = new int[N];
        for(int i=0; i<N; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }
        isVisited = new boolean[N];
        eat(0,0,500);
        bw.write(""+answer);
        bw.flush();
    }
    private static void eat(int cnt, int eatCount, int power) {
        if(eatCount==N){
            answer++;
            return;            
        }
        for(int i=0; i<N; i++){
            if(isVisited[i]) continue;
            if(power-K+kit[i]<500) continue;
            isVisited[i] = true;
            eat(cnt+1,eatCount+1, power-K+kit[i]);
            isVisited[i] = false;
        }
    }    
}
// https://www.acmicpc.net/problem/18429