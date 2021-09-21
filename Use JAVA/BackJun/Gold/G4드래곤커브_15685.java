package BackJun.Gold;

import java.io.*;
import java.util.*;

// 방향 0 오른쪽 1 위로 2 왼쪽 3 아래로
// 계산법 각 좌표 방향 마지막 부터 읽어서 90회전
// 위 -> 좌
// 좌 -> 아래
// 아래 -> 우
// 우 -> 위
// 0 세대 -> 10세대 1,2,4,8,16,32,64,128,256,512,1024
// x 좌표 열, y 좌표 행
public class G4드래곤커브_15685 {
    static boolean[][] map;
    static int[] dx = {0,-1,0,1}, dy = {1,0,-1,0};
    static int[] generation, dirArr;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        map = new boolean[101][101];
        generation = new int[]{1,2,4,8,16,32,64,128,256,512,1024};
        dirArr = new int[1024];
        int size = Integer.parseInt(br.readLine());
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            move(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        answer = 0;
        checkSquare();
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void checkSquare() { // 사각형 체크

        for(int r=0; r<100; r++){   // 100칸까지이므로 99까지만 해서 열,행+1해서 체크하면 됨
            for(int c=0; c<100; c++){
                if(map[r][c]&&map[r+1][c]&&map[r][c+1]&&map[r+1][c+1]) answer++;
            }
        }

    }
    private static void move(int y, int x, int dir, int gener) {    // 드래곤 커브 체크
        map[x][y] = true;
        int nx = x;
        int ny = y;
        if(gener<2){
            for(int i=0; i<generation[gener]; i++){
                nx += dx[dir];
                ny += dy[dir];
                map[nx][ny] = true;
                dir = (dir+1)%4;
            }
        }else{  // 2 이상일 때
            int temp = 1;
            for(int i=0; i<generation[temp]; i++){  // 기본 1단계 만들기
                nx += dx[dir];
                ny += dy[dir];
                dirArr[i] = dir;
                map[nx][ny] = true;
                dir = (dir+1)%4;
            }
            while(temp<=gener-1){   // 2단계, 3단계, N 단계가 될 때까지
                int index = 1;
                for(int i=generation[temp];i<generation[temp+1]; i++){  // n 단계
                    dir = (dirArr[generation[temp]-(index++)]+1)%4;
                    nx += dx[dir];
                    ny += dy[dir];
                    dirArr[i] = dir;
                    map[nx][ny] = true;
                }
                temp++;
            }
        }
    }
}
//https://www.acmicpc.net/problem/15685