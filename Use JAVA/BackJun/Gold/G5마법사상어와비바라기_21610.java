package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5마법사상어와비바라기_21610 {
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1}, dy = {0,-1,-1,0,1,1,1,0,-1};
    static int[] checkR = {-1,-1,1,1}, checkC = {-1,1,-1,1};
    static int[][] map;
    static boolean[][] isVisited;
    static int N,order;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        q = new LinkedList<>();
        for(int i=0; i<order; i++){
            st = new StringTokenizer(br.readLine());
            if(i==0){   // 처음일 때
                q.add(new Node(N-2,0));
                q.add(new Node(N-2,1));
                q.add(new Node(N-1,0));
                q.add(new Node(N-1,1));
            }else{  // 아닐 때  
                checkCloud();
                for(int x=0; x<N; x++){ // 구름 뽑고 나면 방문 초기화 -> move메소드 에서 구름 사라진 좌표 체크
                    Arrays.fill(isVisited[x], false);
                }
            }
            move(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));    // 구름 이동
            checkNear();    // 대각선 확인 
        }

        checkCloud();   // 마지막 구름 뽑고 그 다음 물 체크
        int answer =0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer += map[i][j];
            }
        }
        bw.write(""+answer);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void checkNear() {   // 대각선 확인
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + checkR[d];
                int nc = node.c + checkC[d];
                if(nr<0||nr>=N||nc<0||nc>=N) continue;

                if(map[nr][nc]>=1){
                    map[node.r][node.c]+=1;
                }
            }
        }
    }
    private static void move(int dir, int repeat) { // 구름 이동
        int qSize = q.size();
        for(int i=0; i<qSize; i++){ // 현재 큐에 들어있는 좌표 만큼만
            Node node = q.poll();
            int nr = node.r;
            int nc = node.c;
            for(int j=0; j<repeat; j++){    // 횟수 만큼 반복
                nr +=dx[dir];
                nc +=dy[dir];
                if(nr==-1) nr = N-1;
                if(nc==-1) nc = N-1;
                if(nr==N) nr = 0;
                if(nc==N) nc = 0;
            }
            q.add(new Node(nr, nc));    // 큐에 마지막 좌표 다시 넣기
            map[nr][nc] +=1;    // 마지막 좌표에 도착했으므로 ++
            isVisited[nr][nc] = true;   // 방문 표시
        }
    }
    private static void checkCloud() {  // 구름 뽑아내기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]>=2&&!isVisited[i][j]){
                    q.add(new Node(i,j));
                    map[i][j] -=2;
                }
            }
        }
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
//https://www.acmicpc.net/problem/21610
