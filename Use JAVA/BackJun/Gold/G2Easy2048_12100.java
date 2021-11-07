package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2Easy2048_12100 {
    static int[][] defaultMap;
    static int N, answer;

    // 5번 이동해서 만드는 최대 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        defaultMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                defaultMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        for (int d = 0; d < 4; d++) {
            dfs(0, d, defaultMap);
        }
        bw.write(""+answer);
        bw.flush();
    }

    private static void dfs(int cnt, int dir, int[][] newMap) {     // 숫자 더해주기
        if (cnt == 5) {
            max(newMap);
            return;

        }
        // 위
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(newMap[i], 0, map[i], 0, N);
        }
        if (dir == 0) {
            for (int c = 0; c < N; c++) {
                for (int r = 0; r < N; r++) {
                    if (map[r][c] == 0) continue;
                    for (int x = r + 1; x < N; x++) {   // 위에칸과 아래칸 비교
                        if (map[r][c] == map[x][c]) {
                            map[x][c] = 0;
                            map[r][c] *= 2;
                            r = x;
                            break;
                        }else if(map[x][c]==0) continue;
                        else break;
                    }
                }
            }
            move(dir, map);
        }
        // 오른쪽
        else if (dir == 1) {
            for (int r = 0; r < N; r++) {
                for (int c = N - 1; c >= 0; c--) {
                    if (map[r][c] == 0) continue;
                    for (int y = c - 1; y >= 0; y--) {  // 오른쪽 기준칸과 왼쪽 탐색하면서 +해주기
                        if (map[r][c] == map[r][y]) {
                            map[r][c] *= 2;
                            map[r][y] = 0;
                            c = y;
                            break;
                        } else if(map[r][y]==0) continue;
                        else break;                    
                    }
                }
            }
            move(dir, map);
        }
        // 아래
        else if (dir == 2) {
            for(int c=0; c<N; c++){
                for(int r=N-1;  r>=0; r--){
                    if(map[r][c]==0) continue;
                    for(int x=r-1; x>=0; x--){  // 아래 기준칸과 위에칸 탐색하면서 + 해주기
                        if(map[r][c] == map[x][c]){
                            map[r][c] *=2;
                            map[x][c] =0;
                            r = x;
                            break;
                        }else if(map[x][c]==0) continue;
                        else break;
                    }
                }
            }
            move(dir, map);
        }
        // 왼쪽
        else {
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(map[r][c]==0) continue;
                    for(int y=c+1; y<N; y++){
                        if(map[r][c]==map[r][y]){   // 왼쪽 기준칸과 오른쪽 탐색하면서 비교
                            map[r][c] *= 2;
                            map[r][y] =0;
                            c = y;
                            break;
                        }else if(map[r][y]==0) continue;
                        else break;
                    }
                }
            }
            move(dir, map);
        }
        for (int d = 0; d < 4; d++) {
            dfs(cnt + 1, d, map);
        }
    }

    private static void move(int dir, int[][] map) {    // 벽으로 이동하기
        // 0 위로 1 오른쪽 2 아래 3 왼쪽으로 이동
        if (dir == 0) { // 위로
            for (int c = 0; c < N; c++) {
                for (int r = 1; r < N; r++) {
                    int nr = r - 1;
                    int now = r;
                    while (true) {
                        if (map[now][c] != 0 && map[nr][c] == 0) {  // 위에칸 탐색하면서 이동
                            map[nr][c] = map[now][c];
                            map[now][c] = 0;
                            now--;
                            nr--;
                        } else {
                            break;
                        }
                        if (now == 0) {
                            break;
                        }
                    }
                }
            }
        } else if (dir == 1) {  // 오른쪽
            for (int r = 0; r < N; r++) {
                for (int c = N - 2; c >= 0; c--) {
                    int nc = c + 1;
                    int now = c;
                    while (true) {
                        if (map[r][now] != 0 && map[r][nc] == 0) {  // 오른쪽칸 탐색하면서 이동
                            map[r][nc] = map[r][now];
                            map[r][now] = 0;
                            now++;
                            nc++;
                        } else {
                            break;
                        }
                        if (now == N - 1)
                            break;
                    }
                }
            }
        } else if (dir == 2) {  // 아래
            for(int c=0; c<N; c++){
                for(int r=N-2; r>=0; r--){
                    int now = r;
                    int nr = r+1;
                    while(true){
                        if(map[now][c] !=0 && map[nr][c]==0){   // 아래칸 탐색하면서 이동
                            map[nr][c] = map[now][c];
                            map[now][c] = 0;
                            now++;
                            nr++;
                        }else{
                            break;
                        }
                        if(now==N-1) break;
                    }
                }
            }
        } else {    // 왼쪽
            for(int r=0; r<N; r++){
                for(int c=1; c<N; c++){
                    int now = c;
                    int nc = c-1;
                    while(true){
                        if(map[r][now]!=0 && map[r][nc]==0){    // 왼쪽칸 탐색하면서 이동
                            map[r][nc] = map[r][now];
                            map[r][now] =0;
                            now--;
                            nc--;
                        }else{
                            break;
                        }
                        if(now==0) break;
                    }
                }
            }
        }
    }

    private static void max(int[][] newMap) {   // 최대값 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, newMap[i][j]);
            }
        }

    }
}
// https://www.acmicpc.net/status?user_id=yunghun97&problem_id=12100&from_mine=1