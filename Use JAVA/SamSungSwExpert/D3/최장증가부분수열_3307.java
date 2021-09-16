package SamSungSwExpert.D3;

import java.io.*;
import java.util.*;
public class 최장증가부분수열_3307 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] LIS = new int[size];
            int[] arr = new int[size];
            while(st.hasMoreTokens()){
                for(int i=0; i<size; i++){
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for(int i=0; i<size; i++){
                LIS[i] = 1;
                for(int j=0; j<i; j++){
                    if(arr[i]>arr[j]&&LIS[j]+1>LIS[i]){
                        LIS[i] = LIS[j]+1;
                    }
                }
                max = Math.max(LIS[i],max);
            }
            bw.write("#"+t+" "+max+"\n");
            bw.flush();
        }// 테케 끝
        bw.close();
        br.close();
    }
}
