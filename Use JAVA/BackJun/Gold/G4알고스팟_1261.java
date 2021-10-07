package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4알고스팟_1261 {
    static int R,C;
    static int[][] map, dis;
    static boolean[][] isVisited;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        dis = new int[R][C];
        isVisited = new boolean[R][C];
        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = input.charAt(j)-'0';
            }
        }
        for(int i=0; i<R; i++){
            Arrays.fill(dis[i], 9999999);
        }
        dis[0][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.weight, o2.weight));
        pq.add(new Node(0,0,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(node.r==R-1&&node.c==C-1){
                bw.write(""+dis[node.r][node.c]);
                break;
            }
            isVisited[node.r][node.c] = true;
            for(int d=0; d<4; d++){
                int nr = node.r +dx[d];
                int nc = node.c +dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C||isVisited[nr][nc]) continue;
                if(dis[nr][nc]>dis[node.r][node.c]+map[nr][nc]){
                    dis[nr][nc] =dis[node.r][node.c]+map[nr][nc];
                    pq.add(new Node(nr,nc,dis[nr][nc]));
                }
            }
        }
        bw.flush();
    }
    static class Node{
        int r;
        int c;
        int weight;
        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }
}
// https://www.acmicpc.net/problem/1261