package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S2한줄로서기_1138 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        boolean[] isVisited = new boolean[N];
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            int number = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int j=0; j<N; j++){
                if(!isVisited[j]){
                    if(count==number){
                        isVisited[j] = true;
                        arr[j] = i+1;
                        break;
                    }
                    count++;
                }
            }
        } 
        for(int i=0; i<N; i++){
            bw.write(""+arr[i]+" ");
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/1138