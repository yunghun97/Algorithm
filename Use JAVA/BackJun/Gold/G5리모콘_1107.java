package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5리모콘_1107 {
    static boolean[] isErrored; 
    static int N, M, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = 0;
        M = 0;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        isErrored = new boolean[10];
        if(M!=0){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                isErrored[Integer.parseInt(st.nextToken())]= true;
            }
        }
        answer = Math.abs(N-100);
        for(int i=0; i<=1000000; i++){
            int tmp = check(i);
            if(tmp>0){
                int result = Math.abs(N-i);
                answer = Math.min(answer, tmp+result);
            }
        }
        bw.write(""+answer);
        bw.flush();
    }
    private static int check(int n) {
        if (n == 0) {   // 0일 때
            if (isErrored[0]) {
                return 0;
            } else {
                return 1;
            }
        }
        int result = 0;
        while (n > 0) {
            if (isErrored[n % 10]) {   // 고장난 버튼이 있는 경우
                return 0;
            }
            n /= 10;
            result += 1;   // 숫자버튼 누르는 횟수 증가
            if(result>=answer) return result;
        }
        return result;
    }    
}
//https://www.acmicpc.net/problem/1107