package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S5수정렬하기2_2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1, o2));
        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        while(!pq.isEmpty()){
            bw.write(""+pq.poll());
            bw.newLine();
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2751