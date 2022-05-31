package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5도서관_1461 {
    static int N, M, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = 0;
        Arrays.sort(arr);
        int left = Math.abs(arr[0]);
        int right = Math.abs(arr[N]);
        int zeroIndex = findZero();        
        answer = 0;
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1)); // 절대 값이 큰거
        PriorityQueue<Integer> minPq = new PriorityQueue<>((o1,o2)->Integer.compare(o1, o2)); // 절대 값이 작은거

        if(left>right){ // left가 더 큼 left를 마지막에
            for(int i=zeroIndex+1; i<=N; i++){                
                maxPq.add(Math.abs(arr[i]));
            }
            plusMax(maxPq);
            for(int i=zeroIndex-1; i>=0; i--){
                minPq.add(Math.abs(arr[i]));
            }
            plusMin(minPq);
        }else if(left==right){
            for(int i=zeroIndex+1; i<=N; i++){                
                minPq.add(Math.abs(arr[i]));
            }
            plusMin(minPq);
            for(int i=zeroIndex-1; i>=0; i--){
                minPq.add(Math.abs(arr[i]));
            }
            plusMin(minPq);
        }
        else{ // right가 더 큼 // right를 마지막에
            for(int i=zeroIndex+1; i<=N; i++){
                minPq.add(Math.abs(arr[i]));
            }
            plusMin(minPq);
            for(int i=zeroIndex-1; i>=0; i--){
                maxPq.add(Math.abs(arr[i]));
            }
            plusMax(maxPq);
        }
        bw.write(""+answer);
        bw.flush();
    }
    // 최대값 더 해주기 다 2번씩
    private static void plusMax(PriorityQueue<Integer> maxPq) {
        while(!maxPq.isEmpty()){
            for(int i=0; i<M; i++){
                if(i==0){ // 처음에 2배로 해서 더 해주기
                    answer += maxPq.poll() *2;
                }else{
                    if(maxPq.isEmpty()) break;
                    maxPq.poll(); // 더 최대 보다 작은거는 그냥 poll();
                }
            }
        }

    }
    // 최소값 -> 마지막 pq값은 1번만 더하기
    private static void plusMin(PriorityQueue<Integer> minPq) {
        if(minPq.size()%M!=0&&minPq.size()>M){ // 깔끔하게 안 나눠 지는 경우 -> %M=0이 나머지 값 만큼은 미리 이동
            int size = minPq.size()%M;
            for(int i=0; i<size; i++){
                if(i==size-1){
                    answer+=minPq.poll()*2;
                }else{
                    minPq.poll();
                }
            }
        }
        while(!minPq.isEmpty()){
            if(minPq.size()>M){  // pq에 남은게 더 많을 경우
                for(int i=0; i<M; i++){
                    if(i!=M-1){
                        minPq.poll(); // 쓸모 없는 값 제거
                    }else{
                        answer+=minPq.poll()*2;
                    }
                }
            }else{
                int size = minPq.size();
                for(int i=0; i<size; i++){
                    if(i==size-1){ // 마지막에 도달
                        answer += minPq.poll();
                    }else{
                        minPq.poll();
                    }
                }
            }
        }
    }
    private static int findZero() {
        for(int i=0; i<=N; i++){
            if(arr[i]==0) return i;
        }
        return 0;        
    } 
}
// https://www.acmicpc.net/problem/1461