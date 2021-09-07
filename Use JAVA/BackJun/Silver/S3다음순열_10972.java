package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S3다음순열_10972 {
    static int N;
    static int[] answer, arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N]; answer = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int index1 = -1, index2 = 0;
        for(int i=N-1; i>=1; i--){
            if(arr[i]>arr[i-1]){
                index1 = i-1;
                break;
            }
        }
        if(index1==-1){
            bw.write("-1");
        }else{
            for(int i=N-1; i>=0; i--){
                if(arr[index1]<arr[i]){
                    index2=i;
                    break;
                }
            }
            int temp = arr[index1];
            arr[index1] = arr[index2];
            arr[index2] = temp;
            Arrays.sort(arr, index1+1, N);
            for(int i=0; i<N; i++){
                bw.write(""+arr[i]+" ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
