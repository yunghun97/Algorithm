package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

public class 탈주범검거 {
    static ArrayList<Tunnel> list;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static int R,C,Time, answer;
    static boolean[][] isVisited;
    static int[][] map;
    // 0 위 , 1 왼 , 2 아래, 3 오른쪽
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        list = new ArrayList<>();
        list.add(new Tunnel(new int[]{0})); // 이건 쓰레기 값
        // 1~7번 배관 방향배열 저장
        list.add(new Tunnel(new int[]{0,1,2,3}));
        list.add(new Tunnel(new int[]{0,2}));
        list.add(new Tunnel(new int[]{1,3}));

        list.add(new Tunnel(new int[]{0,3}));
        list.add(new Tunnel(new int[]{2,3}));
        list.add(new Tunnel(new int[]{1,2}));
        list.add(new Tunnel(new int[]{0,1}));
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int dr = Integer.parseInt(st.nextToken());
            int dc = Integer.parseInt(st.nextToken());
            Time = Integer.parseInt(st.nextToken());
            map = new int[R][C];
            isVisited = new boolean[R][C];
            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = 0;
            bfs(dr, dc);
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }   // 테케 끝
        bw.close();
        br.close();
        
    }
    private static void bfs(int r, int c) {
        Queue<Node> q= new LinkedList<>();
        q.add(new Node(r,c,1)); // 시작부터 1초
        isVisited[r][c] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            answer++;
            int tNumber = map[node.r][node.c];
            Tunnel tunnel = list.get(tNumber);
            if(node.time<Time){ // 시간안에 있는 경우만 -> time 3일 때 2까지만 도므로 2+1해서 3일 때 갈 수 있는 좌표 모두 탐색
            for(int d=0; d<tunnel.dirList.length; d++){
                int nr = node.r + dx[tunnel.dirList[d]];
                int nc = node.c + dy[tunnel.dirList[d]];
                if(nr<0||nr>=R||nc<0||nc>=C||map[nr][nc]==0||isVisited[nr][nc]) continue;
                for(int x=0; x<list.get(map[nr][nc]).dirList.length; x++){
                    if(list.get(map[nr][nc]).dirList[x]==(tunnel.dirList[d]+2)%4){  // 현재 진행하는 방향과 이동하는 좌표의 터널이 진행하는 방향의 반대 방향과 연결되었을 경우
                        isVisited[nr][nc] = true;
                        q.add(new Node(nr,nc,node.time+1));
                        break;
                    }
                }
            }
            }else continue;
        }

    }

    static class Tunnel{    // 터널 방향
        int[] dirList;
        public Tunnel(int[] dirList) {
            this.dirList = dirList;
        }
    }
    static class Node{  // 좌표랑 시간 저장용
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
