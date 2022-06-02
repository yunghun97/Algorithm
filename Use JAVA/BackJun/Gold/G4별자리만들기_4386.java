package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4별자리만들기_4386 {
    static int N, visitCount;
    static ArrayList<Node> list;
    static int[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visitCount = 0;
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
        list = new ArrayList<>();
        list.add(new Node(0, 0));
        if(N!=1){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());
                list.add(new Node(x, y));
            }        
            PriorityQueue<Star> pq = new PriorityQueue<>((o1,o2)-> Double.compare(o1.len, o2.len));
            for(int i=1; i<list.size(); i++){
                for(int j=1; j<list.size(); j++){
                    if(i==j) continue;
                    Node preNode = list.get(i);
                    Node nextNode = list.get(j);
                    double a = Math.pow(Math.abs(preNode.x - nextNode.x),2);
                    double b = Math.pow(Math.abs(preNode.y - nextNode.y),2);     
                    double len = Math.round(Math.sqrt(a+b)*100)/100.0;    // 피타고라스 정리 사용 -> a^2 + b^2 = c^2 -> 따라서 c를 구하기 위해서 sqrt 사용                                      
                    pq.add(new Star(i, j, len));
                }
            }
            double answer = 0;        
            while(!pq.isEmpty()){ // 최소 스패닝 트리
                Star star = pq.poll();
                if(union(star.start, star.end)){
                    visitCount++;
                    answer += star.len;
                    if(visitCount==N-1) break;
                }
            }            
            bw.write(""+answer);
        }else{
            bw.write("0.00");
        }
        bw.flush();
    }
    static int find(int num){
        if(arr[num]==num) return num;
        return find(arr[num]);
    }
    static boolean union(int a, int b){ // 최소 스패닝 트리
        int resultA = find(a);
        int resultB = find(b);
        if(resultA==resultB) return false;
        arr[resultB] = resultA;
        return true;
    }
    static class Node{
        double x;
        double y;
        public Node(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static class Star{
        int start;
        int end;
        double len;
        public Star(int start, int end, double len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }   
    }
}
// https://www.acmicpc.net/problem/4386