package BackJun.Gold;

import java.io.*;
import java.util.*;

// 0 : 빈칸 1 : 벽 2: 바이러스 위치
public class G4연구소3_17142 {
    static int N,M, zeroCount, virusCount, infectCount, time;
    static int[][] map;
    static boolean[][] isVisited;
    static ArrayList<Virus> vList;
    static int[] activeVirus, dx={-1,0,0,1}, dy={0,-1,1,0};
    static Queue<Node> q;
    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        vList = new ArrayList<>();
        activeVirus = new int[M];
        zeroCount = 0;
        virusCount  = 0;
        q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if(a==0){
                    zeroCount++;    // 빈칸의 개수
                }else if(a==2){
                    virusCount++;   // 바이러스의 총 개수
                    vList.add(new Virus(i, j));
                }
            }
        }
        time = Integer.MAX_VALUE;   // 총 걸리는 시간
        if(zeroCount==0) time = 0;  // 퍼트릴 수 있는 칸이 0이면 -> 이미 다 퍼트린 것과 똑같다. 그러므로 time = 0;
        else    combi(0,0); // 퍼트릴 수 있는 칸이 남아 있는 경우
        if(time==Integer.MAX_VALUE){
            bw.write(String.valueOf(-1));
        }else{
            bw.write(String.valueOf(time));
        }
        bw.flush();
    }    
    // 조합뽑는 메소드
    private static void combi(int cnt, int start) {
        if(cnt==M){
            cal();
            return;
        }
        for(int i=start; i<virusCount; i++){
            activeVirus[cnt] = i;
            combi(cnt+1, i+1);
        }
    }
    private static void cal() {
        for(int i=0; i<N; i++){ // 방문체크 배열 초기화
            Arrays.fill(isVisited[i], false);
        }
        for(int num : activeVirus){
            Virus virus = vList.get(num);
            q.add(new Node(virus.r, virus.c));  // 큐 q에 활성화된 바이러스의 좌표를 넣어준다.
            isVisited[virus.r][virus.c] = true; // 활성화한 바이러스 방문체크 
        }
        infectCount = 0;    // 빈칸을 바이러스로 퍼트린 개수 -> 이 개수랑 총 빈칸 개수랑 같지 않으면 -1 출력
        int resultTime = 0; // 현재 조합에서 전파하는데 걸리는 시간
        while(!q.isEmpty()){    // 큐가 빌 때 까지
            int size = q.size();
            for(int x=0; x<size; x++){  // size 만큼 돈다 = 시간단위로 돈다.
                Node node = q.poll();
                for(int d=0; d<4; d++){
                    int nr = node.r + dx[d];
                    int nc = node.c + dy[d];
                    if(!check(nr,nc)) continue; // 유효성 체크 -> 유효하면 true return
                    isVisited[nr][nc] = true;   // 방문 체크
                    if(map[nr][nc]==2){ // 바이러스 칸이면
                        q.add(new Node(nr,nc));
                    }else{  // 빈 칸이면
                        infectCount++;          // 전파한 칸 개수 추가
                        q.add(new Node(nr,nc));               
                    }
                }
            }
            // 시간단위로 연산이 끝나면
            resultTime++;   // 작업한 시간 +1
            if(resultTime>=time){   // 작업 시간이 결과값과 크거나 같으면 -> 더 탐색할 필요가 없으므로 큐 clear 후 return
                q.clear();
                return;
            }
            if(infectCount==zeroCount){ // 다 전파했으면 큐 clear 및 time을 resultTime으로 설정(resultTime>=time)는 위에서 걸러졌으므로 항상 작은 값만 오기때문에 Math.min 불필요
                q.clear();
                time = resultTime;
                return;
            }
        }
    }
    // 전파할 수 있는 칸이면 true return
    private static boolean check(int nr, int nc) {
        if(nr<0||nr>=N||nc<0||nc>=N||isVisited[nr][nc]||map[nr][nc]==1) return false;

        return true;
    }
    static class Virus{
        int r;
        int c;
        public Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }        
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;    
        }
    }
}

//https://www.acmicpc.net/problem/17142