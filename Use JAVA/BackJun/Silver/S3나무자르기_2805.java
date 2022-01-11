package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S3나무자르기_2805 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }

        int min = 0;
        while(min<max){
            int middle = min+(max-min)/2;
            long result = cal(middle);   // 가져가는 나무의 개수
            if(M>result){ // 가져가는 나무가 목표값 보다 적은 경우 UpperBound
                // 커팅하는 높이를 낮춰야 함
                max = middle;
            }else{  // 가져가는 나무가 더 많은 경우 -> 높이를 더 높여 본다.
                min = middle+1;
            }
        }
        bw.write(String.valueOf(min-1));
        bw.flush();
    }
    private static long cal(int num) {
        long result = 0;
        for(int i=0; i<N; i++){
            if(arr[i]>num) result = result + arr[i]-num;
        }
        return result;
    }    
}
// https://www.acmicpc.net/problem/2805