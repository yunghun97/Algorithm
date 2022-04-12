package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5두용액_2470 {
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
        int left = 0;
        int right = arr.length-1;
        int[] answer = new int[2];
        int MAX = Integer.MAX_VALUE;
        while(true){
            if(left==right) break;
            int result = arr[left]+arr[right];
            if(Math.abs(result)<MAX){
                MAX = Math.abs(result);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if(result>0){
                right--;
            }else if(result<0){
                left++;
            }else{ // result = 0;
                break;
            }
        }
        bw.write(""+answer[0]+" "+answer[1]);
        bw.flush();        
    }
}
// https://www.acmicpc.net/problem/2470