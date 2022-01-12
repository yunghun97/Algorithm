package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G3다리만들기_2146 {
    static int N,answer;
    static int[][] mapNum, mapMove;
    static boolean[][] defaultMap, isVisited;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        mapNum = new int[N][N]; // 섬의 번호를 나타낼 배열
        mapMove = new int[N][N];    // 섬에서 이동거리를 나타내는 배열
        defaultMap = new boolean[N][N]; // 처음에 섬의 존재유무를 나타냄
        isVisited = new boolean[N][N];  // 방문체크용
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    defaultMap[i][j] = true;                    
                }
                mapMove[i][j] = Integer.MAX_VALUE;
            }
        }
        answer = Integer.MAX_VALUE;
        firstSetMap();  //섬의 종류를 세팅
        move(); // 다리 놓기
        bw.write(String.valueOf(answer-1));
        bw.flush();
    }
    private static void move() {
        Queue<Node> q = new LinkedList<>();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(mapNum[r][c]!=0){
                    int mapKind = mapNum[r][c]; // 섬의 종류를 저장
                    int moveIdx = 0;    // 해당 좌표를 가기위해 섬에서 몇 칸 이동하는지
                    q.add(new Node(r,c));
                    while(!q.isEmpty()){
                        int size = q.size();    // 거리마다 돌기위한 size
                        moveIdx++;  // 거리 +1
                        for(int x=0; x<size; x++){
                            Node node = q.poll();
                            for(int d=0; d<4; d++){ // BFS 탐색
                                int nr = node.r + dx[d];
                                int nc = node.c + dy[d];
                                if(nr<0||nr>=N||nc<0||nc>=N||mapNum[nr][nc]==mapKind||mapMove[nr][nc]<=moveIdx||moveIdx>=answer) continue;   // 같은 섬이거나 map 범위 밖, 해당 좌표를 더 늦게 가는 경우 continue
                                if(mapNum[nr][nc]>0&&mapNum[nr][nc]!=mapKind){  // 다른 섬에 도착하는 경우
                                    answer = Math.min(answer, moveIdx);   // 최소값으로 세팅
                                    continue;   
                                }
                                mapMove[nr][nc] = moveIdx;  // 끝나지 않으면 더 적은 거리로 세팅해주기
                                q.add(new Node(nr,nc));
                            }
                        }
                    }
                }
            }
        }
    }
    private static void firstSetMap() {
        Queue<Node> q = new LinkedList<>();
        int num =0;
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(defaultMap[r][c]){
                    if(isVisited[r][c]) continue;
                    ++num;  // 섬의 번호 바꿔주기
                    isVisited[r][c]=true;
                    q.add(new Node(r, c));
                    mapNum[r][c] = num;
                    while(!q.isEmpty()){    // BFS 탐색
                        Node node = q.poll();
                        mapNum[node.r][node.c] = num;
                        for(int d=0; d<4; d++){
                            int nr = node.r + dx[d];
                            int nc = node.c + dy[d];
                            if(nr<0||nr>=N||nc<0||nc>=N||isVisited[nr][nc]||!defaultMap[nr][nc]) continue;
                            isVisited[nr][nc] = true;
                            q.add(new Node(nr, nc));
                        }
                    }
                }
    
            }
        }
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
//https://www.acmicpc.net/problem/2146