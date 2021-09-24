package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4미세먼지안녕_17144 {
    static int[][] map;
    static int R,C,T;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static Cleaner[] cleaners;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        cleaners = new Cleaner[2];
        map = new int[R][C];
        int index=0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==-1) cleaners[index++] = new Cleaner(i, j);
                map[i][j] = a;
            }
        }

        for(int i=0; i<T; i++){
            dustSpread();
            startClean();
        }
        int answer = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]>0) answer +=map[r][c];
            }
        }
        bw.write(""+answer);
        bw.flush();
        br.close();
        bw.close();
    }    
    private static void startClean() {  // 공기청정기 작동 메소드
        Cleaner cleaner = cleaners[0];  // 위 공기청정기 좌표
        int nr = cleaner.r;
        int nc = cleaner.c+1;
        int temp = map[nr][nc];
        map[nr][nc]=0;
        dx = new int[]{0,-1,0,1}; dy = new int[]{1,0,-1,0};
        for(int d=0; d<4; d++){
            while(true){
                nr +=dx[d];
                nc +=dy[d];
                if(nr>=R||nr<0||nc>=C||nc<0){
                    nr-=dx[d];
                    nc-=dy[d];
                    break;
                }
                if(map[nr][nc]==-1) break;
                int temp2 = map[nr][nc];
                map[nr][nc] = temp;
                temp = temp2;
            }
        }

        cleaner = cleaners[1];  // 아래 공기청정기 좌표
        nr = cleaner.r;
        nc = cleaner.c+1;
        temp = map[nr][nc];
        map[nr][nc]=0;
        dx = new int[]{0,1,0,-1}; dy = new int[]{1,0,-1,0};
        for(int d=0; d<4; d++){
            while(true){
                nr +=dx[d];
                nc +=dy[d];
                if(nr>=R||nr<0||nc>=C||nc<0){
                    nr-=dx[d];
                    nc-=dy[d];
                    break;
                }
                if(map[nr][nc]==-1) break;  
                int temp2 = map[nr][nc];
                map[nr][nc] = temp;
                temp = temp2;
            }
        }
    }
    private static void dustSpread() {  // 먼지 확인
        int[][] tempMap = new int[R][C];
        tempMap[cleaners[0].r][cleaners[0].c] = -1;
        tempMap[cleaners[1].r][cleaners[1].c] = -1;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]>0){
                   if(map[r][c]>0&&map[r][c]<5) tempMap[r][c] += map[r][c];    // 0초과 5미만이면 기존 먼지 할당
                   
                   else{   // 5이상일 때만 확산 진행
                    int count = 0;
                    for(int d=0; d<4; d++){
                        int nr = r+dx[d];
                        int nc = c+dy[d];
                        if(nr<0||nr>=R||nc<0||nc>=C){
                            continue;
                        }
                        if(map[nr][nc]==-1) continue;
                        count++;
                    }
                    if(count==0) continue;
                    int spread = map[r][c]/5;
                    int now = map[r][c] - (map[r][c]/5*count);
                    for(int d=0; d<4; d++){
                        int nr = r+dx[d];
                        int nc = c+dy[d];
                        if(nr<0||nr>=R||nc<0||nc>=C){
                            continue;
                        }
                        if(map[nr][nc]==-1) continue;
                        tempMap[nr][nc] += spread;
                    }
                    tempMap[r][c] +=now;
                    }
                }
            }
        }
        map = tempMap;
    }
    static class Cleaner{
        int r;
        int c;
        public Cleaner(int r, int c){
            this.r = r;
            this.c = c;
        }
        @Override
        public String toString() {
            return "Cleaner [r=" + r + ", c=" + c + "]";
        }
        
    }
}
//https://www.acmicpc.net/problem/17144