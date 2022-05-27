package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5용액_2476 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = Integer.MAX_VALUE;
        int start = 0;
        int end = N-1;
        int minNumber = 0;
        int maxNumber = 0;
        while(start!=end){
            int nowSum = arr[start] + arr[end];
            if((int)Math.abs(nowSum)<sum){
                sum = (int)Math.abs(nowSum);
                minNumber = arr[start];
                maxNumber = arr[end];                
            }
            if(nowSum<0){
                start++;
            }else if(nowSum==0){
                break;
            }else{
                end--;
            }
        }
        bw.write(String.valueOf(minNumber)+" "+String.valueOf(maxNumber));
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2467