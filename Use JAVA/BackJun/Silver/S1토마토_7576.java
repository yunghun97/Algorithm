package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1토마토_7576 {
    static int R,C,answer, rareTomato;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Tomato> q;
    static int[] dx = {-1,0,0,1}, dy ={0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isVisited = new boolean[R][C];
        q = new LinkedList<>();
        rareTomato = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1) q.add(new Tomato(i, j));   // 처음부터 익어있는 토마토 좌표 저장
                if(a==0) rareTomato++;  // 안 익은 토마토 개수
                map[i][j] = a;
            }
        }
        answer = 0;
        if(rareTomato>0){   // 안 익은 토마토가 있을 때
            cal();
            if(rareTomato>0) bw.write(""+-1);   // 계산 후 안 익은 토마토가 남아있으면 -1
            else bw.write(""+answer);   // 다 익었으면 answer 출력
        }else{  // 처음부터 다 익은 토마토이면 0
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void cal() {

        while(!q.isEmpty()){
            int qSize = q.size();   // 1일단위로 돌기위해 qSize만큼 for문 반복
            for(int i=0; i<qSize; i++){
                Tomato tomato = q.poll();

                for(int d=0; d<4; d++){
                    int nr = tomato.r + dx[d];
                    int nc = tomato.c + dy[d];
                    if(nr<0||nr>=R||nc<0||nc>=C) continue;
                    if(isVisited[nr][nc]) continue;
                    
                    isVisited[nr][nc] = true;
                    if(map[nr][nc]==0){
                        rareTomato--;
                        q.add(new Tomato(nr, nc));
                    }
                }
            }
            answer++;   // 1일 단위로 돌 때 마다 ++
        }
        answer--;   // 마지막 토마토에서도 확인하므로 +1일 된 상태이므로 -- 해준다.
    }
    static class Tomato{
        int r;
        int c;
        public Tomato(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
//https://www.acmicpc.net/problem/7576