package SamSungSwExpert.모의역랑테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 등산로조성 {
    static int N, K, answer;    
    static int[][] map;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static ArrayList<Node> list;
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            isVisited = new boolean[N][N];
            list = new ArrayList<>();
            int max =0;
            answer = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max,map[i][j]);
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==max) list.add(new Node(i, j));
                }
            }
            for(int i=0; i<list.size(); i++){   // 봉우리 개수만 큼
                Node node = list.get(i);
                isVisited[node.r][node.c] = true;
                move(node.r, node.c, map[node.r][node.c], 1, false);
                isVisited[node.r][node.c] = false;
            }
            bw.write("#"+t+" "+answer);
            if(t!=T) bw.newLine();
        } // 테케 끝
        bw.flush();
    }
    private static void move(int r, int c, int preNum, int len, boolean useDrill) {
        answer = Math.max(answer, len);
        for(int d=0; d<4; d++){ // 상하좌우 이동
            int nr = r+dx[d];
            int nc = c+dy[d];
            if(outCheck(nr,nc)||isVisited[nr][nc]) continue; // 벽 밖, 이미 이동한 좌표는 바로 continue;
            if(map[nr][nc]>=preNum){ // 해당 봉우리가 더 큰 경우
                if(useDrill) continue; // 이미 드릴을 사용했으면 continue;
                else{
                    for(int i=1; i<=K; i++){ // 드릴을 1부터 K까지 뚫을 수 있으므로 모두 반영
                        if(map[nr][nc]-i<preNum){
                            isVisited[nr][nc] = true;                
                            move(nr, nc, map[nr][nc]-i, len+1,true);
                            isVisited[nr][nc] = false;
                        }                        
                    }
                }
            }else{ // 이동할 봉우리가 더 작아서 바로 이동할 수 있는 경우
                isVisited[nr][nc] = true;
                move(nr, nc, map[nr][nc], len+1, useDrill);
                isVisited[nr][nc] = false;
            }            
        }
    }
    private static boolean outCheck(int r, int c){
        if(r<0||r>=N||c<0||c>=N) return true;
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
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PoOKKAPIDFAUq