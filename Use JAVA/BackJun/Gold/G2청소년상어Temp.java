package BackJun.Gold;
import java.io.*;
import java.util.*;
// DFS로 돌려주고 각 상황에 대해서 배열 세팅 및, 물고기 정보 세팅 -> 1칸 이동하는게 아니라 3칸중에 원하는 칸
public class G2청소년상어Temp { // 방향 상 = 1 -> 반시계방향으로 45%씩
    static LinkedList<Fishes> defaultFishes;
    static Shark shark;
    static int answer;
    static int[][] defaultMap;
    static int[] dx = {0,-1,-1,0,1,1,1,0,-1}, dy = {0,0,-1,-1,-1,0,1,1,1}; // 0은 빈칸추가 9칸으로 만들어 준다.
    static boolean end;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G2청소년상어_19236.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        defaultMap = new int[4][4];
        answer = 0;
        defaultFishes = new LinkedList<>();
        defaultFishes.add(new Fishes(0, 0, 0, 0, 0,false));
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<4; j++){
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                defaultFishes.add(new Fishes(i,j,num, dir, dir,false));
                defaultMap[i][j]=num;
            }
        }
        Collections.sort(defaultFishes, (o1,o2) -> Integer.compare(o1.num, o2.num));
        Fishes Fish = defaultFishes.get(defaultMap[0][0]);
        shark = new Shark(0,0,Fish.dirX,Fish.dirY,Fish.num);
        Fish.dead = true;
        defaultMap[0][0]=-1;
        // System.out.println(defaultFishes.toString());
        // System.out.println(shark.toString());
        sharkMove(shark, defaultMap, defaultFishes);
        System.out.println(answer);

    }
    private static void sharkMove(Shark shark, int[][] map, LinkedList<Fishes> fishes) {
        answer = Math.max(answer,shark.sum);
        fishMove(map, fishes);
        
        for(int d=1; d<=3; d++){
        int nr = shark.r +(dx[shark.dirX]*d);
        int nc = shark.c +(dy[shark.dirY]*d);
        if(nr<=0||nr>=4||nc<0||nc>=4||map[nr][nc]<=0) return;
        
        int[][] copyMap = mapCopy(map);
        LinkedList<Fishes> fishesCopy = copyFishes(fishes);
        copyMap[shark.r][shark.c] = 0;
        Fishes Fish = fishesCopy.get(copyMap[nr][nc]);
        Fish.dead = true;
        copyMap[Fish.r][Fish.c] = -1;
        Shark newShark = new Shark(Fish.r, Fish.c, Fish.dirX, Fish.dirY, shark.sum+Fish.num);
        
        sharkMove(newShark, copyMap, fishesCopy);
        }
    }
    private static void fishMove(int[][] map, LinkedList<Fishes> fishes){
        for(int i=1; i<=16; i++){
            if(fishes.get(i).dead) continue;
            Fishes Fish = fishes.get(i);
            while(true){
            int nr = Fish.r + dx[Fish.dirX];
            int nc = Fish.c + dy[Fish.dirY];
            if(nr<0||nr>=4||nc<0||nc>=4||map[nr][nc]==-1){
                Fish.dirX =Fish.dirX%8+1;
                Fish.dirY =Fish.dirY%8+1;
                continue;
            }
            if(map[nr][nc]==0){
                map[nr][nc] = Fish.num;
                map[Fish.r][Fish.c] = 0;
                Fish.r = nr; Fish.c = nc;
                return;
            }else{
                Fishes temp = fishes.get(map[nr][nc]);
                temp.r = Fish.r; temp.c = Fish.c;
                map[Fish.r][Fish.c] = temp.num;
                map[nr][nc] = Fish.num;
                Fish.r = nr; Fish.c = nc;
                return;
            }
        }
        }
    }
    private static LinkedList<Fishes> copyFishes(LinkedList<Fishes> fishes) {
        LinkedList<Fishes> temp = new LinkedList<>();
        for(int i=0; i<=16; i++){
            Fishes Fish = fishes.get(i);
            temp.add(new Fishes(Fish.r, Fish.c, Fish.num, Fish.dirX, Fish.dirY,Fish.dead));
        }
        return temp;
    }
    private static int[][] mapCopy(int[][] map) {
        int[][] copyMap = new int[4][4];
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                copyMap[i][j]=map[i][j];
            }
        }
        return copyMap;
    
    }

    static class Fishes{
        int r;
        int c;
        int num;
        int dirX;
        int dirY;
        boolean dead;
        public Fishes(int r, int c,int num,int dirx, int diry, boolean dead) {
            this.r=r;
            this.c=c;
            this.num = num;
            this.dirX = dirx;
            this.dirY = diry;
            this.dead = dead;
        }
        public void setR(int r) {
            this.r = r;
        }
        public void setC(int c) {
            this.c = c;
        }
        public void setDead(boolean dead) {
            this.dead = dead;
        }
        @Override
        public String toString() {
            return "Fishes [dirX=" + dirX + ", dirY=" + dirY + ", num=" + num + "]";
        }
    }
    static class Shark{
        int r;
        int c;
        int dirX;
        int dirY;
        int sum;
        public Shark(int r, int c, int dirX, int dirY, int sum) {
            this.r = r;
            this.c = c;
            this.dirX = dirX;
            this.dirY = dirY;
            this.sum = sum;
        }
        public void setR(int r) {
            this.r = r;
        }
        public void setC(int c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return "Shark [c=" + c + ", dirX=" + dirX + ", dirY=" + dirY + ", r=" + r + ", sum=" + sum + "]";
        }
        
    }
}

//https://www.acmicpc.net/problem/19236