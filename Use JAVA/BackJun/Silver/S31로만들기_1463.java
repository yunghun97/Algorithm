package BackJun.Silver;

import java.io.*;

public class S31로만들기_1463 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int result = Integer.parseInt(br.readLine());

        int[] arr = new int[result+1];
        arr[1] = 0;
        if(result>=2){
            arr[2] = 1;
        }
        if(result>=3){
            arr[3] = 1;
        }
        
        for(int i=4; i<=result; i++){
            arr[i] = arr[i-1]+1;
            if(i%3==0) arr[i] = Math.min(arr[i],arr[i/3]+1);
            if(i%2==0) arr[i] = Math.min(arr[i],arr[i/2]+1);
        }
        bw.write(""+arr[result]);
        bw.flush();
        br.close();
        bw.close();
    }
}
//https://www.acmicpc.net/problem/1463