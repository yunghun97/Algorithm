package BackJun.Gold;

import java.io.*;
import java.util.*;
// 좌표 1,1 시작
// 좌표 정하기 : 주사위 바닥 dice[3] = A 해당 칸 = B
// A > B 우 90도 A < B 좌 90% A = B 원래 방향대로
// 점수 : 상하좌우 B 존재 개수 * B
// !! 주사위 정면에서 보는 좌표가 5이다. (바닥은 6)
public class G3주사위굴리기2_23288 {
    static Node node;
    static int[][] map, score;
    static int[] dice;
    static int left, right, R, C, answer;
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        dice = new int[]{2,1,5,6};
        left = 4;
        right = 3;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        score = new int[R][C];
        answer = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        node = new Node(0, 0, 1);
        setScore();
        for(int k=0; k<K; k++){
            move();
            answer+=(map[node.r][node.c]*score[node.r][node.c]);
            setDir();            
        }
        bw.write(""+answer);
        bw.flush();
    }    
    // score를 처음에 다 구해서 여러번 이동해도 같은 계산을 탐색하지 않도록 함
    private static void setScore() {        
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                int result = BFS(r,c, map[r][c]);
                score[r][c] = result;
            }
        }
    }
    // BFS 탐색
    private static int BFS(int r, int c, int kind) {
        boolean[][] isVisited =new boolean[R][C];
        Queue<Node> q = new LinkedList<>();
        int result = 1;
        q.add(new Node(r, c, 0));
        isVisited[r][c] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if(outCheck(nr, nc)) continue;
                if(isVisited[nr][nc]||map[nr][nc]!=kind) continue;
                isVisited[nr][nc]=true;
                q.add(new Node(nr,nc,0));
                result++;
            }
        }
        return result;
    }
    // 주사위 움직이기
    private static void move() {
        int nr = node.r + dx[node.dir];
        int nc = node.c + dy[node.dir];
        if(outCheck(nr, nc)){
            node.dir = (node.dir + 2) % 4;
            nr = node.r + dx[node.dir];
            nc = node.c + dy[node.dir];
        }
        setDice(node.dir);
        node.r = nr;
        node.c = nc;        
    }
    // 주사위 움직인거 방향에 따른 주사위 정보 업데이트
    private static void setDice(int dir) {
        if(dir==0){ // 북쪽
            int tmp = dice[0];
            for(int i=0; i<3; i++){
                dice[i] = dice[i+1];
            }            
            dice[3] = tmp;               
        }else if(dir==1){ // 동쪽
            int tmpL = left;
            int tmpR = right;
            left = dice[3];
            right = dice[1];
            dice[3] = tmpR;
            dice[1] = tmpL;
        }else if(dir==2){ // 남쪽
            int tmp = dice[3];
            for(int i=3; i>=1; i--){
                dice[i] = dice[i-1];
            }
            dice[0] = tmp;      
        }else{ // 서쪽
            int tmpL = left;
            int tmpR = right;
            left = dice[1];
            right = dice[3];
            dice[1] = tmpR;
            dice[3] = tmpL;
        }
    }
    // 주사위 방향 정하기
    private static void setDir() {
        int a = dice[3];
        int b = map[node.r][node.c];
        if(a>b) node.dir = (node.dir+1)%4;
        else if(a==b) return;
        else{
            if(node.dir==0) node.dir=3;
            else node.dir--;
        }
    }
    private static boolean outCheck(int r, int c) {
        if(r<0||r>=R||c<0||c>=C) return true;
        return false;
    }
    static class Node{
        int r;
        int c;
        int dir;
        public Node(int r, int c, int dir){
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
}
// https://www.acmicpc.net/problem/23288