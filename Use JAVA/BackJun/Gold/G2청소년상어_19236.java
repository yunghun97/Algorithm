package BackJun.Gold;
import java.io.*;
import java.util.*;
// DFS로 돌려주고 각 상황에 대해서 배열 세팅 및, 물고기 정보 세팅 -> 1칸 이동하는게 아니라 3칸중에 원하는 칸
public class G2청소년상어_19236 { // 방향 상 = 1 -> 반시계방향으로 45도씩
    static int[] dx ={0,-1,-1,0,1,1,1,0,-1}, dy = {0,0,-1,-1,-1,0,1,1,1};
    static int answer;
   public static void main(String[] args) throws IOException{
    System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G2청소년상어_19236.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int[][] map = new int[4][4];
    ArrayList<Fish> fishArr = new ArrayList<>();
    fishArr.add(new Fish(0,0,0,0,true));
    for(int i=0; i<4; i++){
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<4; j++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[i][j] = a;
            fishArr.add(new Fish(a,i,j,b,false));
        }
    }
    Collections.sort(fishArr, (o1,o2) -> Integer.compare(o1.num,o2.num)); // -> 오름차순 정렬
    Fish fish = fishArr.get(map[0][0]);
    // System.out.println(fishArr.toString());
    fish.dead = true;           // 처음 상어 위치 세팅
    answer = 0;
    map[0][0]=-1; // 상어 위치
    Shark shark = new Shark(0,0,fish.dir);
    moveShark(shark, fishArr, map,fish.num);
    bw.write(""+answer);
    bw.flush();
    bw.close();
    br.close();
   }
   private static void moveShark(Shark shark, ArrayList<Fish> fishArr, int[][] map, int sum) { //sum은 최대값 확인용. 나머지는 필 수
        answer = Math.max(answer,sum);
        
        moveFish(map,fishArr);  // 상어 움직인 상태이므로 물고기 이동

        for(int d=1; d<=3; d++){    // 4*4배열이므로 최대 3칸이동 가능하다
            int nr = shark.r + dx[shark.dir]*d; // *1*2*3으로 +1+2+3의 효과를 보인다.
            int nc = shark.c + dy[shark.dir]*d;
            if(nr<0||nr>=4||nc<0||nc>=4||map[nr][nc]==0) continue;

            
            int[][] copyMap = mapCopy(map); // dfs는 선택 갈림길마다 매개변수로 복사된 배열을 매개변수로 넘겨 끝나고 왔을 때 다른 map이 그대로 있어야 한다 -> 복사된 객체를 넘겨준다.
            ArrayList<Fish> copyFishArr = fishCopy(fishArr);    // 복사된 fishes 배열
            Shark copyShark = new Shark(shark.r,shark.c,shark.dir); // 복사된 shark -> 1,2,3 이동 마다 데이터가 다 다르므로 복사해서 넘겨준다.

            
            Fish fish = copyFishArr.get(copyMap[nr][nc]);   // 이동할 위치의 물고기 정보 가져오기
            fish.dead = true;   // 죽은상태로 처리
            copyMap[copyShark.r][copyShark.c] = 0; // 기존 상어위치 0 으로
            copyMap[nr][nc] = -1;   // 이동한 좌표 상어 표시
            copyShark.dir = fish.dir;   // 먹은 물고기의 방향 가지기
            copyShark.r = nr; copyShark.c = nc; // 상어에 새로운 좌표
            moveShark(copyShark, copyFishArr, copyMap, sum+fish.num);   // dfs 탐색하기
        }
        return;
    }
    private static ArrayList<Fish> fishCopy(ArrayList<Fish> fishArr) {      // 물고기 배열 복사하기
        ArrayList<Fish> tempFishes = new ArrayList<>();
        for(int i=0; i<=16; i++){
            Fish fish = fishArr.get(i);
            tempFishes.add(new Fish(fish.num,fish.r,fish.c,fish.dir,fish.dead));
        }

    return tempFishes;
}
    private static int[][] mapCopy(int[][] map) {   // map 복사
        int[][] tempMap = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                tempMap[i][j] = map[i][j];
            }
        }
        return tempMap;
}
    private static void moveFish(int[][] map, ArrayList<Fish> fishArr) {    // 물고기 이동
        for(int i=1; i<=16; i++){   // 1번 물고기 부터
            if(fishArr.get(i).dead) continue;   // 죽은 물고기는 이동 x

            Fish fish = fishArr.get(i);
            for(int d=0; d<=8; d++){    // 마지막 방향은 원위치가 되도록 9번 돌려준다. -> 어짜피 다 안되면 9번째도 원위치가 된다.
                int nr = fish.r+dx[fish.dir];
                int nc = fish.c+dy[fish.dir];
                if(nr<0||nr>=4||nc<0||nc>=4||map[nr][nc]==-1){  // 상어가 있거나 배열밖이면 방향 바꾸끼
                    fish.dir = fish.dir%8+1;
                    continue;
                }
                if(map[nr][nc]==0){ // 빈칸 일 떄
                    map[fish.r][fish.c]=0; 
                    map[nr][nc] = fish.num;
                    fish.r = nr; fish.c = nc;
                    break;
                }else{ // 물고기가 있을 때
                    Fish fishTemp = fishArr.get(map[nr][nc]);
                    map[nr][nc] = fish.num;
                    map[fish.r][fish.c] = fishTemp.num;
                    fishTemp.r = fish.r; fishTemp.c = fish.c;
                    fish.r = nr; fish.c = nc;
                    break;
                }
            }
        }
    }   
static class Fish{
       int num;
       int r;
       int c;
       int dir;
       boolean dead;
    public Fish(int num, int r, int c, int dir, boolean dead) {
        this.num = num;
        this.r = r;
        this.c = c;
        this.dir = dir;
        this.dead = dead;
    }
    @Override
    public String toString() {
        return "Fish [c=" + c + ", dead=" + dead + ", dir=" + dir + ", num=" + num + ", r=" + r + "]";
    }
    
       
   }
   static class Shark{
       int r;
       int c;
       int dir;
    public Shark(int r, int c,int dir) {
        this.r = r;
        this.c = c;
        this.dir = dir;
    }
   }
}

//https://www.acmicpc.net/problem/19236