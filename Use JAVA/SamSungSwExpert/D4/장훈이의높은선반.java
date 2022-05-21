package SamSungSwExpert.D4;

import java.util.*;
import java.io.*;
public class 장훈이의높은선반 {
    static int N, B,answer;
    static int[] arr, sumArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());        
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            sumArr = new int[N];
            st =new StringTokenizer(br.readLine());
            answer = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());                
            }                   
            for(int i=0; i<N; i++){
                for(int j=i; j<N; j++){
                    sumArr[i] +=arr[j];
                }
            }     
            bubun(0,0,0);
            answer-=B;
            bw.write("#"+t+" "+answer+"\n");
        }  // 테케 끝
        bw.flush();
    }
    private static void bubun(int cnt, int start, int sum){ // 부분집합 느낌의 DFS 부분집합처럼 O,X 처럼 분리된 값이 아닌 합만 가져가면 되므로 아래에 bubun()메소드 1개 더 호출안해도 된다. -> 호출 시 시간초과
        if(sum>=B) {
            answer = Math.min(answer,sum); 
            return;
        }
        if(cnt==N||sum>=answer||sum+sumArr[cnt]<B) return; // 백트래킹
        for(int i=start; i<N; i++){
            int tmpSum = sum;
            tmpSum+=arr[i];
            bubun(cnt+1,i+1, tmpSum);
            tmpSum-=arr[i];
        }
    }
}
