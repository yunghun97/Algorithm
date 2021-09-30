package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5인구이동_16234_개선버전 {
    static int N, Low, Max;
    static int[][] map, indexMap;
    static int[][] checkArr;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Low = Integer.parseInt(st.nextToken());
        Max = Integer.parseInt(st.nextToken());
        map = new int[N][N];    // 인구 저장할 배열
        indexMap = new int[N][N];   // 인덱스를 저장하는 배열
        checkArr = new int[N*N][2]; // 인덱스에 해당한 사람 총합, 연합 수 저장용
        isVisited = new boolean[N][N];
        int answer = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());   // 맵에 저장
            }
        }
        while(true){    // 조건에 만족할 때 까지
            int index = 0;
            for(int r=0; r<N; r++){ // 연합 생성 과정
                for(int c=0; c<N; c++){
                    if(isVisited[r][c]) continue;
                    isVisited[r][c]=true;
                    dfs(index++,r,c);   // 방문안한 점별로 다 dfs탐색하면서 한번 할 때마다 index++해준다.
                }
            }
            if(checkArr[N*N-1][1]==1) break;    // 다 연합이 안되는 경우는 (배열 0부터니까) 각 정점별로 사람 수가 모두 1명이므로 N*N-1도 1명이 되면 연합이 불가능한 상태

            for(int r=0; r<N; r++){ // 사람 수 저장 과정
                for(int c=0; c<N; c++){
                    map[r][c] = checkArr[indexMap[r][c]][0]/checkArr[indexMap[r][c]][1];    // 사람수를 해당 맵의 같은 연합 번호를 가진 사람 수 합 / 연합 개수 
                }
            }
            answer++;   // 인구이동 했으니까 +1
            for(int i=0; i<N; i++){ // 사용한 배열 초기화
                Arrays.fill(isVisited[i], false);
                Arrays.fill(indexMap[i], 0);
            }
            for(int i=0; i<N*N; i++){
                Arrays.fill(checkArr[i], 0);
            }
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int index, int r, int c) {
        checkArr[index][0]+=map[r][c];  // 현재 dfs 탐색한 걸 같은 index(연합번호)에 사람 수 합
        checkArr[index][1]++;   // 연합한 지역 개수
        indexMap[r][c] = index; // 현재 탐색한 지역의 연합번호를 indexMap(연합 번호 나타내는 곳에 저장한다) -> 이걸 기반으로 checkArr 탐색해서 계산
        for(int d=0; d<4; d++){
            int nr = r+dx[d];
            int nc = c+dy[d];
            if(nr<0||nr>=N||nc<0||nc>=N) continue;
            if(isVisited[nr][nc]) continue; // 이미 방문했으면 continue
            if(Math.abs(map[r][c]-map[nr][nc])>=Low&&Math.abs(map[r][c]-map[nr][nc])<=Max){ // 조건에 만족하면 방문
                isVisited[nr][nc] = true;   // 방문 표시
                dfs(index, nr, nc);
            }
        }

    }
}
//https://www.acmicpc.net/problem/16234