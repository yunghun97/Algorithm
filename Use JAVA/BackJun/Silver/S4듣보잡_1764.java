package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S4듣보잡_1764 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String, Boolean> hmap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;
        for(int i=0; i<N; i++){
            hmap.put(br.readLine(), true);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1,o2)-> o1.compareTo(o2));
        for(int i=0; i<M; i++){
            String input = br.readLine();
            if(hmap.containsKey(input)){
                pq.add(input);
                result++;
            }
        }
        bw.write(""+result+"\n");
        while(!pq.isEmpty()){
            bw.write(pq.poll());
            if(!pq.isEmpty()) bw.newLine();
        }        
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/1764