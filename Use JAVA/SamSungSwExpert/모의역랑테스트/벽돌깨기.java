package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

public class 벽돌깨기 {
    static int[][] map,tempMap;
    static int N,C,R,count,answer;
    static int[] arr;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static boolean[][] isVisited;
    static Queue<Integer> resultQ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            arr = new int[N];
            map = new int[R][C];
            tempMap = new int[R][C];
            isVisited = new boolean[R][C];
            resultQ = new LinkedList<>();
            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<R; i++){
                System.arraycopy(map[i], 0, tempMap[i], 0, C);
            }
            answer = 9999999;
            permutaion(0);
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
    }
    private static void permutaion(int cnt) {
        if(answer==0) return;
        if(cnt==N){
            count = 0;
            for(int i=0; i<N; i++){
                shoot(arr[i]);  // 구슬 던지기
                for(int y=0; y<C; y++){ // 한번 구슬 던지고 나면 벽돌 아래로 정렬
                    for(int x=R-1; x>=0; x--){  // 제일 아래부터 탐색
                        if(map[x][y]!=0){   // 제일 아래부터 0이 아닌 벽돌 찾기
                            resultQ.add(map[x][y]);
                            map[x][y] = 0;
                        }
                    }
                    int r = R-1;
                    while(!resultQ.isEmpty()){
                        map[r--][y] = resultQ.poll();
                    }
                }
            }
            for(int i=0; i<R; i++){ // 남아 있는 벽돌 카운트
                for(int j=0; j<C; j++){  
                    if(map[i][j]!=0){
                        count++;
                    }
                }
            }
            answer = Math.min(answer,count);    // 최소값 저장
            for(int i=0; i<R; i++){ // 다 던졌으므로 map을 다시 초기화 해준다.
                System.arraycopy(tempMap[i], 0, map[i], 0, C);
            }
            return;
        }

        for(int i = 0; i<C; i++){
            arr[cnt] = i;
            permutaion(cnt+1);  // 중복 순열
        }
    }
    private static void shoot(int num) {
        int[] input = check(num);
        if(input[0]==-1){   // -1이면 현재 열이 다 0이므로 계산 안함
            return; 
        }
        bfs(input[0],input[1],map[input[0]][input[1]]); // bfs 실행
    }
    private static int[] check(int num) {   // 던지는 열에 제일 처음 0이 아닌 것 탐색
        int[] temp = new int[2];
        temp[0] = -1;
        for(int i=0; i<R; i++){
            if(map[i][num]!=0){
                temp[0] = i;
                temp[1] = num;
                break;
            }
        }
        return temp;
    }
    private static void bfs(int r, int c, int power) {  // 공 던지기
        for(int i=0; i<R; i++){ // 방문 배열 초기화
            Arrays.fill(isVisited[i], false);
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c,power});    // q에 초기좌표 넣기
        isVisited[r][c] = true;
        while(!q.isEmpty()){
            int x = q.peek()[0];
            int y = q.peek()[1];
            int ballPower = q.poll()[2]-1;  // 1일때 자기 자신 칸이므로 -1
            map[x][y] = 0;  // 터진 좌표 0으로 바꾸기

            if(ballPower==0) continue;  // (1-1)0이면 좌우로 안 번짐
            
            for(int i=1; i<=ballPower; i++){    // 볼 파워만큼 반복
                for(int d=0; d<4; d++){
                int nr = x + dx[d]*i;   // 볼 파워 *i로 여러개 탐색
                int nc = y + dy[d]*i;
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(isVisited[nr][nc]||map[nr][nc]==0) continue; // 방문체크 및 0이면 큐에 안넣고 넘어간다.
                isVisited[nr][nc] = true;   // 방문 표시
                q.add(new int[]{nr,nc,map[nr][nc]});    // 터트린 벽돌의 파워 저장
            }
            }
        }
    }
}

//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWXRQm6qfL0DFAUo&solveclubId=AXqgPAMaIlADFATi&problemBoxTitle=1005-WS&problemBoxCnt=1&probBoxId=AXxOe2eqSNADFASZ+