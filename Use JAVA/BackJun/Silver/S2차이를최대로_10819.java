package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S2차이를최대로_10819 {
    static int R,answer;
    static int[] input, sort;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        R = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        input = new int[R]; sort = new int[R];
        for(int i=0; i<R; i++){
            input[i] =Integer.parseInt(st.nextToken());
        }
        isSelected = new boolean[R];
        answer = Integer.MIN_VALUE;
        permutation(0,0);
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void permutation(int cnt, int sum) {
        if(cnt==R){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=0; i<R; i++){

            if(isSelected[i]) continue;

            sort[cnt] = i;
            isSelected[i] = true;
            if(cnt==0){
            permutation(cnt+1, sum);
            }else{
                permutation(cnt+1, sum+Math.abs(input[sort[cnt-1]]-input[sort[cnt]]));
            }
            isSelected[i]=false;
            
        }
    }
}
// https://www.acmicpc.net/problem/10819
/*
6
20 1 15 8 4 10
*/