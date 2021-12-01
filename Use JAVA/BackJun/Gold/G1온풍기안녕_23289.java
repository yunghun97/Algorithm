package BackJun.Gold;

import java.io.*;
import java.util.*;

// 0 :빈 칸 | 온풍기 방향 1 : 오른쪽 2: 왼쪽 3 : 위쪽 4: 아래쪽 5: 온도조사 칸

// 벽 이동 기준 x,y를 출발점
// (x-1 y+1) 이동 시  (x, y)와 (x-1, y) 사이에 벽이 없어야 하고, (x-1, y)와 (x-1, y+1) 사이에도 벽이 없어야 한다. -- 위로 이동
// (x, y+1) 이동 시 (x,y+1) 이동 시 (x, y)와 (x, y+1) 사이에 벽이 없어야 한다.  -- 직선방향 이동
// (x+1 y+1) 이동 시 (x, y)와 (x+1, y), (x+1, y)와 (x+1, y+1) 사이에 벽이 없어야 한다. -- 아래로 이동

// 온도 조절
//모든 인접한 칸(상하좌우) 높은 칸에서 낮은으로 |두 칸의 온도의 차이/4| -> 높은 칸 감소 낮은 칸 상승 -> 벽 있으면 계산 X
public class G1온풍기안녕_23289 {
    static int[][] map, tmpMap;
    static boolean[][][] wallArr;
    static boolean[][] isVisited;
    static int R, C, K, WallCount, choco;

