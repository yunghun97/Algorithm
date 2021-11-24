package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S5소트인사이드_1427 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->{
            return Integer.compare(o2, o1);
        });
        for(int i=0; i<arr.length; i++){
            pq.add((int)(arr[i]-48));
        }
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()){
            sb.append(pq.poll());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
//https://www.acmicpc.net/problem/1427