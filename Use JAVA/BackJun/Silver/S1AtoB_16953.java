package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1AtoB_16953 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        long num2 = Long.parseLong(st.nextToken());

        boolean end = false;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.time, o2.time));
        pq.add(new Node(num1,1));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.num==num2){
                bw.write(""+(node.time));
                end = true;
                break;
            }
            if(node.num*2<=num2){
                pq.add(new Node(node.num*2,node.time+1));
            }
            if(node.num*10+1<=num2){
                pq.add(new Node(node.num*10+1,node.time+1));
            }
        }
        if(!end) bw.write(""+(-1));
        bw.flush();
    }   
    static class Node{
        long num;
        int time;
        public Node(long num, int time){
            this.num = num;
            this.time = time;
        }
    }
}
//https://www.acmicpc.net/problem/16953