package BackJun.Gold;

import java.io.*;
import java.util.*;
// 누적합을 사용해서 푼다.
// 1+2+3 = 6,  6+7 = 13 -> 다음 원소 누적합 +1이면 해당 누적합까지는 만들 수 있다.
// 1+3 = 4 -> answer : 2 다음 원소가 누적합 +1 보다 크면 누적합 +1을 만들지 못한다.
public class G3저울_2437 {
    static HashMap<Long, Boolean> hmap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        hmap = new HashMap<>();
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long sum = 0;
        long answer = 0;
        for(int i=-1; i<N-1; i++){            
            if(arr[i+1]>sum+1){
                answer = sum+1;
                break;
            }else{
                sum+=arr[i+1];
            }
        }
        if(answer==0){
            bw.write(""+(sum+1));
        }else{
            bw.write(""+answer);
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2437