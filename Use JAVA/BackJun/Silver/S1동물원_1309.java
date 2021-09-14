package BackJun.Silver;

import java.io.*;
public class S1동물원_1309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int MOD = 9901;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 1;
        arr[1] = 3;
        for(int i=2; i<=N; i++){
            arr[i] = (arr[i-1]*2 + arr[i-2])%MOD;
        }
        System.out.println(arr[N]);
    }
}
//https://www.acmicpc.net/problem/1309