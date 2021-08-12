package 순열조합부분집합연습용;

import java.io.*;
import java.util.Arrays;

public class 순열비트연산 {
    static int N, R;
    static int[] answer, input;
    static int totalcount;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        input = new int[N]; answer = new int[R];
        for(int i=0; i<N; i++){
            input[i] = i+1;
        }
        permutation(0,0);
    }
    private static void permutation(int cnt, int flag) {
        if(cnt==R){
            System.out.println(Arrays.toString(answer));
            return;
        }
        
        for(int i=0; i<N; i++){
            if((flag &1<<i)!=0) continue; // 1이면 사용중이라는 뜻
            
            answer[cnt]=input[i];
            permutation(cnt+1, flag |1<<i);
        }
    }
}
/*
int flag = 0;
        for(int i=0; i<5; i++){
            flag = 1<<i;
            System.out.println(flag);
        } - > 결과 1,2,4,8,16
*/