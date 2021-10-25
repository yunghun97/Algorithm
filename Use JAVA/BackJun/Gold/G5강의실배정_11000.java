package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5강의실배정_11000{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.start==o2.start){
                    return Integer.compare(o1.end, o2.end);
                }else return Integer.compare(o1.start, o2.start);
            }            
        });
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.add(pq.poll().end); // 현재 강의실에서 가장 빨리 끝나는 시간
        while(!pq.isEmpty()){
            Node node = pq.poll();  // 다음 강의 정보 가져오기
            if(node.start<pq2.peek()){  // 다음강의 시작시간이 가장 빨리 끝나는 시간 보다 빠르면 강의실 추가
                pq2.add(node.end);
            }else{  // 같은 강의실에서 하면 -> 과거 강의 없애고 새로운 강의 끝나는 시간으로 업데이트
                pq2.poll();
                pq2.add(node.end);
            }
        }
        bw.write(""+pq2.size());    // pq2에는 강의실에서 진행하는 강의들이 저장되므로 size 출력
        bw.flush();
    }
    static class Node{
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }        
    }
} 
//https://www.acmicpc.net/problem/11000