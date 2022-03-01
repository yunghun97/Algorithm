package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S2최대힙_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o2, o1));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){ 
                if(pq.isEmpty()){
                    sb.append("0\n");                    
                }else sb.append(String.valueOf(pq.poll())+"\n");                               
            }else{
                pq.add(input);
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/11279