package BackJun.Silver;

import java.io.*;
public class S1극장좌석_2302 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[41];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        int M = Integer.parseInt(br.readLine());
        for(int i=3; i<=N; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        int answer = 1;
        int start = 0;
        int vip = 0;
        for(int i=0; i<M; i++){
            vip = Integer.parseInt(br.readLine());
            answer *= arr[vip-start-1];
            start = vip;
        }
        answer *= arr[N-vip];

        bw.write(""+answer);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2302
