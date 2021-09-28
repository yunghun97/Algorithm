package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4아기상어_16236 {
    static int[][] map;
    static int[] shark;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static boolean[][] isSelected;
    static int size, nowSize,time, eatCount;
    static boolean eat;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G4아기상어_16263.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        shark = new int[2]; nowSize = 2; time=0; eatCount=0;
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++){
                int a = Integer.parseInt(st.nextToken());
                map[i][j]=a;
                if(a==9){shark[0]=i;shark[1]=j;}
            }   
        }
        move();
        bw.write(""+time);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void move() {
        int r = shark[0]; int c= shark[1];  //처음 칸 전달
        while(true){
        map[r][c]= 0;   // 상어 위치 0으로 만들기
        Queue<Location> q = new LinkedList<>(); // 상어 위치저장용
        PriorityQueue<Location> fishes = new PriorityQueue<>( (o1,o2) -> {  // 먹을 수 있는 물고기 정보 저장, 우선순위 큐로 맨 처음이 가장 가까운 물고기가 되도록 한다.
            if(Integer.compare(o1.dist, o2.dist)==0){
                if(Integer.compare(o1.r, o2.r)==0){
                    return Integer.compare(o1.c, o2.c);
                }
                return Integer.compare(o1.r, o2.r);
            }
            return Integer.compare(o1.dist, o2.dist);
        });  
        isSelected = new boolean[size][size];   // 방문한 곳인지 확인
        isSelected[r][c]=true;  //상어의 위치 true
        q.add(new Location(r, c,0));    // 처음 상어 위치 q에 넣기, 거리 0 으로 초기화
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){ 
            int nr1 = q.peek().r;
            int nc1 = q.peek().c;
            int dist = q.poll().dist;
            for(int d=0; d<4; d++){
                int nr = nr1+dx[d];
                int nc = nc1+dy[d];
                if(nr<0||nr>=size||nc<0||nc>=size) continue;    // 배열 밖인 경우
                if(!isSelected[nr][nc]){    // 방문하지 않은 곳 탐색
                if(map[nr][nc]!=0&&map[nr][nc]<nowSize){    // 먹을 수 있는 경우
                    q.add(new Location(nr, nc, dist+1));    
                    fishes.add(new Location(nr,nc,dist+1)); // 물고기 정보 저장
                    isSelected[nr][nc]=true;
                }else if(map[nr][nc]==0||map[nr][nc]==nowSize){ // 지나갈 수 있는 경우
                    q.add(new Location(nr,nc,dist+1));
                    isSelected[nr][nc]=true;
                }}
            }
        }   if(!fishes.isEmpty()) break;  // 현재 최소 dist에 먹을 수 있는 물고기가 있으므로 더 찾을 필요 없이 바로 무엇을 먹을지 정해준다.
        }

        if(fishes.isEmpty()) return;        // -> 더 이상 물고기를 먹을 수 없는 경우 종료
        Location tempLocation = fishes.poll();
        ++eatCount; // 1번 먹었으므로 ++
        if(eatCount==nowSize){ nowSize++; eatCount=0;}  // 먹은 개수와 size가 같을 때 ++;
        r = tempLocation.r; c= tempLocation.c; time+=tempLocation.dist; //상어 위치 초기화 & 물고기 거리만큼 시간 더해주기
        }   //while문 끝
    } 

    static class Location /*implements Comparable<Location>*/{
        int r;
        int c;
        int dist;
        public Location(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
        /*@Override
        public int compareTo(Location o) {
            if(Integer.compare(this.dist, o.dist)==0){
                if(Integer.compare(this.r, o.r)==0){
                    return Integer.compare(this.c, o.c);
                }
                return Integer.compare(this.r, o.r);
            }
            return Integer.compare(this.dist, o.dist);
        }*/
        
    }
}
//https://www.acmicpc.net/problem/16236