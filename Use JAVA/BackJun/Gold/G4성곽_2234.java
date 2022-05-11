package BackJun.Gold;

import java.io.*;
import java.util.*;
// 1 서 2 북 4 동 8 남
public class G4성곽_2234 {
    static int R,C,roomCount, normalSize, crashSize;
    static int[][] map, kindMap;
    static ArrayList<Integer> roomList;
    static boolean[][] isVisited;
    static boolean[][][] wallMap;
    static int[] dx = {0,-1,0,1}, dy = {-1,0,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        kindMap = new int[R][C];
        isVisited = new boolean[R][C];
        roomList = new ArrayList<>();
        wallMap = new boolean[4][R][C];        
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        setWall(); // 벽 세팅
        roomCount = 0;
        normalSize = 0;
        crashSize = 0;
        calNormal();  
        calCrash();    
        bw.write(""+roomCount+"\n"+normalSize+"\n"+crashSize);
        bw.flush();  
        
    }
    private static void calCrash() {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                for(int d=0; d<4; d++){
                    int nr = i+dx[d];
                    int nc = j+dy[d];
                    if(outCheck(nr, nc)) continue;
                    if(wallMap[d][i][j]){ // 벽이 있는 경우
                        if(kindMap[i][j]!=kindMap[nr][nc]){ // 벽 너머 칸이 다른 종류의 방일 때
                            int result = roomList.get(kindMap[i][j]) + roomList.get(kindMap[nr][nc]);
                            crashSize = Math.max(crashSize, result);
                        }
                    }
                }                
            }
        }
    }
    private static void setWall() {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]==0) continue; // 0이면 벽이 없음
                else{
                    int now = 0;
                    for(int x=3; x>=0; x--){
                        if(now+(1<<x)<=map[i][j]){ // 8,4,2,1로 해서 더 크면 해당 방향에 벽이 있음
                            now += (1<<x);
                            wallMap[x][i][j] = true;
                        }
                    }
                }
            }
        }
    }
    private static void calNormal() {
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(isVisited[i][j]) continue;
                else{
                    int size = 0;
                    q.add(new Node(i, j));
                    isVisited[i][j] = true;
                    roomCount++;
                    while(!q.isEmpty()){
                        size++;
                        Node node = q.poll();
                        kindMap[node.r][node.c] = roomCount-1;
                        for(int d=0; d<4; d++){
                            int nr = node.r + dx[d];
                            int nc = node.c + dy[d];
                            if(outCheck(nr, nc)||wallMap[d][node.r][node.c]||isVisited[nr][nc]) continue;
                            isVisited[nr][nc] = true;
                            q.add(new Node(nr, nc));
                        }
                    }
                    roomList.add(size);
                    normalSize = Math.max(normalSize, size);
                }   
            }
        }
        
    }
    // 범위 밖이면 true 
    static boolean outCheck(int r, int c){
        if(r<0||r>=R||c<0||c>=C) return true;
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
// https://www.acmicpc.net/problem/2234