package BackJun.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S4로프_2217 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2, o1));

        PriorityQueue<Integer> comparePq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1, o2));
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        int idx = 0;
        while(!pq.isEmpty()){
            int number = pq.poll();
            comparePq.add(number);
            if(answer<number){
                answer = number;
            }
            idx++;
            if(answer<comparePq.peek()*idx){
                answer = comparePq.peek()*idx;
            }

        }
        bw.write(""+answer);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2217
