package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S11로만들기2_12852 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Node[] arr = new Node[N+3];
        Arrays.fill(arr, new Node(Integer.MAX_VALUE, ""));
        arr[1] = new Node(0,"1"); // 처음꺼 세팅
        arr[2] = new Node(1,"2 1"); // 처음꺼 세팅
        arr[3] = new Node(1,"3 1"); // 처음꺼 세팅
        for(int i=4; i<=N; i++){
            arr[i] = new Node(arr[i-1].count+1,String.valueOf(i+" ")+arr[i-1].record); // +1 해주기
            if(i%3==0){ // 3으로 나눌 수 있는 경우
                if(arr[i].count>arr[i/3].count+1){  // /3 +1 값이 더 낮을때
                    arr[i].count = arr[i/3].count+1; // 새로 값 할당
                    arr[i].record = String.valueOf(i+" ")+arr[i/3].record; // record 새로 할당
                }                
            }
            if(i%2==0){ // 2로 나눌 수 있는 경우
                if(arr[i].count>arr[i/2].count+1){
                    arr[i].count = arr[i/2].count+1; // /2 +1 값이 더 낮을때
                    arr[i].record = String.valueOf(i+" ")+arr[i/2].record; // record 새로 할당
                }
            }
        }
        
        bw.write(""+arr[N].count); // 최소 개수 
        bw.newLine();        
        bw.write(arr[N].record);        
        bw.flush();
    }
    static class Node{
        int count;
        String record;

        public Node(int count, String record){
            this.count = count;
            this.record = record;
        }
    } 
}
// https://www.acmicpc.net/problem/12852
// 해당 코드는 비효율적 코드 -> 해당 수를 만드는데 걸리는 차수를 저장해서 해당 차수별로 1개씩만 출력하면 좋을 듯(DFS 사용?)