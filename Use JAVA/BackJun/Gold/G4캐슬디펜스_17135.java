package BackJun.Gold;
import java.io.*;
import java.util.*;


public class G4캐슬디펜스_17135 {
    static int R, C, D;
    static int[][] map, defalutMap;
    static int[] bow;
    static int answer;
    static PriorityQueue<Node> pq1, pq2, pq3;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        defalutMap = new int[R][C];
        bow = new int[3];
        answer = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                defalutMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        pq1 = new PriorityQueue<Node>();
        pq2 = new PriorityQueue<Node>();
        pq3 = new PriorityQueue<Node>();
        combination(0,0);
        bw.write(""+answer);
        bw.flush();
    }
    private static void combination(int cnt, int start) {
        if(cnt==3){
            for(int i=0; i<R; i++) System.arraycopy(defalutMap[i], 0, map[i], 0, C);    // 매 게임마다 배열 초기화
            gameStart();
            return;
        }
        for(int i=start; i<C; i++){
            bow[cnt] = i;
            combination(cnt+1, i+1);
        }
    }
    
    private static void gameStart() {   // 게임 시작
        int result = 0;
        while (true) {
            for (int r = R - 1; r >= 0; r--) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] == 1) { // 적이 있는 경우
                        if (Math.abs(r - R) + Math.abs(c - bow[0]) <= D) {
                            pq1.add(new Node(r, c, Math.abs(r - R) + Math.abs(c - bow[0])));    // 첫번 쨰 궁수
                        }
                        if (Math.abs(r - R) + Math.abs(c - bow[1]) <= D) {
                            pq2.add(new Node(r, c, Math.abs(r - R) + Math.abs(c - bow[1])));    // 두번 째 궁수
                        }
                        if (Math.abs(r - R) + Math.abs(c - bow[2]) <= D) {
                            pq3.add(new Node(r, c, Math.abs(r - R) + Math.abs(c - bow[2])));    // 3번 째 궁수
                        }
                    }
                }
            }
            int tmpR = -1; int tmpC = -1;   // 기존의 좌표와 겹치는지 확인용
            if(!pq1.isEmpty()){ // 첫번 쨰 궁수
                Node node = pq1.poll();
                map[node.r][node.c] = 0;    // 적 없애기
                if(node.r!=tmpR||node.c!=tmpC){ // 겹치지 않는 경우 좌표 새로 할당 및 answer++;
                    tmpR = node.r;
                    tmpC = node.c;
                    result++;
                }
            }
            if(!pq2.isEmpty()){ //두번 쨰 궁수
                Node node = pq2.poll();
                map[node.r][node.c] = 0; // 적 없애기
                if(node.r!=tmpR||node.c!=tmpC){ // 겹치지 않는 경우 좌표 새로 할당 및 answer++;
                    tmpR = node.r;
                    tmpC = node.c;
                    result++;
                }
            }
            if(!pq3.isEmpty()){ //3번 째 궁수
                Node node = pq3.poll();
                map[node.r][node.c] = 0; // 적 없애기
                if(node.r!=tmpR||node.c!=tmpC){ // 겹치지 않는 경우 좌표 새로 할당 및 answer++;
                    tmpR = node.r;
                    tmpC = node.c;
                    result++;
                }
            }
            pq1.clear();
            pq2.clear();
            pq3.clear();
            enemyMove();    // 적 움직이기
            if(endCheck()){ // 끝났는지 체크
                answer = Math.max(result, answer);
                return;
            }
        }
    }
    private static boolean endCheck() {
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]==1) return false;
            }
        }
        return true;
    }
    private static void enemyMove() {
        
        for (int r = R-1; r >= 1; r--) {
            for (int c = 0; c < C; c++) {
                map[r][c] = map[r-1][c];
            }
        }
        for(int x=0; x<C; x++) map[0][x] = 0;

    }
    static class Node implements Comparable<Node>{
        int r;
        int c;
        int weight;
        public Node(int r, int c, int weight){
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    
        @Override
        public int compareTo(Node o) {
            if(this.weight!=o.weight){
                return Integer.compare(this.weight, o.weight);
            }else{
                return Integer.compare(this.c, o.c);
            }
        }
    
    }
}
// https://www.acmicpc.net/problem/17135