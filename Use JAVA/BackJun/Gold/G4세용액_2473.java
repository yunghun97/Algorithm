package BackJun.Gold;

import java.util.*;
import java.io.*;
public class G4세용액_2473 {
    // 10억 *3 이므로 합은 long으로 해야한다.
    // 각 원소 최대 최소 +-10억인데 int로 하면 오류 발생 -> 2,147,483,647 최대 값보다 작지만 왜??
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        long answer = Long.MAX_VALUE;
        Queue<Long> q = new LinkedList<>();        
        int start = 0;
        int mid = 0;
        int end = 0;                       
        Arrays.sort(arr);  
        for(int i=0; i<N-2; i++){
            start = i;
            mid = i+1;
            end = N-1;
            while(mid!=end){
                long sum = arr[start] + arr[mid] + arr[end];
                if(answer>Math.abs(sum)){
                    answer = Math.abs(sum);
                    q.clear();
                    q.add(arr[start]);
                    q.add(arr[mid]);
                    q.add(arr[end]);
                }
                if(sum==0){ // 끝났으니까 더 탐색 X
                    break;
                }else if(sum>0){ 
                    end--;
                }else{
                    mid++;
                }
            }
        }
        while(!q.isEmpty()){
            bw.write(""+q.poll()+" ");
        }
        bw.flush();
    }    
}
// https://www.acmicpc.net/problem/2473