package BackJun.Gold;

import java.io.*;
import java.util.*;

// 카드 A B 있을 때 두 묶음을 하나로 만드는데 A+B의 비교를 해야한다.

public class G4카드정렬하기_1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>((o1,o2)-> Long.compare(o1, o2));
        for(int i=0; i<N; i++){
            pq.add(Long.parseLong(br.readLine()));
        }
        long answer = 0;
        while(!pq.isEmpty()){
            long a = pq.poll();
            if(pq.isEmpty()) break;
            long b = pq.poll();
            answer += a+b;
            pq.add(a+b);            
        }
        bw.write(""+answer);
        bw.flush();
    }   
}
// https://www.acmicpc.net/problem/1715