package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5인구이동_16234 { // 다 뒤질필요 없이 Union find 활용하면 더 빠르게 가능할 듯
    static int N, Low, Max;
    static ArrayList<Node> map[][];
    static boolean[][] isVisited;
    static int[] dx = {-1,0,0,1}, dy ={0,-1,1,0};
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Low = Integer.parseInt(st.nextToken());
        Max = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N][N];
        map = new ArrayList[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = new ArrayList<>();
                int a = Integer.parseInt(st.nextToken());
                map[i][j].add(new Node(a, new boolean[]{false,false,false,false}));
            }
        }
        
        bw.write(""+check());
        bw.flush();
    }   
    private static int check() {
        int result = 0;
        boolean noOpen = false; // 인접한거 체크
        while(!noOpen){
            noOpen = true;  // 인접한거 없으면 이 true로 아래에서 break;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    Node node = map[i][j].get(0);   
                    for(int d=0; d<4; d++){
                        int nr = i+dx[d];
                        int nc = j+dy[d];
                            if(nr<0||nr>=N||nc<0||nc>=N) continue;
                            Node temp = map[nr][nc].get(0);
                            if(Math.abs(node.people-temp.people)>=Low&&Math.abs(node.people-temp.people)<=Max){ // 범위 안이면 인접 체크용 noOpen을 false로 node의 인접방향 true로 바꿔준다
                                node.openArea[d] = true;
                                noOpen = false;       
                            }
                            else node.openArea[d] = false;  // 없으면 다시 false로 초기화
                    }
                }
            }
            if(noOpen) break;   
            sumPeople();    // 합치기 과정
            result++;   // 합치기(인구 이동 발생시 +1)
        }
        return result;
    }
    private static void sumPeople() {   // 합치기
        isVisited = new boolean[N][N];  // 방문 체크
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(isVisited[r][c]) continue;   // 방문했으면 건너 뜀
                int sum = 0;    // 합계
                int count = 0;  // 개수 체크
                Queue<Area> q = new LinkedList<>(); // bfs 체크용
                Queue<Area> tempQ = new LinkedList<>(); // 마지막에 다 더해주기 위한 좌표 저장 용
                q.add(new Area(r, c));  // 시작 좌표 넣기
                boolean open = false;   // 국경이 열려있는 좌표인지 확인
                isVisited[r][c] = true;
                while(!q.isEmpty()){    
                    open =false;
                    Area area = q.poll();
                    for(int d=0; d<4; d++){
                        if(map[area.r][area.c].get(0).openArea[d]){ // 국경이 열려있으면
                            int nr = area.r + dx[d];
                            int nc = area.c + dy[d];
                            open = true;    // 열린 좌표라는걸 표시
                            if(isVisited[nr][nc]) continue;    
                            isVisited[nr][nc] = true;
                            q.add(new Area(nr, nc));    // 방문안한 열린 국경 좌표 탐색 실시
                        }
                    }
                    if(open){   // 열려있는거 합    // 닫혀 있는 좌표는 어짜피 이동 안하므로 따로 처리하지 않는다.
                        sum+= map[area.r][area.c].get(0).people;
                        tempQ.add(new Area(area.r, area.c));  // 열려있는 좌표 tempQ에 넣기
                        count++;
                    }
                }
                while(!tempQ.isEmpty()){    // 인구이동 합으로 세팅하기
                    Area area = tempQ.poll();
                    map[area.r][area.c].get(0).people = sum/count;
                }
            }
        }

    }
    static class Node{
        int people;
        boolean[] openArea;
        public Node(int people, boolean[] openArea) {
            this.people = people;
            this.openArea = openArea;
        }
    }
    static class Area{
        int r;
        int c;
        public Area(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
        
}
//https://www.acmicpc.net/problem/16234