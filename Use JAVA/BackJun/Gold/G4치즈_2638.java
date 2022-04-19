package BackJun.Gold;

import java.util.*;
import java.io.*;

//  4변 중에서 적어도 2변 이상이 실내온도의 공기와 접촉한 것은 정확히 한시간만에 녹아 없어짐

public class G4치즈_2638 {
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static ArrayList<Node> cheese;
    static int R, C, cheeseCount;    
    static boolean[][] map, isVisited, airCheck;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        isVisited = new boolean[R][C];
        airCheck = new boolean[R][C];
        cheeseCount = 0;
        cheese = new ArrayList<>();

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int input = Integer.parseInt(st.nextToken());
                if(input==1){
                    map[i][j] = true;
                    cheese.add(new Node(i, j));
                    cheeseCount++;
                }
            }
        }
        int time = 0;
        checkAir(0,0);
        while(true){
            if(cheeseCount==0) break;
            time++;
            checkCheese();            
        }
        bw.write(""+time);
        bw.flush();
    }
    private static void checkAir(int r, int c){    // 처음 공기가 통하는 지점 airCheck true로 변경 -> 치즈 상하좌우만 탐색해서 airCheck가 true면 공기가 통함
        if(isVisited[r][c]) return;
        Queue<Node> q = new LinkedList<>();        
        isVisited[r][c] = true;
        airCheck[r][c] = true;

        q.add(new Node(r,c));
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(isVisited[nr][nc]||map[nr][nc]) continue;
                isVisited[nr][nc] = true;
                airCheck[nr][nc] = true;
                q.add(new Node(nr,nc));
            }
        }
    }
    private static void checkCheese() { // 치즈 상하좌우 탐색해서 2칸 이상  공기가 통하면 녹여준다.
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<cheese.size(); i++){
            Node node = cheese.get(i);
            int result =0;
            for(int d=0; d<4; d++){
                int nr = node.r+dx[d];
                int nc = node.c+dy[d];
                if(airCheck[nr][nc]){
                    result++;
                }
            }
            if(result>=2){
                map[node.r][node.c] = false;
                cheeseCount--;
                cheese.remove(i);
                i--;
                q.add(new Node(node.r, node.c));                
            }                          
        }
        while(!q.isEmpty()){    // 녹은 치즈 좌표들을 공기 BFS 탐색한다. (DFS 해도 상관 없다.)
            Node node = q.poll();
            checkAir(node.r,node.c);
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
// https://www.acmicpc.net/submit/2638

// Cheese 리스트를 LinkedList로 선언하면 시간초과 난다..... 삭제 할 때는 LinkedList가 빠른 줄 알았는데... 검색하는 부분때문에 ArrayList로 해야만 시간초과 안난다. 이거 때문에 1시간 걸림