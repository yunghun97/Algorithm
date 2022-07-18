package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S2N번째큰수_2075 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o2, o1));
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }
        for(int i=0; i<N-1; i++){
            pq.poll();
        }
        bw.write(""+pq.poll());
        bw.flush();
    }   
}
// https://www.acmicpc.net/problem/2075