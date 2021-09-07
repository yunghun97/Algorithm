package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1단지번호붙이기_2667 {
    static char[][] map;
    static int[] dx ={-1,0,0,1}, dy ={0,-1,1,0};
    static boolean[][] isVisited;
    static int N, kind;
    static Queue<Node> q;
    static PriorityQueue<Apart> answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }
        kind =0;
        q = new LinkedList<>(); // 단지 BFS탐색할 큐
        answer = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.count,o2.count));    // 결과를 저장할 우선순위 큐
        
        bfs();  // BFS 탐색
        bw.write(""+kind+"\n");
        while(!answer.isEmpty()){
            bw.write(""+answer.poll().count+"\n");
        }
        bw.flush();
    }
    private static void bfs() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!isVisited[i][j]){   // 방문 안한 노드만
                if(map[i][j]=='1'){     // 1이면 Q에 집어넣기
                    int result = 0;     // 단지 결과 값 전용
                    kind++;             // 1이 나오면 주위 모든 1을 탐색하므로 kind는 단지 수가 된다.
                    q.add(new Node(i,j));   // 해당좌표를 큐에 넣어준다.
                    isVisited[i][j]=true;   // 방문 체크
                    while(!q.isEmpty()){    // q가 빌때까지 -> 주위가 모두 0 일때 까지
                        result++;   // 단지수 ++
                        Node tempNode = q.poll();  
                        for(int d=0; d<4; d++){ // 4방 탐색
                            int nr = tempNode.r + dx[d];
                            int nc = tempNode.c + dy[d];
                            if(nr<0||nr>=N||nc<0||nc>=N) continue;
                            if(isVisited[nr][nc]) continue; // 이미 이전에 방문했으면 continue
                            else{
                            if(map[nr][nc]=='0'){   // 0이므로 큐에 넣지 않고 방문체크만 해준다.
                                isVisited[nr][nc]=true;
                                continue;
                            }else{
                                isVisited[nr][nc]=true;
                                q.add(new Node(nr,nc)); // 인접좌표가 1이고 탐색안한 좌표이므로 q에 넣어서 그 좌표에서 사방탐색 진행
                            }
                            }
                        }
                    }
                    answer.add(new Apart(result));
                }else{
                    isVisited[i][j]=true;   // 방문안했는데 0 값이면 방문 표시만 체크
                }
                }else continue; // 방문 했으므로 탐색 X
            }
        }


    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    static class Apart{
        int count;
        public Apart(int count) {
            this.count = count;
        }
    }
}
//https://www.acmicpc.net/problem/2667