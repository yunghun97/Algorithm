package BackJun.Gold;

import java.io.*;
import java.util.*;

// 2차원 배열로 하면 더 빨리 풀 수 있다.
public class G4녹색옷입은애가젤다지_4485 {
    static int[] arr, dx;
    static ArrayList<ArrayList<Node>> list;
    static int[] distance;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int index = 0;
        while(true){
            ++index;
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            arr = new int[N*N];
            dx = new int[]{-1,1,-N,N};  // 인접한 기준
            list = new ArrayList<ArrayList<Node>>();
            distance = new int[N*N];
            Arrays.fill(distance, Integer.MAX_VALUE);
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    arr[i*N+j] = Integer.parseInt(st.nextToken());
                    list.add(new ArrayList<Node>());
                }
            }
            int check1 = 0;
            int check2 = N-1;
            for(int i=0; i<N*N; i++){   // 인접 리스트 생성
                if(i==check1){  // 젤 왼쪽일 때
                    check1+=N;
                    for(int d=1; d<4; d+=2){
                        int nx = i+dx[d];
                        if(nx<0||nx>=N*N) continue;
                        list.get(i).add(new Node(nx, arr[nx]));
                    }
                }else if(i==check2){    // 오른쪽에 있을 때
                    check2+=N;
                    for(int d=0; d<4; d+=3){
                        int nx = i+dx[d];
                        if(nx<0||nx>=N*N) continue;
                        list.get(i).add(new Node(nx, arr[nx]));
                    }
                }
                else{
                    for(int d=0; d<4; d++){ // 왼벽, 오른벽 위치가 아닐 때
                        int nx = i+dx[d];
                        if(nx<0||nx>=N*N) continue;
                        list.get(i).add(new Node(nx, arr[nx]));
                    }
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.weight, o2.weight));
            distance[0] = arr[0];
            pq.add(new Node(0,distance[0]));
            outer : while(!pq.isEmpty()){
                Node node = pq.poll();
                int start = node.num;   // 기준 정점
                for(int i=0; i<list.get(start).size(); i++){    // 기준 정점 인접한 노드 모두 탐색
                    if(distance[list.get(start).get(i).num]>distance[start]+arr[list.get(start).get(i).num]){   // 기준 지점을 거쳐서 가는것 이 더 빠른 경우
                        // System.out.println("시작번호 : "+start+"  @  "+distance[start]+" & "+node.weight+ " %" + distance[list.get(start).get(i).num]);
                        distance[list.get(start).get(i).num] = distance[start]+ arr[list.get(start).get(i).num];    // 기준 정점 소모시간 + 기준 정점에서 해당 정점 가는 시간
                        pq.add(new Node(list.get(start).get(i).num,distance[list.get(start).get(i).num]));  // pq에 넣고 가장 시간이 적게 걸리는 것 위주로 정렬

                        if(list.get(start).get(i).num==N*N-1){  // 문제를 보면 목표 정점에 가는 시간은 다른 정점에서 가는 시간과 다 똑같으므로 목표 정점을 가장 처음 탐색하는 정점은 목표 정점전의 가장 최소 시간이므로 바로 출력하면 된다.(다 가중치가 다르면 모든 정점을 다 확인할 때까지 돌려야 된다.)
                            bw.write("Problem "+index+": "+distance[list.get(start).get(i).num]+"\n");
                            break outer;
                        }
                    }
                }
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
    static class Node{
        int num;
        int weight;
        public Node(int num, int weight){
            this.num = num;
            this.weight = weight; 
        }
        @Override
        public String toString() {
            return "Node [endNum=" + num + ", weight=" + weight + "]";
        }
        
    }

}
//https://www.acmicpc.net/problem/4485