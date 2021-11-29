package BackJun.Silver;

import java.io.*;
public class S3모든순열_10974 {
    static int N;
    static int[] answer;
    static boolean[] isSelected;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        isSelected = new boolean[N+1];
        answer = new int[N];

        permutation(0);
        bw.flush();
    }    
    static void permutation(int cnt) throws IOException{
        if(cnt==N){
            for(int i=0; i<N; i++){
                bw.write(String.valueOf(answer[i])+" ");
            }
            bw.newLine();
            return;
        }
        for(int i=1; i<=N; i++){
            if(isSelected[i]) continue;

            isSelected[i] = true;
            answer[cnt] = i;
            permutation(cnt+1);
            isSelected[i] = false;
        }
    }
}
//https://www.acmicpc.net/problem/10974