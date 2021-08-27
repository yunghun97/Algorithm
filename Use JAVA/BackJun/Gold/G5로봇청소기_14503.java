package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5로봇청소기_14503 { // 0 북 1 동 2 남 3 서    // 청소한거 -1로 표시
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    static int[] backX = {1,0,-1,0}, backY = {0,-1,0,1};    // 뒤로 갈 좌표
    static int[][] map;
    static int answer;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G5로봇청소기_14503.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        st = new StringTokenizer(br.readLine());
        int clearR = Integer.parseInt(st.nextToken());
        int clearC = Integer.parseInt(st.nextToken());
        int clearDir = Integer.parseInt(st.nextToken());
        answer = 1;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        map[clearR][clearC]=-1; // 시작위치 청소하기
        move(clearR,clearC,clearDir);
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void move(int clearR, int clearC, int clearDir) {
        int r = clearR; int c = clearC; int dir = clearDir;
        boolean noFind = false;
        while(true){
            for(int d=0; d<4; d++){ // 4번 확인하므로 4번 -> 왼쪽 돌면서 시작하므로 마지막 시작방향으로 돌아온다. 북 시작 -> 서->님->동->북
                dir+=3;
                int nr = r+dx[dir%=4];
                int nc = c+dy[dir%=4];
                if(map[nr][nc]==0){ // 청소할 곳 찾으면 청소하고 좌표 바꾸기
                    map[nr][nc] = -1;
                    answer++;
                    r = nr; c = nc;
                    noFind = false;
                    break;  //처음으로 돌아간다.
                }else if(map[nr][nc]==1||map[nr][nc]==-1){      // 벽이거나 청소시 탐색
                    noFind = true;
                    continue;
                }
            }
            if(noFind){     // noFInd가 true라는 것은 결국 4방향 모두 없다는 뜻으로 뒤로 이동한다.
                int nr = r+backX[dir];
                int nc = c+backY[dir];
                if(map[nr][nc]==1) return;  // 뒤 좌표가 벽이면 break;
                r = nr;
                c = nc;
            }

        }

    }
}

