package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

public class 디저트카페_2105 {
    static int N, answer;
    static int[] dx = { 1, 1, -1, -1 }, dy = { 1, -1, -1, 1 };
    static int[][] map;    
    static HashMap<Integer, Boolean> hmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        hmap = new HashMap<>(); // 방문한 디저트 가게 번호를 저장하기 위한 해쉬맵

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == N - 1 || j == N - 1) continue;

                    hmap.clear();
                    move(i, j, 0, i, j, 0);
                }
            }
            if(answer==0) answer = -1;
            bw.write("#"+t+" "+answer+"\n");
        } // 테케 끝
        bw.flush();
    }

    private static void move(int r, int c, int dir, int startR, int startC, int count) {        
        if(r==startR&&c==startC&&count>=4){ // 다시 원점으로 돌아온 경우
            answer = Math.max(answer, count);
            return;
        }
        if(dir==4) return;
        int nr = r;
        int nc = c;        
        nr += dx[dir];
        nc += dy[dir];

        if (outCheck(nr, nc)) { // 벽 밖으로 나가면
            return;
        }else{
            if(!hmap.getOrDefault(map[nr][nc], false)){ // hashMap에 해당 값이 없는 경우
                hmap.put(map[nr][nc], true);
                move(nr, nc, dir+1,startR, startC, count+1);    // 한칸 움직인 상태로 바로 방향전환
                hmap.remove(map[nr][nc]);   // 해당 좌표 끝까지 갔다 온거므로 return 해서 방문해제

                hmap.put(map[nr][nc], true); // 현재 위치 좌표도 remove 했으므로 다시 현재 위치 좌표 추가
                move(nr, nc, dir, startR, startC, count+1); // 해당 방향으로 더 가기
                hmap.remove(map[nr][nc]); // 마찬가지로 remove
            }else{ // 해당 키 값이 이미 존재하는 경우
                return;
            }
        }

    }

    private static boolean outCheck(int r, int c) {
        if(r < 0 || r >= N || c < 0 || c >= N) return true;
        return false;
    }

}

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu&