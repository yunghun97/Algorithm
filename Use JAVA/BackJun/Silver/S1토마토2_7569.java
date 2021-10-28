package BackJun.Silver;

import java.io.*;
import java.util.*;

// 0은 안익은 토마토, -1은 벽, 1은 익은 토마토
public class S1토마토2_7569 {
    static int[][][] map;
    static boolean[][][] isVisited;
    static int R, C, H, allTomato, ripeTomato, answer;
    static Queue<Node> q;
    static int[] dx = {-1,0,0,1}, dy={0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st =  new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        allTomato = 0;
        ripeTomato = 0;
        map = new int[H][R][C];
        isVisited = new boolean[H][R][C];
        for(int i=0; i<H; i++){
            for(int j=0; j<R; j++){
                st = new StringTokenizer(br.readLine());
                for(int l=0; l<C; l++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a==0){
                        allTomato++;    // 전체 토마토 개수
                    }
                    else if(a==1){
                        allTomato++;    // 전체 토마토 개수
                        ripeTomato++;   // 익은 토마토 개수
                        q.add(new Node(i,j,l));
                    }
                    map[i][j][l] = a;
                }
            }
        }
        answer = 0;
        if(allTomato==ripeTomato){  // 처음부터 전체 토마토 개수 = 익은 토마토 개수면 0 출력
            bw.write(""+answer);
        }else{
            cal();  // 계산
            if(ripeTomato==allTomato) bw.write(String.valueOf(answer-1));   // 계산 후 전체 토마토 개수 == 익은 토마토 개수면 answer-1출력
            else bw.write(String.valueOf(-1)); // 계산 후 전체 토마토 개수 != 익은 토마토 개수면 -1출력
        }
        bw.flush();
    }
    private static void cal() {
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node node = q.poll();
                if(node.h-1>=0&&map[node.h-1][node.r][node.c]==0&&!isVisited[node.h-1][node.r][node.c]){    // 아래 판자로 이동
                    isVisited[node.h-1][node.r][node.c] = true;
                    map[node.h-1][node.r][node.c] = 1;
                    q.add(new Node(node.h-1, node.r, node.c));
                    ripeTomato++;   // 익은 토마토 개수 추가
                }
                if(node.h+1<H&&map[node.h+1][node.r][node.c]==0&&!isVisited[node.h+1][node.r][node.c]){ // 위에 판자로 이동
                    isVisited[node.h+1][node.r][node.c] = true;
                    map[node.h+1][node.r][node.c] = 1;
                    q.add(new Node(node.h+1, node.r, node.c));
                    ripeTomato++;   // 익은 토마토 개수 추가
                }
                for(int d=0; d<4; d++){
                    int nr = node.r + dx[d];
                    int nc = node.c + dy[d];
                    if(nr<0||nr>=R||nc<0||nc>=C||isVisited[node.h][nr][nc]||map[node.h][nr][nc]!=0) continue;
                    isVisited[node.h][nr][nc] = true;
                    q.add(new Node(node.h, nr, nc));
                    ripeTomato++;
                }
            }
            answer++;   // 마지막 전파확인할 때도 ++이므로 출력 전 -1 연산
        }



    }
    static class Node{
        int h;
        int r;
        int c;
        public Node(int h, int r, int c){
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
}
//https://www.acmicpc.net/problem/7569