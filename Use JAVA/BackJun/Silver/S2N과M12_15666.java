package BackJun.Silver;

import java.io.*;
import java.util.*;


public class S2N과M12_15666 {
    static int[] input,answer;
    static int R,N;
    static boolean[] isSelected;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N];
        answer = new int[R];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        permutation(0);
        bw.close();
        br.close();
    }
    private static void permutation(int cnt) throws IOException {
        if(cnt==R){
            for(int i=0; i<R; i++){
                bw.write(""+answer[i]+" ");
            }
            bw.newLine();
            bw.flush();
            return;
        }

        int preNum = -1;
        for(int x=0; x<N; x++){
            if(preNum==input[x]) continue;

            answer[cnt] = input[x];
            preNum = input[x];
            permutation(cnt+1);
        }
    }
}
//https://www.acmicpc.net/problem/15665