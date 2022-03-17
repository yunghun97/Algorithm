package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;
public class 미생물격리_2382 {
    static int N, M, K;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    static Queue<Node>[][] mapQ; // 해당 위치의 최대 미생물 수
    static ArrayList<Node> list;
    // 방향 입력값 : 1,2,3,4 = 상 하 좌 우
    // 1 -> 0  2 -> 2,  3 -> 1, 4 -> 3
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            mapQ = new Queue[N][N];
            for(int i = 0; i <N; i++){
                for(int j = 0; j < N; j++){
                    mapQ[i][j] = new LinkedList<>();
                }
            }
            list = new ArrayList<>();                       
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int size = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                if(dir==1) dir = 0;
                else if(dir==3) dir = 1;
                else if(dir==4) dir = 3;
                list.add(new Node(i,r,c,size,dir, false));
            }
            for(int m = 0; m < M; m++){
                move();
                maxCheck();
            }
            int answer = addAll();
            bw.write("#"+t+" "+answer+"\n");
        }// 테케 끝
        bw.flush();
    }
    // 남은 미생물 수 전부 더하기
    private static int addAll() {  
        int result = 0;
        for(int i =0; i < list.size(); i++){
            Node node = list.get(i);
            if(node.dead) continue;
            result += node.size;
        }
        return result;
    }
    // 셀이 여러개 겹치는 부분 탐색해서 하나로 합쳐주기
    private static void maxCheck() {
        for(int i = 0; i < list.size(); i++){
            Node node = list.get(i);
            if(node.dead) continue; // 이미 죽은 상태면 다음거 찾기
            if(mapQ[node.r][node.c].size()<=1){
                mapQ[node.r][node.c].clear();
                continue;
            }
            else{
                int sum = 0;
                int max = 0;
                int dir = 0;
                int size = mapQ[node.r][node.c].size();
                while(true){
                    Node tmpNode = mapQ[node.r][node.c].poll();
                    if(tmpNode.size>max){
                        mapQ[node.r][node.c].add(tmpNode);
                        max = tmpNode.size;
                        dir = tmpNode.dir;
                    }else if(tmpNode.size==max){
                        Node resultNode = list.get(tmpNode.num);
                        resultNode.size = sum;
                        resultNode.dir = dir;
                        break;  // 같은 사이즈면 최대 2바퀴 돈 상태이므로 break;    
                    } 
                    else{ // 더 작으면 소멸시켜 주기
                        list.get(tmpNode.num).dead = true;
                    }
                    if(size>0) sum += tmpNode.size; // 해당 큐 사이즈만큼만 더해서 미생물 수 합치기
                    size--;
                }                
                
            }
        }
    }
    // 이동하기
    private static void move() {
        for(int i = 0; i < list.size(); i++){
            Node node = list.get(i);
            if(node.dead) continue; // 이미 죽은 상태면 다음거 찾기
            node.r = node.r + dx[node.dir];
            node.c = node.c + dy[node.dir];
            if(medicineCheck(node.r, node.c)){ // 약품처리된 공간이면
                if(node.size==1){
                    node.dead = true;
                    continue;
                }else{
                    node.size /=2;
                    node.dir = (node.dir+2)%4;
                    continue;
                }
            }else{ // 아니면
                mapQ[node.r][node.c].add(node);
                continue;
            }
        }
    }
    // 기장자리면 true 아니면 false return
    private static boolean medicineCheck(int nr, int nc) {
        if(nr==0||nr==N-1||nc==0||nc==N-1) return true;
        return false;
    }
    static class Node{
        int num;
        int r;
        int c;
        int dir;
        int size;
        boolean dead;
        public Node(int num, int r, int c, int size,  int dir, boolean dead) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.size = size;
            this.dir = dir;
            this.dead = dead;
        }
        public int getR() {
            return r;
        }
        public void setR(int r) {
            this.r = r;
        }
        public int getC() {
            return c;
        }
        public void setC(int c) {
            this.c = c;
        }
        public int getDir() {
            return dir;
        }
        public void setDir(int dir) {
            this.dir = dir;
        }
        public int getSize() {
            return size;
        }
        public void setSize(int size) {
            this.size = size;
        }
        public boolean isDead() {
            return dead;
        }
        public void setDead(boolean dead) {
            this.dead = dead;
        }
        
    }
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV597vbqAH0DFAVl&