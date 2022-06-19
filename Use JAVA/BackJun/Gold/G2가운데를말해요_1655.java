package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G2가운데를말해요_1655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minPq = new PriorityQueue<>((o1,o2)->Integer.compare(o1, o2));
        PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1,o2)->Integer.compare(o2, o1));        
        for(int i=0; i<N; i++){            
            int num = Integer.parseInt(br.readLine());
            if(minPq.size()==maxPq.size()){ // 제일 처음에 넣기
                maxPq.add(num);
                if(!minPq.isEmpty()&&minPq.peek()<maxPq.peek()){ // minPq의 최소값이 maxPq의 최대값보다 크도록 유지
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }else{
                minPq.add(num);
                if(maxPq.peek()>minPq.peek()){ // minPq의 최소값이 maxPq의 최대값보다 크도록 유지
                    minPq.add(maxPq.poll());
                    maxPq.add(minPq.poll());
                }
            }
            bw.write(""+maxPq.peek());
            if(i!=N-1) bw.newLine();
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/1655