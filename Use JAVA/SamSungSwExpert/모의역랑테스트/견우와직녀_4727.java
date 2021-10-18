package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

public class 견우와직녀_4727 {
    static int[][][] check;
    static int[][] map;
    static int[] dx = {-1,0,1,0}, dy ={0,-1,0,1};
    static int N, reveal;
    static boolean[] nearCheck;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            reveal = Integer.parseInt(st.nextToken());
            check = new int[2][N][N];
            map = new int[N][N];
            nearCheck = new boolean[4];
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<2; i++){
                for(int j=0; j<N; j++){
                    Arrays.fill(check[i][j], Integer.MAX_VALUE);
                }
            }
            move();
            int answer = Math.min(check[1][N-1][N-1], check[0][N-1][N-1]);
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
    }

    private static void move() {
        Queue<Node> q=  new LinkedList<>();
        q.add(new Node(0,0,0,0,0));
        check[0][0][0]=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Node node = q.poll();
                if(node.r==N-1&&node.c==N-1) continue;
                for(int d=0; d<4; d++){
                    int nr = node.r +dx[d];
                    int nc = node.c +dy[d];
                    if(nr<0||nr>=N||nc<0||nc>=N) continue;
                    //System.out.println("level : "+ node.level+ " nr : " +nr+" nc : "+nc+" time : "+node.time+"시간 : "+ check[node.level][nr][nc]);
                    if(map[nr][nc]==0){ // 절벽 오작교를 만들어야 됨
                        if(node.level==1||node.bridge==1) continue; // 이미 절벽위에있는 경우
                        if(crossCheck(nr,nc)) continue;
                        if(node.time%reveal+1==reveal){    // 시간이 딱 맞을때
                            if(check[1][nr][nc]>node.time+1){
                                check[1][nr][nc]=node.time+1;
                                q.add(new Node(nr, nc, node.time+1, 1, 1));
                            }
                        }else{
                            int tmpTime = node.time+reveal - node.time%reveal;
                            if(check[1][nr][nc]>tmpTime){
                                check[1][nr][nc]=tmpTime;
                                q.add(new Node(nr, nc, tmpTime, 1, 1));
                            }
                        }
                    }
                    else if(map[nr][nc]==1){   // 땅이라서 이동가능
                        if(check[node.level][nr][nc]>node.time+1){
                            check[node.level][nr][nc] = node.time+1;
                            q.add(new Node(nr, nc, node.time+1, 0, node.level));
                        }
                    }else{  // 오작교가 건설되어 있는경우 그냥 지나가면 된다.
                        if(node.bridge==1) continue; // 이미 절벽위에있는 경우
                        if(node.time%map[nr][nc]+1==map[nr][nc]){    // 시간이 딱 맞을때
                            if(check[node.level][nr][nc]>node.time+1){
                                check[node.level][nr][nc]=node.time+1;
                                q.add(new Node(nr, nc, node.time+1, 1, node.level));
                            }
                        }else{
                            int tmpTime = node.time+map[nr][nc] - node.time%map[nr][nc];
                            if(check[node.level][nr][nc]>tmpTime){
                            check[node.level][nr][nc]=tmpTime;
                            q.add(new Node(nr, nc, tmpTime, 1, node.level));
                            }
                        }
                    }
                }
            }
        }


    }

    private static boolean crossCheck(int nr, int nc) {
        int count =0;
        Arrays.fill(nearCheck, false);
        for(int z=0; z<4; z++){
            int x = nr+dx[z];
            int y = nc+dy[z];
            if(x<0||x>=N||y<0||y>=N) continue;
            if(map[x][y]==0){
                nearCheck[z] = true;
                count++;
            }
        }
        if(count==3) return true;
        else{
            for(int i=0; i<4; i++){
                if(nearCheck[i]&&nearCheck[(i+1)%4]) return true;
            }
        }
        return false;                        
    }

    static class Node{
        int r;
        int c;
        int time;
        int bridge; // 현재 브리지위면 1 아니면 0
        int level;  // 오작교 찬스 안썻으면 0 쓰면 1
        public Node(int r, int c, int time, int bridge, int level) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.bridge = bridge;
            this.level = level;
        }
    }
}
