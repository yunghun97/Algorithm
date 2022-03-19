package BackJun.Silver;

import java.util.*;
import java.io.*;
public class S1절대값힙_11286 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Long> pq = new PriorityQueue<>((o1,o2) -> {
            if(Math.abs(o1)==Math.abs(o2)) return Long.compare(o1, o2);
            return Long.compare(Math.abs(o1), Math.abs(o2));
        });
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            long input = Long.parseLong(br.readLine());
            if(input==0){
                if(pq.isEmpty()){
                    bw.write("0"+"\n");
                }else{
                    bw.write(String.valueOf(pq.poll())+"\n");
                }
            }else{
                pq.add(input);
            }
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/11286