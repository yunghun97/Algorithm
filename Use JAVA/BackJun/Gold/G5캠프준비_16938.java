package BackJun.Gold;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5캠프준비_16938 {
    static int N, L, R, GAP, answer, sum;
    static int[] problem, result ;
    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        GAP = Integer.parseInt(st.nextToken());
        answer = 0;
        
        problem = new int[N];
        result = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            problem[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(problem);
        if(N>=2){
            combination(0,0);
        }
        bw.write(""+answer);
        bw.flush();
    }
    private static void combination(int cnt, int start) {
        if(cnt==N){ // 다 뽑은 경우
            if(check(cnt,result)) answer++;
            return;
        }else if(cnt>=2){   // 2개 이상 뽑은 상태
            if(check(cnt, result)) answer++;      
            if(sum>=R) return;     // 이미 합이 더 크거나 같으면 진행 X
        }
        for(int i=start; i<N; i++){
            result[cnt] = problem[i];
            combination(cnt+1, i+1);
        }
    }
    // 문제를 낼 수 있는지 확인
    private static boolean check(int cnt, int[] input) {
        int min = input[0];
        int max = input[cnt-1];
        sum = 0;
        for(int i=0; i<cnt; i++){
            sum+=input[i];
        }
        if(sum>=L&&sum<=R&&max-min>=GAP) return true;
        return false;
    }
}
// https://www.acmicpc.net/problem/16938