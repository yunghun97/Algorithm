package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1현수막_14716 {
    static int R, C, answer;
    static int[][] map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        answer = 0;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cal();
        bw.write(""+answer);
        bw.flush();
    }
    private static void cal() {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]==1){
                    answer++;
                    map[i][j] = 0;
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i, j));
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        for(int d=0; d<8; d++){
                            int nr = node.r + dx[d];
                            int nc = node.c + dy[d];
                            if(outCheck(nr, nc)||map[nr][nc]==0) continue;
                            map[nr][nc] = 0;
                            q.add(new Node(nr, nc));
                        }
                    }
                }
            }
        }
    }
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
// https://www.acmicpc.net/problem/14716