package BackJun.Gold;

import java.io.*;
import java.util.*;

// 0 : 흰색 1 : 빨간색 2 : 파란색
// 이동방향 1 : 우 2 : 좌 3 : 상 4 : 하

public class G2새로운게임_17780 {
    static int N,K;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static int[][] map;
    static boolean end;
    static Deque<Integer>[][] qMap; 

    static ArrayList<Node> tokenList;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        tokenList = new ArrayList<>();
        qMap = new Deque[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                qMap[i][j] = new ArrayDeque<>();
            }
        }
        for(int i=0; i<K; i++){
            // 이동방향 1 : 우 2 : 좌 3 : 상 4 : 하
            // 설정한거 : 상 좌 하 우
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            if(dir==1) dir = 3;
            else if(dir==2) dir = 1;
            else if(dir==3) dir = 0;
            else dir = 2;
            tokenList.add(new Node(r,c,dir));
            qMap[r][c].addLast(i);
        }
        int time = 1;
        end = false;
        while(time<=1000){
            move();
            if(endCheck()){
                end = true;
                bw.write(""+time);
                break;
            }
            time++;
        }
        if(!end){
            bw.write(""+-1);
        }
        bw.flush();
    }
    private static void move() {
        for(int i=0; i<tokenList.size(); i++){
            Node node = tokenList.get(i);
            int nr = node.r;
            int nc = node.c;
            if(qMap[node.r][node.c].peekLast()!=i) continue;
            else{ // 제일 하단에 있는거
                nr += dx[node.dir];
                nc += dy[node.dir];
                if(outCheck(nr,nc)||map[nr][nc]==2){ // 파란색이거나 벽 밖일 떄
                    // 원래대로
                    nr -= dx[node.dir]; // 원 위치
                    nc -= dy[node.dir]; // 원 위치
                    // 방향 바꾸기
                    node.dir = (node.dir+2)%4; // 방향 바꾸기
                    nr += dx[node.dir]; // 방향 바꾼 칸으로 이동
                    nc += dy[node.dir];
                    if(outCheck(nr,nc)||map[nr][nc]==2) continue; // 벽 밖이나 파란색인 경우 그냥 continue
                    else{
                        if(map[nr][nc]==0){ // 하양
                            whiteMove(node.r, node.c, nr,nc);
                        }else{ // 빨강
                            redMove(node.r, node.c, nr, nc);
                        }
                    }
                }
                else if(map[nr][nc]==0){ // 하양
                    whiteMove(node.r, node.c, nr,nc);
                }else{ //빨강
                    redMove(node.r, node.c, nr, nc);
                }
            }
        }
    }
    // 빨간 칸 이동
    private static void redMove(int r, int c, int nr, int nc) {
        while(!qMap[r][c].isEmpty()){
            int num = qMap[r][c].pollFirst();
            qMap[nr][nc].addFirst(num);
            Node node = tokenList.get(num);
            node.r = nr;
            node.c = nc;
        }
    }
    // 하얀 칸 이동
    private static void whiteMove(int r, int c, int nr, int nc) {
        while(!qMap[r][c].isEmpty()){
            int num = qMap[r][c].pollLast();
            qMap[nr][nc].addFirst(num);
            Node node = tokenList.get(num);
            node.r = nr;
            node.c = nc;
        }
    }
    // 배열 범위 밖인지 체크 -> 파란색과 똑같다.
    private static boolean outCheck(int nr, int nc) {
        if(nr<0||nr>=N||nc<0||nc>=N) return true;
        return false;
    }
    private static boolean endCheck() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(qMap[i][j].size()>=4) return true;
            }
        }
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
// https://www.acmicpc.net/problem/17780