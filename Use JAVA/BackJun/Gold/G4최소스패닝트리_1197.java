package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4최소스패닝트리_1197 {
    static int N, V, answer;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());        
        answer = 0;
        arr = new int[N+1];
        // 초기화
        for(int i=0; i<=N; i++){
            arr[i] = i;
        }
        int count =0;        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.weight, o2.weight));
        for(int i=0; i<V; i++){            
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b,c));
        }
        while(!pq.isEmpty()){
            Node node = pq.poll();            
            // 합병 성공 시
            if(union(node.start, node.end)){
                answer+=node.weight;
                count++;
                if(count==N-1) break;
            }
        }        
        bw.write(""+answer);
        bw.flush();
    }

    static int find(int num){
        if(arr[num]==num){
            return num;
        }
        return find(arr[num]);
    }

    /**
     * 
     * @param a 기준
     * @param b 합병 되는 숫자
     * @return  true : 합병 성공 false : 합병 실패
     */
    static boolean union(int a, int b){
        int num1 = find(a);
        int num2 = find(b);
        if(num1==num2) return false;

        arr[num2] = num1;
        return true;
    }

    static class Node{
        int start;
        int end;
        int weight;
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
// https://www.acmicpc.net/problem/1197