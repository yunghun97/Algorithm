package BackJun.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class S3n2타일링_11726 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        int answer = 0;
        if(n<=3){
            answer = arr[n];
        }else{
            for(int i=4; i<=n; i++){
                arr[i] = (arr[i-1]+arr[i-2]) % 10007;
            }
            answer = arr[n];
        }
        bw.write(""+answer);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/11726