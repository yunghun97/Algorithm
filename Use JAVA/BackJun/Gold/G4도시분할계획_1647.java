package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4도시분할계획_1647 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) ->{
            return Integer.compare(o1.weight, o2.weight);
        });
        arr = new int[N];
        for(int i=0; i<N; i++){ // 배열 초기화
            arr[i] = i;
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }

        int answer = 0; // 유지비 합
        int count = 0; // 선분 개수 -> N-1개 
        // 길 놓기 실행
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(union(node.start, node.end)){
                count++;
                answer += node.weight;
            }else continue;
            
            if(count==N-2){
                pq.clear();
                break;
            }
        }
        bw.write(""+answer);
        bw.flush();
    }    
    // 해당 배열의 조상 찾기
    private static int find(int x){
        if(arr[x]==x) return x;
        return arr[x] = find(arr[x]);
    }
    private static boolean union(int x, int y){
        int a = find(x);
        int b = find(y);
        if(a==b) return false;
        else{
            arr[a] = b; // 병합
            return true;
        }
    }
    static class Node{
        int start;
        int end;
        int weight;
        public Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
// https://www.acmicpc.net/problem/1647