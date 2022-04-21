package BackJun.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S2주식_11501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long profit = 0;
            int MAX = arr[N-1];
            for(int i=N-1; i>=0; i--){
                if(arr[i]<MAX){
                    profit+=MAX-arr[i];
                }else{
                    MAX = arr[i];
                }
            }
            bw.write(""+profit);
            if(t!=N-1) bw.newLine();
        } // 테케 끝
        bw.flush();
    }
} 
// https://www.acmicpc.net/problem/11501