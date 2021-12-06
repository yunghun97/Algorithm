package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;

public class 동철이의일분배_1865 {
    static double[][] table;
    static double[] jobArr;
    static boolean[] isVisited;
    static int N;
    static double answer;
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            table = new double[N][N];
            jobArr = new double[N];
            isVisited = new boolean[N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){                    
                    table[i][j] = Double.parseDouble(st.nextToken());
                }
            }

            answer = 0;
            permutation(0,1);            
            bw.write("#"+t+" "+String.format("%.6f",answer*100)+"\n");  // 소숫점 6번째 자리까지이므로 %.6f 해준다. Math.round는 소수점아래 0을 모두 지우므로 불가능
            bw.flush();
        }
    }
    // 순열 계산
    private static void permutation(int cnt, double result) {
        if(result<=answer){ //answer보다 작거나 같으면 더 계산할 필요 없으므로 return
            return;
        }
        if(cnt==N){ // 마지막일까지 모두 고려됐으므로 answer에 result를 할당해준다.
            answer = result;
            return;
        }
        for(int i=0; i<N; i++){
            if(isVisited[i]) continue;  // 이미 방문해서 계산된 일이면 continue
            isVisited[i] = true;
            double tmp = result;           
            tmp *= (table[cnt][i]/100); // tmp를 통해 계산해서 매개변수로 넘겨준다.
            permutation(cnt+1, tmp);
            isVisited[i] = false;
        }
    }    
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LuHfqDz8DFAXc