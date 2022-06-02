package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4PuyoPuyo_11559{
    static int[][] map;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        map = new int[12][6];
        isVisited = new boolean[12][6];
        for(int i=0; i<12; i++){
            String input = br.readLine();
            for(int x=0; x<6; x++){
                char a = input.charAt(x);
                if(a=='.'){
                    map[i][x] = 0;
                }else if(a=='R'){
                    map[i][x] = 1;
                }else if(a=='G'){
                    map[i][x] = 2;
                }else if(a=='B'){
                    map[i][x] = 3;
                }else if(a=='P'){
                    map[i][x] = 4;
                }else{
                    map[i][x] = 5;
                }
            }
        }
        int answer = 0;
        while(boomCheck()){
            visitReset();
            answer++;
            boom();
            visitReset();
            gravity();
        }        
        bw.write(""+answer);
        bw.flush();
    }
    // 중력
    private static void gravity() {
        for(int c=0; c<6; c++){
            for(int r=11; r>=1; r--){
                if(map[r][c]!=0) continue;
                for(int ur=r-1; ur>=0; ur--){                
                    if(map[ur][c]!=0){
                        int kind = map[ur][c];
                        map[ur][c] = 0;
                        map[r][c] = kind;
                        break;
                    }
                }
            }
        }
    }
    // 터질게 있는지 체크
    private static boolean boomCheck() {
        for(int r=0; r<12; r++){
            for(int c=0; c<6; c++){
                if(map[r][c]!=0&&!isVisited[r][c]){ // 0이 아니고 방문하지 않은 좌표
                    int count = bfs(r,c,map[r][c]);
                    if(count>=4) return true;
                }
            }
        }
        return false;
    }
    // bfs로 해당 좌표와 연결된 구슬 개수 return
    private static int bfs(int r, int c, int kind) {
        int count = 1;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        isVisited[r][c] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if(outCheck(nr, nc)||isVisited[nr][nc]||map[nr][nc]!=kind) continue;
                isVisited[nr][nc] = true;
                count++;
                q.add(new Node(nr, nc));
            }
        }
        return count;
    }
    // 터뜨리기
    private static void boom() {
        Queue<Node> boomQ = new LinkedList<>();
        for(int r=0; r<12; r++){
            for(int c=0; c<6; c++){
                if(map[r][c]!=0&&!isVisited[r][c]){ // 0이 아니고 방문하지 않은 좌표
                    int count = bfs(r,c,map[r][c]);
                    if(count>=4){
                        boomQ.add(new Node(r, c));
                    }
                }
            }
        }
        visitReset();
        while(!boomQ.isEmpty()){
            Node node = boomQ.poll();
            boomBFS(node.r,node.c,map[node.r][node.c]);
        }
    }
    // 해당 좌표와 연결된 구슬들 다 공백으로 만들어 주기
    private static void boomBFS(int r, int c, int kind) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c));
        isVisited[r][c] = true;
        map[r][c] = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if(outCheck(nr, nc)||isVisited[nr][nc]||map[nr][nc]!=kind) continue;
                isVisited[nr][nc] = true;
                map[nr][nc] = 0;
                q.add(new Node(nr, nc));
            }
        }
    }
    // 방문 배열 초기화
    private static void visitReset(){
        for(int i=0; i<12; i++){
            Arrays.fill(isVisited[i], false);
        }
    }
    // 범위 밖으로 나가는지 체크
    private static boolean outCheck(int r, int c){
        if(r<0||r>=12||c<0||c>=6) return true;
        return false;
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
// https://www.acmicpc.net/problem/11559