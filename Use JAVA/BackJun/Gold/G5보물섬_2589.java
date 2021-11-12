package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5보물섬_2589 {
    static char[][] map;
    static int R,C;
    static int[] dx = {-1,0,0,1}, dy={0,-1,1,0};
    static boolean[][] isVisited;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];
        q = new LinkedList<>();
        for(int i=0; i<R; i++){ // map 정보 저장
            map[i] = br.readLine().toCharArray();
        }
        int answer = 0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(map[i][j]=='L'){
                    reset();    // 방문 배열 초기화
                    answer = Math.max(cal(i,j), answer);    // 각 모든 L에서 가장 먼 거리 다 탐색해서 최대 값을 뽑아낸다.
                }
            }
        }
        bw.write(""+answer);
        bw.flush();
    }

    private static void reset() {  // 방문 배열 초기화
        for(int i=0; i<R; i++) Arrays.fill(isVisited[i],false);
    }

    private static int cal(int i, int j) {
        isVisited[i][j] = true;
        q.add(new Node(i,j,0));
        int result = 0;
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C||isVisited[nr][nc]||map[nr][nc]=='W') continue; // 조건에 안맞으면 q에 넣지않는다.
                q.add(new Node(nr,nc,node.time+1));
                isVisited[nr][nc] = true;
                result = Math.max(result, node.time+1); // 최대값 세팅
            }
        }

        return result;  // 각 계산 최대값 반환
    }

    static class Node{
        int r;
        int c;
        int time;
        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }
}
//https://www.acmicpc.net/problem/2589