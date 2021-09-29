package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G3어른상어_19237 {
    /*
        이동기준 우선순위
        1. 아무 냄새가 없는 칸
        2. 자신의 냄새가 있는 칸의 방향 -> 여러 개면 우선순위를 따른다.
        
        종료
        한 칸에 상어가 2마리 이상일 시 그 칸에서 가장 작은 번호의 상어만 살아 남는다.

        피는 k를 뿌리며 --1 -> 0 이되면 사라진다.\
        
        방향 1 -> 위 2-> 아래 3 -> 왼쪽 4-> 오른쪽
    */
    static int[] dx = {0,-1,1,0,0}, dy = {0,0,0,-1,1};
    static int N, Sh, Smell;
    static LinkedList<Integer> map[][];
    static int[][] bloodMap;
    static int[][] remainMap;
    static ArrayList<Shark> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Sh = Integer.parseInt(st.nextToken());
        Smell = Integer.parseInt(st.nextToken());
        remainMap = new int[N][N];  // 냄새 지속지간 
        bloodMap = new int[N][N];   // 냄새 기록
        map = new LinkedList[N][N]; // 상어의 개수를 새기위한 map
        list = new ArrayList<>();

        list.add(new Shark(0, 0, 0,false)); // 쓰레기 값
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());   // 상어일 때만
                if(a!=0){
                    list.add(new Shark(a, i, j, false));    // 상에 리스트에 추가
                }
                map[i][j] = new LinkedList<Integer>();  // 맵 리스트 선언
            }
        }
        list.sort(new Comparator<Shark>(){  // 상어 리스트를 상어 번호순으로 정렬
            public int compare(Shark o1, Shark o2){
                return Integer.compare(o1.num, o2.num);
            }
        });
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=Sh; i++){
            list.get(i).dir = Integer.parseInt(st.nextToken());
        }

        for(int s=1; s<=Sh; s++){   
            list.get(s).priArr = new int[5][4]; // 1번 상어부터 우선순위 배열 설정 // [0][~] 는 쓰레기값
            for(int i=1; i<=4; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<4; j++){
                    list.get(s).priArr[i][j] = Integer.parseInt(st.nextToken());    // 값 설정
                }
            }
        }
        bw.write(""+(move()));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int move() {
        int time = 0;   // 시작시간 0
        while(time<1000){   // 1000초가 되면 바로 break;
        setSmell(); // 냄새뿌리기
        checkDir(); // 움직이기
        checkSmell(); //냄새 카운트 지우기
        outShark(); // 중복 제거
        time++;
        int count = countShark();   // 남아있는 상어 개수 가져오기
        if(count==1){   // 상어 개수가 1이면 -> 다 튕기고 1번 상어 혼자 남음 -> 바로 출력
            return time;
        }
        
        }
        return -1;  // 1000초가 되었다 -> -1 return
    }


    private static int countShark() {   // 상어개수 메소드 
        int count = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                count += map[i][j].size();
                if(count>=2) return count;  // 2이상이면 더 안 구하고 바로 return 
            }
        }
        return count;
    }

    private static void outShark() {        // 중복 상어 제거
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()>=2){
                    int min = 999;
                    for(int x=0; x<map[i][j].size(); x++){  // 현재 중복칸 중 가장 작은 상어번호 구하기
                        min = Math.min(map[i][j].get(x), min);
                    }
                    
                    for(int x=0; x<map[i][j].size(); x++){  // 가장 작은 상어번호가 아니면 remove 후 size도 줄어들기 때문에 x도 -- 해준다.
                        if(map[i][j].get(x)!=min){  // 작은 상어 번호 아니면
                            list.get(map[i][j].get(x)).dead = true; // 죽은 상어 상태로 만들기
                            map[i][j].remove(x);    // map에서 제거
                            x--;
                        }
                    }
                }
            }
        }
    }

    private static void checkDir() {    // 이동하기
        int R;
        int C;
        int dir;
        boolean blank = false;
        // boolean bloodCheck =false;
        
        for(int i=1; i<list.size(); i++){
            R = 0; C = 0; dir = 0; blank = false; //bloodCheck = false;
            Shark shark = list.get(i);  // 1번 상어부터 가져오기
            if(shark.dead) continue;    // 죽은 상태면 바로 다음 상어 가져오기
            for(int d=0; d<4; d++){ // 빈칸 체크
                int nr = shark.r+dx[shark.priArr[shark.dir][d]];
                int nc = shark.c+dy[shark.priArr[shark.dir][d]];
                if(nr<0||nr>=N||nc<0||nc>=N) continue;
                if(bloodMap[nr][nc]==0){    // 상어 냄새가 없는 곳
                    R = nr;
                    C = nc;
                    blank = true;
                    dir = shark.priArr[shark.dir][d];
                    break;
                }
            }
            if(!blank){ // 
            for(int d=0; d<4; d++){ // 상어 냄새가 자신과 같은 곳
                int nr = shark.r+dx[shark.priArr[shark.dir][d]];
                int nc = shark.c+dy[shark.priArr[shark.dir][d]];
                if(nr<0||nr>=N||nc<0||nc>=N) continue;
                if(bloodMap[nr][nc]==i){
                    R = nr;
                    C = nc;
                    // bloodCheck = true;
                    dir = shark.priArr[shark.dir][d];
                    break;
                }
                }
            }
            /*if(!blank&&!bloodCheck){      //       -> 빈칸이 없고, 내 상어피가 없으면 현재방향 우선순위로 바로 이동 -> 없어도 동작
                int nr = shark.r+dx[shark.priArr[shark.dir][0]];
                int nc = shark.c+dy[shark.priArr[shark.dir][0]];
                if(nr<0||nr>=N||nc<0||nc>=N) continue;
                R = shark.r+dx[shark.priArr[shark.dir][0]];
                C = shark.r+dy[shark.priArr[shark.dir][0]];
                dir = shark.priArr[shark.dir][0];
            }*/
            for(int x=0; x<map[shark.r][shark.c].size(); x++){
                if(map[shark.r][shark.c].get(x)==shark.num){
                    map[shark.r][shark.c].remove(x);
                    break;
                }
            }            
            map[R][C].add(shark.num);
            list.get(i).r = R; list.get(i).c = C; list.get(i).dir = dir;
        }
    }

    private static void setSmell() {    // 냄새 남기기
        for(int i=1; i<list.size(); i++){
            Shark shark = list.get(i);
            if(shark.dead) continue;
            bloodMap[shark.r][shark.c] = i;
            remainMap[shark.r][shark.c] = Smell;
        }
    }
    private static void checkSmell() {  // 냄새 지우기 -> 이동 후 냄새 남기기전에 -1 해줘서 0 이면 냄새 map을 0 으로 바꿔준다.
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(remainMap[i][j]>0){
                    remainMap[i][j]--;
                    if(remainMap[i][j]==0){
                        bloodMap[i][j]=0;
                    }
                }
            }
        }

    }

    static class Shark{
        int num;
        int r;
        int c;
        int dir;
        int[][] priArr;
        boolean dead;
        public Shark(int num, int r, int c, boolean dead){
            this.num = num;
            this.r = r;
            this.c = c;
            this.dead = dead;
        }
        @Override
        public String toString() {
            return "num : "+num +" r : " + r + " c : " + c +" dead : " +dead + " dir : " +dir;
        }
        
    }

}
// https://www.acmicpc.net/problem/19237