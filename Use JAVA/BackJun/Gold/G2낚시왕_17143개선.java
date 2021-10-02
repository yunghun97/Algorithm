package BackJun.Gold;

import java.io.*;
import java.util.*;


// 1 위 2 아래 3 오른쪽 4 왼쪽

// 상어 r, c 속력, 방향, 크기
// 크기 큰 상어가 다 먹음
public class G2낚시왕_17143개선 {
    static int R,C,Count,answer;
    static Shark[][] map;
    static int[] dx ={0,-1,1,0,0}, dy ={0,0,0,1,-1};
    static ArrayList<Shark> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Count = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new Shark[R][C];

        for(int i=0; i<Count; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1; // 0번지 부터 시작하므로 -1
            int c = Integer.parseInt(st.nextToken())-1;
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            // 행 크기 5라 가정 -> 왕복 후 제자리로 돌아오는 경우는 speed가 8 일때 발생한다.
            // 따라서 speed가 8의 배수면 제자리로 돌아옴
            // -> speed % (자신의 크기*2-2)를 speed로 재설정 시간절약
            if(dir==1||dir==2){ // 행간 이동        
                speed = speed%(2*R-2);
            }else{ // 열간 이동
                speed = speed%(2*C-2);
            }
            list.add(new Shark(r, c,speed,dir,size));
            map[r][c] = list.get(i);
        }
        for(int i=0; i<C; i++){
            fishing(i); // 상어 잡기
            move(); // 상어 움직이기
            removeShark();  // 상어 제거
       
        }
        bw.write(""+answer);
        bw.flush();
    }    
    private static void removeShark() {
        map = new Shark[R][C];
        for(int i = 0; i < list.size(); i++){
            Shark shark = list.get(i);
            if(map[shark.r][shark.c]==null){
                map[shark.r][shark.c] = shark;
            }else{
                if(map[shark.r][shark.c].size>shark.size){
                    list.remove(shark);
                    i--;
                }else{
                    list.remove(map[shark.r][shark.c]);
                    map[shark.r][shark.c] = shark;
                    i--;
                }
            }
        }
    }
    private static void move() {    // 상어 움직이기
        for(int i=0; i<list.size(); i++){
            Shark shark = list.get(i);
            int r = shark.r;
            int c = shark.c;
        
            for (int s = 0; s < shark.speed; s++) {
                if(r+dx[shark.dir]<0||r+dx[shark.dir]>=R||c+dy[shark.dir]<0||c+dy[shark.dir]>=C){   // 돌기 전에 바로 앞이 벽인지 체크 후 방향 전환 미리하기
                    if(shark.dir == 1) shark.dir = 2;
                    else if(shark.dir == 2) shark.dir = 1;
                    else if(shark.dir == 3) shark.dir = 4;
                    else shark.dir = 3;
                }
                r += dx[shark.dir];
                c += dy[shark.dir];
            }
            shark.r = r;  // 해당 상어 좌표 새로 저장
            shark.c = c;

        }
    }

    private static void fishing(int c) {    // 낚시 -> 열에 없으면 낚시 x
        for(int r=0; r<R; r++){
            if(map[r][c]!=null){    // 낚고 answer++ 후 dead상태 체크 및 null로 만들기
                answer += map[r][c].size;
                list.remove(map[r][c]);
                break;
            }
        }
    }
    static class Shark{
        int r;
        int c;
        int speed;
        int dir;
        int size;
        public Shark(int r, int c, int speed, int dir, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }
}
