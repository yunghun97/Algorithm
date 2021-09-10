package BackJun.Gold;
import java.io.*;
import java.util.*;

public class G5숨박꼭질3_13549 {
    public static void main(String[] args) throws IOException{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int answer = 0;
        int[] distance  = new int[100001];  // 거리 배열
        boolean[] isVisited = new boolean[100001];  // 방문 체크
        // PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.weight, o2.weight)); // 가중치가 0,1 고정이라서 이 경우는 그냥 Queue가 더 빠르다.
        Queue<Node> pq = new LinkedList<>();
        pq.add(new Node(start,0));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(end==temp.endPoint){ // 종점이면 바로 종료
                answer = distance[temp.endPoint];
                break;
            }
            if(isVisited[temp.endPoint]) continue;  // 방문 했으면 다음 queue로
            isVisited[temp.endPoint] = true;

            if(temp.endPoint-1>=0){     // -1 일때
                if(distance[temp.endPoint-1] > distance[temp.endPoint]+1){
                    distance[temp.endPoint-1] = distance[temp.endPoint]+1;
                    pq.add(new Node(temp.endPoint-1,distance[temp.endPoint-1]));
                }
            }
            if(temp.endPoint+1<=100000){    // +1일때
                if(distance[temp.endPoint+1]>distance[temp.endPoint+1]+1){
                    distance[temp.endPoint+1] = distance[temp.endPoint]+1;
                    pq.add(new Node(temp.endPoint+1,distance[temp.endPoint+1]));
                }
            }
            if(temp.endPoint*2<=100000){    // * 일때
                if(distance[temp.endPoint*2]>distance[temp.endPoint]){
                    distance[temp.endPoint*2] = distance[temp.endPoint];
                    pq.add(new Node(temp.endPoint*2, distance[temp.endPoint*2]));
                }
            }

        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    static class Node{
        int endPoint;
        int weight;
        public Node(int endPoint, int weight) {
            this.endPoint = endPoint;
            this.weight = weight;
        }
    }
}
//https://www.acmicpc.net/problem/13549