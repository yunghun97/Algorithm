package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S2최소힙_1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1, o2));
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input==0){ 
                if(pq.isEmpty()){
                    bw.write("0\n");                    
                }else bw.write(String.valueOf(pq.poll())+"\n");                               
            }else{
                pq.add(input);
            }
        }        
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/1927
