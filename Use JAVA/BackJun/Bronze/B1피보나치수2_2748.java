package BackJun.Bronze;
import java.io.*;
public class B1피보나치수2_2748 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        long arr[] = new long[input+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2; i<input+1; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        long answer = arr[input];
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/2748