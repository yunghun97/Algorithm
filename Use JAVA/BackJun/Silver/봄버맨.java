package BackJun.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;;
public class 봄버맨 {
    static int R,C, N;
    static char[][] map;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static Queue<Node> q;
    static BufferedWriter bw ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        q = new LinkedList<>();
        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                char a = input.charAt(j);
                if(a=='O'){
                    q.add(new Node(i,j));
                }
                map[i][j] = a;
            }
        }
        int time = N%4;
    while(true){
        if(N==1){
            printMap();
            break;
        }
        fill();
        if(time==0||time==2){            
            printMap();
            break;
        }else{  // 1, 5, 9 같은거 -> 3, 7, 11
            boom();
            if(time==3){
                printMap();
                break;
            }else{
                find();
                fill();
                boom();
                printMap();
                break;
            }
        }
    }
    }
    private static void printMap() throws IOException{
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                bw.write(map[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
    }
    private static void fill() {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = 'O';
            }
        }
    }
    private static void find() {
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='O'){
                    q.add(new Node(i, j));
                }
            }
        }
    }
    private static void boom() {
        while(!q.isEmpty()){
            Node node = q.poll();
            map[node.r][node.c] = '.';
            for(int d=0; d<4; d++){
                int nr = node.r +dx[d];
                int nc = node.c +dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                map[nr][nc] = '.';
            }
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
}
//https://www.acmicpc.net/problem/16918