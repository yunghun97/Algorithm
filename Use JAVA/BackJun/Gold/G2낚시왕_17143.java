package BackJun.Gold;

import java.io.*;
import java.util.*;


// 1 위 2 아래 3 오른쪽 4 왼쪽

// 상어 r, c 속력, 방향, 크기
// 크기 큰 상어가 다 먹음

public class G2낚시왕_17143 {
    static int R,C,Count,answer;
    static ArrayList<Integer> map[][];
    static int[] dx ={0,-1,1,0,0}, dy ={0,0,0,1,-1};
    static ArrayList<Shark> list;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Count = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        map = new ArrayList[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        
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
            list.add(new Shark(r, c,speed,dir,size,false));
            map[r][c].add(i);
        }
        for(int i=0; i<C; i++){
            fishing(i); // 상어 잡기
            move(); // 상어 움직이기
            checkShark();   // 상어 중복이면 제거하기
        }
        bw.write(""+answer);
        bw.flush();
    }    
    private static void checkShark() {
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c].size()>=2){
                    int max = 0;
                    for(int i=0; i<map[r][c].size(); i++){  // size 2이상 일 때만
                        max = Math.max(list.get(map[r][c].get(i)).size,max);    // 상어의 최대 크기를 구한다.
                    }
                    for(int i=0; i<map[r][c].size(); i++){  // 최대 크기가 아닌것 죽은상태로 체크 후 제거
                        if(list.get(map[r][c].get(i)).size!=max){
                            list.get(map[r][c].get(i)).dead = true;
                            map[r][c].remove(i);
                            i--;    // 제거했으므로 --해준다.
                        }
                    }
                }
            }
        }
    }
    private static void move() {    // 상어 움직이기
        for(int i=0; i<list.size(); i++){
            if(list.get(i).dead) continue;  // 죽은 것은 이동 x
            Shark shark = list.get(i);
            int r = shark.r;
            int c = shark.c;
            for(int s=0; s<shark.speed; s++){
                if(r+dx[shark.dir]<0||r+dx[shark.dir]>=R||c+dy[shark.dir]<0||c+dy[shark.dir]>=C){   // 돌기 전에 바로 앞이 벽인지 체크 후 방향 전환 미리하기
                    if(shark.dir==1) shark.dir=2;
                    else if(shark.dir==2) shark.dir=1;
                    else if(shark.dir==3) shark.dir=4;
                    else shark.dir = 3;
                }
                r += dx[shark.dir];
                c += dy[shark.dir];
            }
            for(int x=0; x<map[shark.r][shark.c].size(); x++){  // 움직이기 전 기존 map에서 해당 상어 제거
                if(map[shark.r][shark.c].get(x)==i){
                    map[shark.r][shark.c].remove(x);
                    break;
                }
            }
            shark.r = r;  // 해당 상어 좌표 새로 저장
            shark.c = c;
            map[r][c].add(i);   // 맵에 이동완료 한 상어 넣기
        }
    }

    private static void fishing(int c) {    // 낚시 -> 열에 없으면 낚시 x
        for(int r=0; r<R; r++){
            if(!map[r][c].isEmpty()){    // 낚고 answer++ 후 dead상태 체크 및 map에서 제거
                answer += list.get(map[r][c].get(0)).size;
                list.get(map[r][c].get(0)).dead = true;
                map[r][c].remove(0);
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
        boolean dead;
        public Shark(int r, int c, int speed, int dir, int size, boolean dead) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
            this.dead = dead;
        }
    }
}
//https://www.acmicpc.net/problem/17143