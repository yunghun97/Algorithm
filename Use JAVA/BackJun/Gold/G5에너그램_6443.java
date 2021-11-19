package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5에너그램_6443 {
    static char[] input, answer;
    static int N;
    static boolean[] isVisited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; 
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            String a = br.readLine();
            input = a.toCharArray();
            Arrays.sort(input);
            N = input.length;
            answer = new char[N];
            isVisited = new boolean[N];
            permutation(0);
        }   // 테케 끝
        bw.flush();
    }
    private static void permutation(int cnt) throws IOException {
        if(cnt==N){
            for(int i=0; i<N; i++){
                bw.write(answer[i]);
            }
            bw.newLine();
        }
        for(int i=0; i<N; i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            answer[cnt] = input[i];
            permutation(cnt+1);
            isVisited[i] = false;
        }
    }
}