    static ArrayList<Heater> heaters;
    static ArrayList<Node> checkArr;
    static Queue<Node> q;
    static int[][] dirX = {{0,0,0},{-1,0,1},{-1,0,1},{-1,-1,-1},{1,1,1}}, dirY = {{0,0,0},{1,1,1},{-1,-1,-1},{-1,0,1},{-1,0,1}}; 
    static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        heaters = new ArrayList<>();
        checkArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        tmpMap = new int[R][C];
        wallArr = new boolean[R][C][2];
        isVisited = new boolean[R][C];
        choco = 0;
        q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 0) {
                    continue;
                } else if (a == 5) {
                    checkArr.add(new Node(i, j));   // 체크할 배열 노드 리스트
                    continue;
                } else {
                    heaters.add(new Heater(i, j, a));   // 히터 리스트
                    continue;
                }
            }
        }

        WallCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < WallCount; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());
            wallArr[r][c][t] = true;
        }

        while (choco <= 100) {
            heat(); // 히터틀기
            setTemper();    // 온도 조절
            // mapprint();
            minusTemper();  // 외각 온도 -
            choco++;    // 초콜릿 먹기
            if(endCheck()) break;   // 끝나는지 체크
        }
        bw.write(""+choco);
        bw.flush();
    }
    private static void mapprint() {    // 테스트 용 코드
        System.out.println("-----------------");
            for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
    }

    private static boolean endCheck() {
        for(Iterator<Node> it = checkArr.iterator(); it.hasNext();){
            Node node = it.next();
            if(map[node.r][node.c]<K) return false;
        }
        // mapprint();
        return true;
    }

    private static void minusTemper() {
        map[0][0]++;
        map[R-1][0]++;
        map[0][C-1]++;
        map[R-1][C-1]++;
        for(int c=0; c<C; c++){
            if(map[0][c]>=1) map[0][c]--;
            if(map[R-1][c]>=1) map[R-1][c]--;
        }
        for(int r=0; r<R; r++){
            if(map[r][0]>=1) map[r][0]--;
            if(map[r][C-1]>=1) map[r][C-1]--;
        }
        
    }

    private static void setTemper() {   // 온도 체팅
        for(int i=0; i<R; i++){ // 임시 온도 저장 배열 초기화
            Arrays.fill(tmpMap[i], 0);
        }
        for (int x = 0; x < R; x++){    // 한 번 체크한 좌표 표시용
            Arrays.fill(isVisited[x], false);
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]>0){        
                    isVisited[i][j] = true;   
                    for(int d=0; d<4; d++){
                        int nr = i+dx[d];
                        int nc = j+dy[d];
                        if(!check(nr, nc)) continue; // 벽 밖이거나 이미 방문해서 처리한 노드면 체크 다음 좌표 탐색  
                        if(d==0){ // 상
                            if(wallArr[i][j][0]) continue;
                        } 
                        else if(d==1){  // 좌
                            if(wallArr[nr][nc][1]) continue;
                        } 
                        else if(d==2){  // 우
                            if(wallArr[i][j][1]) continue;
                        } 
                        else{ // 아래
                            if(wallArr[nr][nc][0]) continue;
                        }
                        int tmp = Math.abs((map[nr][nc]-map[i][j])/4);
                        if(map[nr][nc]>map[i][j]){  // 클 때
                            tmpMap[nr][nc] -= tmp;
                            tmpMap[i][j] += tmp;
                        }else if(map[nr][nc]<map[i][j]){    // 작을 때
                            tmpMap[i][j] -= tmp;
                            tmpMap[nr][nc] += tmp;
                        }   
                    }
                }
            }
        }
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j]+=tmpMap[i][j];
            }
        }
    }

    private static void heat() {
        for (int i = 0; i < heaters.size(); i++) {  // 히터 리스트에서 1개 씩 꺼내서 테스트 한다.
            Heater heat = heaters.get(i);
            for (int x = 0; x < R; x++){
                Arrays.fill(isVisited[x], false);   // 방문 체크 초기화
            }
            // 히터가 무조건 한 칸 이상 온도를 전파하므로 외각 체크 처음에는 안해도 된다.
            if (heat.dir == 1) {    // 오
                q.add(new Node(heat.r, heat.c+1));
                map[heat.r][heat.c+1] +=5;
            } 
            else if (heat.dir == 2) { // 왼
                q.add(new Node(heat.r, heat.c-1));
                map[heat.r][heat.c-1] +=5;
            } 
            else if (heat.dir == 3) { // 위
                q.add(new Node(heat.r-1, heat.c));
                map[heat.r-1][heat.c] +=5;
            } 
            else {    // 아래
                q.add(new Node(heat.r+1, heat.c));
                map[heat.r+1][heat.c] +=5;
            }
            
            int dir = heat.dir; // 히터 방향
            int level = 4;  // level 설정
            while(!q.isEmpty()){
                if(level==0){
                    q.clear();
                    break;
                }
                int size = q.size();
                for(int x=0; x<size; x++){  // size 만큼 돌고 level-- 해준다.
                    Node node = q.poll();    
                    for(int d=0; d<3; d++){
                        if(check(node.r+dirX[dir][d], node.c+dirY[dir][d])){    // 벽 밖으로 안나갈 때
                            if(wallCheck(node.r, node.c, dir, d)){
                                int nr = node.r + dirX[dir][d];
                                int nc = node.c + dirY[dir][d];
                                map[nr][nc]+=level;
                                isVisited[nr][nc] = true;   // 한 번 +하면 더 할 필요 없으므로 방문체크
                                q.add(new Node(nr,nc)); // que에 추가하기
                            }
                        }
                    }               
                }
                --level;
            }
        }
    }


    private static boolean wallCheck(int r, int c, int heatDir, int d) {    // 벽으로 막혀서 못 나가는 조건
        if(heatDir==1){ // 오른쪽
            if(d==0){
                if(wallArr[r][c][0]||wallArr[r-1][c][1]) return false;
            }else if(d==1){
                if(wallArr[r][c][1]) return false;
            }else{
                if(wallArr[r+1][c][0]||wallArr[r+1][c][1]) return false;
            }
        }else if(heatDir==2){   // 왼쪽
            if(d==0){
                if(wallArr[r][c][0]||wallArr[r-1][c-1][1]) return false;
            }else if(d==1){
                if(wallArr[r][c-1][1]) return false;
            }else{
                if(wallArr[r+1][c][0]||wallArr[r+1][c-1][1]) return false;
            }
        }else if(heatDir==3){   // 위
            if(d==0){
                if(wallArr[r][c-1][1]||wallArr[r][c-1][0]) return false;
            }else if(d==1){
                if(wallArr[r][c][0]) return false;
            }else{
                if(wallArr[r][c][1]||wallArr[r][c+1][0]) return false;
            }
        }else{  // 아래
            if(d==0){
                if(wallArr[r][c-1][1]||wallArr[r+1][c-1][0]) return false;
            }else if(d==1){
                if(wallArr[r+1][c][0]) return false;
            }else{
                if(wallArr[r][c][1]||wallArr[r+1][c+1][0]) return false;
            }
        }
        return true;
    }

    private static boolean check(int nr, int nc) {  // 밖이거나 방문한 노드인지 체크
        if (nr < 0 || nr >= R || nc < 0 || nc >= C || isVisited[nr][nc]) {  // 범위 밖이면 false 리턴
            return false;
        }
        return true;
    }

    static class Heater {
        int r;
        int c;
        int dir;

        public Heater(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
