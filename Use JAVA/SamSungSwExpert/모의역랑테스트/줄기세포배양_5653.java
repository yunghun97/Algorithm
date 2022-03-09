package SamSungSwExpert.모의역랑테스트;

import java.util.*;
import java.io.*;

public class 줄기세포배양_5653 {
    static int R,C,K;
    static boolean[][] map;
    static PriorityQueue<Node> pq;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.defaultTime, o1.defaultTime));
            map = new boolean[400][400];
            int tmp = 200;
            for(int r = 0; r<R; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c<C; c++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a!=0){
                        map[tmp+r][tmp+c] = true;
                        pq.add(new Node(tmp+r,tmp+c,a,a,false));                        
                    }
                }
            }
            for(int k = 0; k<K; k++){
                cal();
            }

            bw.write("#"+t+" "+pq.size()+"\n");
        } // 테케 끝
        bw.flush();
    }
    private static void cal() {
        Queue<Node> tmpQ = new LinkedList<>();
        int size = pq.size();
        for(int i = 0; i< size; i++){
            Node node = pq.poll();
            if(node.active){ // 활성 상태 : 1. 체크 후 퍼지기 2. time-1이 0이면 q에 다시 추가 X
                for(int d=0; d<4; d++){
                    int nr = node.r +dx[d];
                    int nc = node.c +dy[d];
                    if(possibleCheck(nr,nc)){
                        map[nr][nc] = true;
                        tmpQ.add(new Node(nr, nc, node.defaultTime, node.defaultTime, false));
                    }
                }
                if(node.time-1!=0){
                    tmpQ.add(new Node(node.r, node.c, node.time-1, node.defaultTime, true));
                }
            }else{ // 비활성 상태 : time-1이 0이면 time defaultTime으로 새로 할당 후 active true
                if(node.time-1==0){ // 활성화 시켜주기
                    tmpQ.add(new Node(node.r, node.c, node.defaultTime, node.defaultTime, true));
                }else{ // 아직 남아있음
                    tmpQ.add(new Node(node.r, node.c, node.time-1, node.defaultTime, false));
                }
            }
        }
        while(!tmpQ.isEmpty()){
            pq.add(tmpQ.poll());
        }

    }
    /**
     * 
     * @param r 행
     * @param c 열
     * @return true : 퍼질 수 있음 false 퍼질 수 없음
     */
    private static boolean possibleCheck(int r, int c) {
        if(map[r][c]){
            return false;
        }
        return true;
    }
    static class Node{
        int r;
        int c;
        int time;
        int defaultTime;
        boolean active;
        public Node(int r, int c, int time, int defaultTime, boolean active) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.defaultTime = defaultTime;
            this.active = active;
        }
    }

}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRJ8EKe48DFAUo
