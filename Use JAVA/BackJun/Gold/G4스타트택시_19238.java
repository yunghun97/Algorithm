package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4스타트택시_19238 {
    static int N, PEOPLE, OIL, arrivePeople;
    static int[] dx = {-1,0,0,1}, dy= {0,-1,1,0};
    static int[][] map;
    static boolean[][] isVisited;
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
        isVisited = new boolean[N][N];
        list = new ArrayList<>();
        list.add(new Customer(0, 0, 0, 0)); // 쓰레기 값


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
            map[a][b] = i;
        }
        arrivePeople = 0;
        for(int i=0; i<PEOPLE; i++){
            int peopleNum = find();
            if(peopleNum==-1){  // 사람 찾으러 갈 기름도 없을 경우
                break;
            }
            if(!move(peopleNum)){
                break;
            }
            arrivePeople++; // 도착한 사람 숫자
        }
        if(arrivePeople!=PEOPLE) bw.write(String.valueOf(-1));
        else bw.write(""+OIL);

        bw.flush();
    }
    // 끝났는지 체크
    private static int find() { // 출발지 사람 찾으러 가는 메소드
        resetVisited();
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> {    
            if(o1.r!=o2.r) return Integer.compare(o1.r, o2.r);
            else return Integer.compare(o1.c, o2.c);
        });
        if(map[car.r][car.c]>0){    // 시작지점에 바로 사람이 있는 경우    
            int num = map[car.r][car.c];        
            map[car.r][car.c] = 0;
            return num;
        } else {
            q.add(new Node(car.r, car.c, 0));
            isVisited[car.r][car.c] = true;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {    // size 만큼 거리 만큼 돌도록
                    Node node = q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nr = node.r + dx[d];
                        int nc = node.c + dy[d];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N || isVisited[nr][nc] || map[nr][nc] == -1)
                            continue;
                        if (node.time + 1 > OIL)
                            return -1; // 기름이 부족한 경우
                        if (map[nr][nc] > 0) {  // 해당지점에 손님이 있는 경우
                            pq.add(new Node(nr,nc,node.time+1));
                        } else {
                            isVisited[nr][nc] = true;
                            q.add(new Node(nr, nc, node.time + 1));
                        }
                    }
                }
                if(!pq.isEmpty()){  // pq에 값이 있는 경우 = 손님이 있는 경우 -> 우선순위 조건에 따라 맨 처음에 적합한 손님이 온다.
                    Node node = pq.poll();
                    OIL = OIL - (node.time);
                    car.r = node.r;
                    car.c = node.c;
                    int num = map[node.r][node.c];
                    map[node.r][node.c] = 0;
                    return num;
                }
            }
            return -1;
        }
    }
    private static void resetVisited() {    // 방문 배열 초기화
        for(int i=0; i<N; i++) Arrays.fill(isVisited[i], false);
    }
    // 도착지로 가는 메소드
    private static boolean move(int customerNum) {
        resetVisited();
        Queue<Node> q = new LinkedList<>();
        Customer customer = list.get(customerNum);
        int distR = customer.distR;
        int distC = customer.distC;

        q.add(new Node(car.r,car.c,0));
        isVisited[car.r][car.c] = true;
        
        while(!q.isEmpty()){
            Node node = q.poll();
            for(int d=0; d<4; d++){
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if(nr<0||nr>=N||nc<0||nc>=N||isVisited[nr][nc]||map[nr][nc]==-1) continue;
                if(OIL-(node.time+1)<0) return false;
                if(nr==distR&&nc==distC){           // 도착할 경우            
                    car.r = nr; // 차 위치 바꿔주기
                    car.c = nc;
                    OIL += node.time+1;            // 오일 쓴만큼 추가        
                    return true;
                }else{
                isVisited[nr][nc] = true;
                int time = node.time;
                q.add(new Node(nr,nc,time+1));
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
//https://www.acmicpc.net/problem/19238