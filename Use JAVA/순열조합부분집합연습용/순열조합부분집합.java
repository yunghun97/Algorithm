package 순열조합부분집합연습용;

import java.io.*;
import java.util.Arrays;

public class 순열조합부분집합 {
    static int N,R;
    static int[] input,answer;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        input = new int[N]; answer = new int[R]; isSelected = new boolean[N];
        for(int i=0; i<N; i++){
            input[i] = i+1;
        }
        permutation(0);
    }
    private static void permutation(int cnt) {
        if(cnt==R){
            System.out.println(Arrays.toString(answer));
            return;
        }

        for(int i=0; i<N; i++){
            answer[cnt]=input[i];
            permutation(cnt+1);
        }
    }
}
