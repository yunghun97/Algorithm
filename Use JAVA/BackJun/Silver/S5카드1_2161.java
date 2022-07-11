package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S5카드1_2161 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }
        while(!q.isEmpty()){
            bw.write(""+q.poll()+" ");
            if(!q.isEmpty()){
                q.add(q.poll());
            }
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2161