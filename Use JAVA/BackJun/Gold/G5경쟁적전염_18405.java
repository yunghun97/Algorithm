package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5경쟁적전염_18405 {
    private static int N, K, max, count;
    private static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    private static int[][] map;
    private static PriorityQueue<Virus> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        max = N * N;
        count = 0;
        pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1.num, o2.num));

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num!=0){
                    pq.add(new Virus(i, j, num));
                    count++;
                }
                map[i][j] = num;
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int resultR = Integer.parseInt(st.nextToken())-1;
        int resultC = Integer.parseInt(st.nextToken())-1;
        for(int i=0; i<S; i++){
            if(max==count) break;
            move();
        }
        bw.write(""+map[resultR][resultC]);
        bw.flush();
    }
    private static void move() {
        Queue<Virus> q = new LinkedList<>();
        while(!pq.isEmpty()){
            Virus virus = pq.poll();
            int r = virus.r;
            int c = virus.c;
            for(int d=0; d<4; d++){
                int nr = r+dx[d];
                int nc = c+dy[d];
                if(outCheck(nr, nc)||map[nr][nc]!=0) continue;
                map[nr][nc] = virus.num;
                q.add(new Virus(r, c, virus.num));
                q.add(new Virus(nr, nc, virus.num));
                count++;
            }
        }
        while(!q.isEmpty()){
            pq.add(q.poll());
        }
    }
    private static boolean outCheck(int r, int c){
        if(r<0||r>=N||c<0||c>=N) return true;
        return false;
    }
    static class Virus{
        int r;
        int c;
        int num;
        public Virus(int r, int c, int num){
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
// https://www.acmicpc.net/problem/18405