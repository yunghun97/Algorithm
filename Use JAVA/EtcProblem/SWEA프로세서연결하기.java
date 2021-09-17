package EtcProblem;

import java.io.*;
import java.util.*;
public class SWEA프로세서연결하기 {
    static int[][] map;
    static ArrayList<Processor> pList;  // 프로세서 위치 저장 리스트
    static int N, a1,a2;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            a1 = 0;
            a2 = 9999;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            pList = new ArrayList<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a==1){
                        map[i][j]=1;
                        if(i==0||i==N-1||j==0||j==N-1){ // 가장 자리 프로세서 표시
                            pList.add(new Processor(i,j,true));
                        }else{  
                            pList.add(new Processor(i,j,false));
                        }
                    }
                }
            }   // 맵 입력 끝
            dfs(0,0,0);
            bw.write("#"+t+" "+a2+"\n");
            bw.flush();
        }   // 테케 끝
        bw.close();
        br.close();
    }

    private static void dfs(int cnt, int count, int len) {
        if(pList.size()+count-cnt<a1) return; // 프로세서 개수 + 연결 된 프로세서 - 탐색한 프로세서수 < 최대 연결 된 프로세서 수
        if(cnt==pList.size()){
            if(a1<=count){
                if(a1==count) a2 = Math.min(a2,len);
                else a2 = len;
                a1 = Math.max(a1,count);
                
            }
            return;
        }
        Processor ps = pList.get(cnt);
        if(ps.connect) dfs(cnt+1,count+1,len);  // 이미 가장자리 프로세서면 계산 없이 바로 +1
        else{
        for(int d=0; d<4; d++){
                if(isPossible(ps.r,ps.c,d)){
                    // 전선 만들기
                    dfs(cnt+1,count+1,+len+setWire(ps.r,ps.c,d,1));
                    // 전선 다시 돌려주기
                    setWire(ps.r,ps.c,d,0);
                }
            }
            // 전선 추가 안 할 때 경우의 수 1번만 해서 올려주기 -> 시간 절약
            dfs(cnt+1,count,len);
        }
    }

    private static int setWire(int r, int c, int dir, int setNum) {
        int count = 0;
        while(true){
            r += dx[dir];
            c += dy[dir];
            if(r<0||r>=N||c<0||c>=N) return count;
            else{
                map[r][c]=setNum;
                count++;
            }
        }
    }

    private static boolean isPossible(int r, int c, int dir) {
        while(true){
            r += dx[dir];
            c += dy[dir];
            if(r<0||r>=N||c<0||c>=N) return true;
            else{
                if(map[r][c]==1) return false;
            }
        }
    }

    static class Processor{
        int r;
        int c;
        boolean connect;
        public Processor(int r, int c, boolean connect) {
            this.r = r;
            this.c = c;
            this.connect = connect;
        }
        @Override
        public String toString() {
            return "Processor [c=" + c + ", connect=" + connect + ", r=" + r + "]";
        }
    }
}
