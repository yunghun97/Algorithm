package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4스타트택시_19238 {
    static int N, PEOPLE, OIL, answer;
    static int[] dx = {-1,0,0,1}, dy= {0,-1,1,0};
    static int[][] map;
    static ArrayList<Integer>[][] cusMap;
    static boolean[][] isVistied;
    static ArrayList<Customer> list;    
    static Car car;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        PEOPLE = Integer.parseInt(st.nextToken());
        OIL = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVistied = new boolean[N][N];
        list = new ArrayList<>();
        list.add(new Customer(0, 0, 0, 0)); // 쓰레기 값
        cusMap = new ArrayList[N][N]; 
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                cusMap[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1) map[i][j] = -1;
            }
        }
        st = new StringTokenizer(br.readLine());
        car = new Car(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        for(int i=1; i<=PEOPLE; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int d = Integer.parseInt(st.nextToken())-1;
            list.add(new Customer(a, b, c, d)); // 사람 정보 저장
            cusMap[a][b].add(i); // 배열좌표에 사람 저장 -> size>0 보다 클 때 사람이 있다고 판단.
        }
        boolean end = true;
        answer = 0;
        for(int i=0; i<PEOPLE; i++){
            int peopleNum = find();
            if(peopleNum==-1){  // 사람 찾으러 갈 기름도 없을 경우
                break;
            }
            
        }
        if(endCheck()) end = true;
        else end = false;
        
        if(!end){
            bw.write(String.valueOf(-1));
        }else bw.write(""+OIL);
        bw.flush();
    }
    // 끝났는지 체크
    private static boolean endCheck() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(cusMap[i][j].size()>0) return false;
            }
        }
        return true;
    }
    private static int find() { // 출발지 사람 찾으러 가는 메소드
        resetVisited();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {
            if(o1.time!=o2.time){
                return Integer.compare(o1.time, o2.time);
            }            
            else if(o1.r!=o2.r) return Integer.compare(o1.r, o2.r);
            else return Integer.compare(o1.c, o2.c);
        });
        if(cusMap[car.r][car.c].size()>0){    // 시작지점에 바로 사람이 있는 경우
            int tmpR = car.r;
            int tmpC = car.c;
            for(int i=0; i<cusMap[car.r][car.c].size(); i++){
                if(move(cusMap[car.r][car.c].get(i))){
                    cusMap[tmpR][tmpC].remove(i);
                    return 0;
                }
            }
            return -1;
        }else{
            pq.add(new Node(car.r,car.c,0));
            isVistied[car.r][car.c] = true;   
            while(!pq.isEmpty()){
                Node node = pq.poll();
                for(int d=0; d<4; d++){
                    int nr = node.r+dx[d];
                    int nc = node.c+dy[d];
                    if(nr<0||nr>=N||nc<0||nc>=N||isVistied[nr][nc]||map[nr][nc]==-1) continue;
                    if(node.time+1>OIL) return -1;    // 기름이 부족한 경우
                    if(cusMap[nr][nc].size()>0){
                        OIL -= node.time+1;
                        car.r = nr;
                        car.c = nc;
                        for(int i=0; i<cusMap[nr][nc].size(); i++){
                            if(move(cusMap[nr][nc].get(i))){
                                cusMap[nr][nc].remove(i);
                                return 0;
                            }
                        }
                        return -1;                       
                    }else{
                        isVistied[nr][nc] = true;
                        pq.add(new Node(nr,nc,node.time+1));
                    }
                }
            }
            pq.clear();
            return -1;
        }        
    }
    private static void resetVisited() {    // 방문 배열 초기화
        for(int i=0; i<N; i++) Arrays.fill(isVistied[i], false);
    }
    // 도착지로 가는 메소드
    private static boolean move(int customerNum) {
        resetVisited();
        Queue<Node> q = new LinkedList<>();
        Customer customer = list.get(customerNum);
        int distR = customer.distR;
        int distC = customer.distC;

        q.add(new Node(car.r,car.c,0));
        isVistied[car.r][car.c] = true;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if(nr<0||nr>=N||nc<0||nc>=N||isVistied[nr][nc]||map[nr][nc]==-1) continue;
                if(node.time+1>OIL) return false;
                if(nr==distR&&nc==distC){                    
                    car.r = nr;
                    car.c = nc;
                    OIL -= node.time+1;
                    OIL = OIL + (node.time+1)*2;
                    return true;
                }else{
                    isVistied[nr][nc] = true;
                    q.add(new Node(nr,nc,node.time+1));
                } 
            }
        }
        return false;        
    }
    static class Customer{
        int startR;
        int startC;
        int distR;
        int distC;
        public Customer(int startR, int startC, int distR, int distC) {
            this.startR = startR;
            this.startC = startC;
            this.distR = distR;
            this.distC = distC;
        }
    }
    static class Car{
        int r;
        int c;
        public Car(int r, int c){
            this.r = r;
            this.c = c;
        }
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
