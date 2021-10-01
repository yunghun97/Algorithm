package BackJun.Gold;

import java.io.*;
import java.util.*;

// 합쳐지는 파이어볼 방향이 모두 홀수 or 짝수면 방향 0,2,4,6 아니면 1,3,5,7
public class G5마법사상어와파이어볼_20056 {
    static int N,M,K;
    static ArrayList<FireBall> map[][];    // 2차원 배열에 ArrayList선언
    static int[] dx ={-1,-1,0,1,1,1,0,-1}, dy = {0,1,1,1,0,-1,-1,-1};
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayList[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int mass = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            map[r][c].add(new FireBall(mass, speed, dir));
        }

        for(int i=0; i<K; i++){
            move(); // 움직이기
            splitCheck();   // 파이어볼 분리시키기
        }
        long answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()>=1){
                    for(FireBall fireBall : map[i][j]) answer += fireBall.mass;
                }
            }
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    @SuppressWarnings("unchecked")
    private static void move() {    // 파이어볼 이동 메소드
        ArrayList<FireBall> tempMap[][] = new ArrayList[N][N];  // 파이어볼 이동시킨 임시 2차원 배열
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                tempMap[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()>=1){    // 현재 좌표에 파이어볼 존재 시
                    for(FireBall fireBall : map[i][j]){
                        int dis = fireBall.speed%N; // ex 거리 10은 N이 4일 때 2와 똑같으므로 N으로 나누어 준다.
                        int nr = i +dx[fireBall.dir]*dis;  
                        int nc = j +dy[fireBall.dir]*dis;
                        if(nr>=N) nr-=N;    // N 초과 시 -N
                        else if(nr<0) nr+=N;    // 0 미만일 시 +N
                        if(nc>=N) nc-=N;
                        else if(nc<0) nc+=N;
                        tempMap[nr][nc].add(new FireBall(fireBall.mass, fireBall.speed, fireBall.dir)); // 이동된 좌표 tempMap에 저장
                    }
                }
            }
        }
        map = tempMap; // map을 이동시킨 tempMap으로 바꿔준다.
    }
    private static void splitCheck() {  // 파이어볼 분리 메소드
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()>=2){    // 한 좌표에 2개 이상일 때
                    int massSum = 0;
                    int speedSum = 0;
                    boolean evenCheck = true, oddCheck = true;
                    for(FireBall fireBall : map[i][j]){
                        massSum +=fireBall.mass;
                        speedSum += fireBall.speed;
                        if(fireBall.dir%2==0) evenCheck = false;    // 해당 좌표가 짝수면 false
                        else oddCheck = false;  // 해당 좌표가 홀수면 false
                    }
                    int mass = massSum/5;   
                    int speed = speedSum/map[i][j].size();
                    map[i][j].clear();  // 현재 좌표에있는 파이어볼 초기화
                    if(mass<=0) continue;   // 질량이 0이면 파이어볼 추가 X
                    else{
                        if(evenCheck||oddCheck){    // 둘 중 하나가 true일 때 -> 둘 다 true는 불가능
                            for(int d=0; d<4; d++){
                                map[i][j].add(new FireBall(mass, speed, 0+2*d));    // 0,2,4,6 방향 넣기
                            }    
                        }else{  // 홀수 짝수 둘 다 일 때
                            for(int d=0; d<4; d++){
                                map[i][j].add(new FireBall(mass, speed, 1+2*d));    // 1,3,5,7 방향 넣기
                            }
                        }
                    }
                }
            }
        }
    }

    static class FireBall{
        int mass;
        int speed;
        int dir;
        public FireBall(int mass, int speed, int dir) {
            this.mass = mass;
            this.speed = speed;
            this.dir = dir;
        }
    }
}
//https://www.acmicpc.net/problem/20056