package BackJun.Silver;

import java.util.StringTokenizer;
import java.io.*;
public class S2로또_6603 {
    static int N, M;
    static int[] arr, result;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            if(st.countTokens()==1) break;
            N = Integer.parseInt(st.nextToken());   // 뽑는 개수
            result = new int[6];
            M = st.countTokens();   // 배열 크기
            arr = new int[st.countTokens()];            
            for(int i=0; i<M; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            combination(0,0);
            bw.newLine();
        }
        bw.flush();
    }
    static void combination(int cnt, int start)throws IOException{ // 조합뽑는 메소드
        if(cnt==6){
            for(int i=0; i<6; i++){
                bw.write(String.valueOf(result[i])+" ");
            }
            bw.newLine();
            return;
        }
        for(int i=start; i<M; i++){
            result[cnt] = arr[i];
            combination(cnt+1, i+1);
        }
    }
}
//https://www.acmicpc.net/problem/6603