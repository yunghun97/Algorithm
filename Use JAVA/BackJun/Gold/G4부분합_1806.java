package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4부분합_1806 {
    static int N, S, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N]; 
        answer = Integer.MAX_VALUE;       
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int end = 0;
        for(int start=0; start<N; start++){
            while(sum<S&&end<N){ // 돌 수 있을때 까지
                sum+=arr[end];
                end++;
            }
            if(sum>=S){ // 문제가 이상이 되는 것
                answer = Math.min(answer, end-start); // 여기로 나왔을 때는 end는 현재 수열의 마지막 다음 좌표를 가르키고 있으므로 +1 안해도 됨.
            }
            sum-=arr[start];
        }
        if(answer!=Integer.MAX_VALUE){
            bw.write(""+answer);
        }else bw.write("0");        
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/1806