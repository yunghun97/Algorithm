package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5테트로미노_14500 {
    static ArrayList<Tetris> list;
    static int R, C, answer, temp;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
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

        tetrisSet();
        answer = 0;
        temp = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                cal(i,j);
            }
        }
        bw.write(""+answer);
        
        bw.flush();
        bw.close();
        br.close();
    } 
    private static void cal(int r, int c) {
        for(int i=0; i<list.size(); i++){
            Tetris tetris = list.get(i);
            boolean check = true;
            if(r+tetris.maxR<0||r+tetris.maxR>=R||c+tetris.maxC<0||c+tetris.maxC>=C) continue;  // 계산 최대칸 넘으면 탐색 X 
            temp = 0;
            for(int d=0; d<4; d++){
                int nr = r + tetris.dx[d];
                int nc = c +tetris.dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C){
                    check = false;
                    break;
                }
                temp += map[nr][nc];
            }
            if(check){  // 끝까지 다 돌았을 때만 
                answer = Math.max(answer,temp);
            }
        }

    }
    private static void tetrisSet() {   // 테트리스 모든 경우의 수 list에 집어 넣기
        list = new ArrayList<>();

        //긴거
        list.add(new Tetris(new int[]{0,0,0,0}, new int[]{0,1,2,3}, 0, 3));
        list.add(new Tetris(new int[]{0,1,2,3}, new int[]{0,0,0,0}, 3, 0));

        //네모
        list.add(new Tetris(new int[]{0,0,1,1}, new int[]{0,1,0,1}, 1, 1));

        // 주황색 ㄴ자
        list.add(new Tetris(new int[]{0,1,1,1}, new int[]{0,0,1,2}, 1, 2));
        list.add(new Tetris(new int[]{0,1,1,1}, new int[]{0,0,-1,-2}, 1, -2));

        list.add(new Tetris(new int[]{0,1,2,2}, new int[]{0,0,0,-1}, 2, -1));
        list.add(new Tetris(new int[]{0,1,2,2}, new int[]{0,0,0,1}, 2, 1));

        list.add(new Tetris(new int[]{0,0,0,1}, new int[]{0,1,2,2}, 1, 2));
        list.add(new Tetris(new int[]{0,0,0,1}, new int[]{0,1,2,0}, 1, 2));

        list.add(new Tetris(new int[]{0,0,1,2}, new int[]{0,1,1,1}, 2, 1));
        list.add(new Tetris(new int[]{0,0,1,2}, new int[]{0,1,0,0}, 2, 0));

        // 초록색
        list.add(new Tetris(new int[]{0,1,1,2}, new int[]{0,0,1,1}, 2, 1));
        list.add(new Tetris(new int[]{0,1,1,2}, new int[]{0,0,-1,-1}, 2, -1));

        list.add(new Tetris(new int[]{0,0,1,1}, new int[]{0,1,1,2}, 1, 2));
        list.add(new Tetris(new int[]{0,0,1,1}, new int[]{0,-1,-1,-2}, 1, -2));

        // 보라색 ㅗ
        list.add(new Tetris(new int[]{0,1,1,2}, new int[]{0,0,-1,0}, 2, -1));
        list.add(new Tetris(new int[]{0,1,1,2}, new int[]{0,0,1,0}, 2, 1));

        list.add(new Tetris(new int[]{0,1,1,1}, new int[]{0,-1,0,1}, 0, 0));
        list.add(new Tetris(new int[]{0,0,0,1}, new int[]{0,-1,1,0},0, 0));
    }
    static class Tetris{
        int[] dx;
        int[] dy;
        int maxR;
        int maxC;
        public Tetris(int[] dx, int[] dy, int maxR, int maxC) {
            this.dx = dx;
            this.dy = dy;
            this.maxR = maxR;
            this.maxC = maxC;
        }
        
    }
}
//https://www.acmicpc.net/problem/14500