package EtcProblem;

import java.io.*;

public class 막대색칠하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N+1];
        arr[1] = 2;
        arr[2] = 5;
        for(int i=3; i<=N; i++){
            arr[i] = arr[i-1]*2 + arr[i-2];
        }
        System.out.println(arr[N]);
    }
}
