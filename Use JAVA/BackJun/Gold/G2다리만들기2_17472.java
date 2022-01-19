package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2다리만들기2_17472 {
    static int R, C, mapCount;
    static boolean[][] map, isVisited;
    static int[][] mapKind;    
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0}, isConnected;
    static Queue<Node> q;
    static PriorityQueue<Bridge> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        isVisited = new boolean[R][C];
        mapKind = new int[R][C];
        
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                if(Integer.parseInt(st.nextToken())==1){
                    map[i][j] = true;
                }
            }
        }
        pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.len, o2.len));

        // 맵 종류 세팅
        mapCount = setKind();
        isConnected = new int[mapCount+1];  // 연결된 최상위 섬을 나타내기 위한 배열
        for(int i=1; i<=mapCount; i++) isConnected[i] = i;
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]){
                    makeBridge(i,j, mapKind[i][j]); // 다리 만들기
                }
            }
        }
        int answer = setBridge();
        answer = (answer!=0) ? answer : -1;

        bw.write(String.valueOf(answer));
        bw.flush();
    }
    // 다리를 놓는 과정 Union Find 사용
    private static int setBridge() {
        int result = 0;
        while(!pq.isEmpty()){
            Bridge bridge = pq.poll();
            int x = bridge.start;
            int y = bridge.end;            
            if(union(x,y)){
                result+=bridge.len;
            }
        }
        int tmpx = isConnected[1];  // 다리가 모두 연결되어 있는지 확인용
        for(int i=2; i<=mapCount; i++){
            if(tmpx!=find(isConnected[i])){ // 모든 다리가 서로 연결되어 있지 않음
                return 0;
            }
        }
        return result;
    }
    /**
     * 다리를 연결해서 그 정보를 저장하는 메소드
     * @param r 행
     * @param c 열
     * @param kind 섬 종류
     */
    private static void makeBridge(int r, int c, int kind) {
        q = new LinkedList<>();
        
        for (int d = 2; d < 4; d++) {
            int len = 0;
            q.add(new Node(r, c));
            while (!q.isEmpty()) { // 오른쪽 아래만 탐색하면 됨 dx dy 2~3
                Node node = q.poll();
                int nr = node.r+dx[d];
                int nc = node.c+dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C||mapKind[nr][nc]==kind) continue;
                if(mapKind[nr][nc]==0){ // 다리 놓기
                    q.add(new Node(nr, nc));
                    ++len;
                }else{  // 다른 섬에 도착 
                    if(len==1) continue;
                    pq.add(new Bridge(kind, mapKind[nr][nc], len));
                }
            }
            q.clear();
        }
    }
    /**
     * 섬의 종류를 설정하고 그 정보를 mapKind[][]에 저장한다.
     * @return 섬의 개수 : 섬이 4개면 4 return
     */
    private static int setKind() {
        q = new LinkedList<>();
        int kind = 0;
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]){
                    if(isVisited[i][j]) continue;
                    kind++;
                    mapKind[i][j] = kind;
                    q.add(new Node(i, j));
                    isVisited[i][j] = true;
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        for(int d=0; d<4; d++){
                            int nr = node.r + dx[d];
                            int nc = node.c + dy[d];
                            if(nr<0||nr>=R||nc<0||nc>=C||isVisited[nr][nc]||!map[nr][nc]) continue;
                            isVisited[nr][nc] = true;
                            mapKind[nr][nc] = kind;
                            q.add(new Node(nr, nc));
                        }
                    }
                }
            }
        }
        return kind;
    }

    private static int find(int x){    
        if(isConnected[x]==x) return x;
        int result = find(isConnected[x]);
        return result;
    }
    private static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) {
            return false;
        }
        else{
            isConnected[y] = x;            
            return true;
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
    static class Bridge {
        int start;
        int end;
        int len;
        public Bridge(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }     
    }
}
// https://www.acmicpc.net/problem/17472