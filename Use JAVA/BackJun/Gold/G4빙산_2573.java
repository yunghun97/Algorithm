package BackJun.Gold;
import java.io.*;
import java.util.*;
public class G4빙산_2573 {
    static int[][] map,tempMap;
    static int answer,R,C;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        answer = 0;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        tempMap = new int[R][C];
        isVisited = new boolean[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            for(int i=0; i<R; i++){ // 방문 배열 초기화
                Arrays.fill(isVisited[i], false);
            }
            int count = 0;
             for(int i=0; i<R; i++){    // 빙산 개수 세기
                for(int j=0; j<C; j++){
                    if(isVisited[i][j]||map[i][j]==0) continue;
                        isVisited[i][j] = true;
                        check(i,j); // 방문하지 않았고 0이 아닌 좌표 dfs 탐색
                        count++;
                }
            }
            if(count>=2) break; // 2개 이상이면 break;
            if(count==0){   // 0개면 동시에 다 녹으므로 answer = 0 하고 break;
                answer = 0;
                break;
            }
            for(int i=0; i<R; i++){ // 방문 배열 초기화
                Arrays.fill(isVisited[i], false);
            }
            for(int x = 0; x< R; x++){  // tempMap에 map을 저장
                System.arraycopy(map[x], 0, tempMap[x], 0, C);
            }
            outer : for(int i=0; i<R; i++){
                for(int j=0; j<C; j++){
                    if(map[i][j]==0) continue;  // 여기는 빙하가 다 뭉쳐있으므로 dfs한번이면 가능
                    isVisited[i][j] = true;
                    melt(i,j);
                    break outer;
                }
            }
            for(int x = 0; x< R; x++){  // map에 tempMap에 있는 데이터를 저장
                System.arraycopy(tempMap[x], 0, map[x], 0, C);
            }
            answer++;
        }
        bw.write(""+answer);
        bw.flush();
    }

    private static void melt(int r, int c) {    // 녹이기
        int zeroCount = 0;
        for(int d=0; d<4; d++){ // 좌표 주위 0 개수 구하기
            int nr = r +dx[d];
            int nc = c +dy[d];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(map[nr][nc]==0) zeroCount++;
        }
        tempMap[r][c] -= zeroCount; // tempMap에 저장
        if(tempMap[r][c]<0) tempMap[r][c] = 0;  // -면 0으로 바꾸기
        for(int d=0; d<4; d++){
            int nr = r +dx[d];
            int nc = c +dy[d];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(map[nr][nc]==0|| isVisited[nr][nc]) continue;    // tempMap은 값이 변경되므로 map기준으로 주위빙하 탐색 후 녹은 결과는 tempMap 저장 후 맨 마지막에 map에 저장
            isVisited[nr][nc] = true;
            melt(nr,nc);
        }
    }

    private static void check(int r, int c) {   // 주위 연결된 빙하 방문표시하기
        for(int d=0; d<4; d++){
            int nr = r +dx[d];
            int nc = c +dy[d];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(map[nr][nc]==0||isVisited[nr][nc]) continue;
            isVisited[nr][nc] = true;
            check(nr, nc);
        }
    }    
}
//https://www.acmicpc.net/problem/2573