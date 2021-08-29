package BackJun.Silver;
import java.io.*;
import java.util.*;
public class S2아기상어2_17086 {
    static Queue<Shark> q;
    static int answer,R,C;
    static boolean[][] map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        answer = 0;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        q = new LinkedList<>();
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    q.add(new Shark(i,j));  // 상어 좌표 저장
                    map[i][j]=true;
                }
            }
        }
        cal();
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void cal() { //bfs 탐색
        while(!q.isEmpty()){
            int qSize = q.size();
            boolean check = false;
            for(int i=0; i<qSize; i++){
                Shark shark = q.poll();
                int r = shark.r;
                int c = shark.c;
                for(int d=0; d<8; d++){
                    int nr = r+dx[d];
                    int nc = c+dy[d];
                    if(nr<0||nr>=R||nc<0||nc>=C||map[nr][nc]) continue;
                    q.add(new Shark(nr,nc));    // 새 탐색좌표 q에 저장
                    map[nr][nc] = true;
                    check = true;
                }
            }
            if(check) answer++; // 빈칸이 있으므로 +1
        }
    }
    static class Shark{
        int r;
        int c;
        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
}
//https://www.acmicpc.net/problem/17086


/*
입력
5 4
0 0 1 0
0 0 0 0
1 0 0 0
0 0 0 0
0 0 0 1
출력
2
*/
