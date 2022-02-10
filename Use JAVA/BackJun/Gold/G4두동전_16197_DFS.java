package BackJun.Gold;

import java.util.*;
import java.io.*;
public class G4두동전_16197_DFS {
    static int R, C, answer;
    static char[][] defaultMap;
    static ArrayList<Coin> coins;
    static int[] dx = {-1,0,1,0}, dy = {0,-1,0,1};
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R =  Integer.parseInt(st.nextToken());
        C =  Integer.parseInt(st.nextToken());
        defaultMap = new char[R][C];
        answer = 11;
        coins = new ArrayList<>();
        for(int i=0; i<R; i++){    
            String input = br.readLine();        
            for(int j=0; j<C; j++){
                char a = input.charAt(j);
                defaultMap[i][j] = a;
                if(a=='o'){
                    coins.add(new Coin(i, j));
                }
            }
        }
        move(1,defaultMap, coins.get(0), coins.get(1));
        if(answer!=11)  bw.write(""+answer);
        else bw.write(String.valueOf(-1));
        bw.flush();
    }
    private static void move(int cnt, char[][] map, Coin coin1, Coin coin2) {
        if(cnt>=answer) return;
        if(cnt>=11) return;
        for(int d=0; d<4; d++){
            char[][] tmpMap = new char[R][C];
            mapCopy(tmpMap, map);
            Coin tmpCoin1 = new Coin(coin1.getR(),  coin1.getC());
            Coin tmpCoin2 = new Coin(coin2.getR(),  coin2.getC());
            // 원래 위치 비워주기
            
            CheckCoin(d, tmpCoin1, tmpCoin2);
            int result = outCheck(tmpCoin1, tmpCoin2);
            if(result==1){
                answer = Math.min(answer, cnt);
                return;
            }else if(result==2){ // 둘 다 밖으로 나가서 안 끝나는 경우
                continue;
            }else{ // 동전이 밖으로 안나가는 경우
                tmpMap[coin1.r][coin1.c] = '.';
                tmpMap[coin2.r][coin2.c] = '.';
                moveCoin(tmpMap, d, tmpCoin1, tmpCoin2);
                move(cnt+1, tmpMap, tmpCoin1, tmpCoin2);   
            }

        }
    }
    private static void CheckCoin(int dir, Coin coin1, Coin coin2) {
        coin1.r = coin1.getR()+dx[dir];
        coin1.c = coin1.getC()+dy[dir];
        coin2.r = coin2.getR()+dx[dir];
        coin2.c = coin2.getC()+dy[dir];
    }
    private static void moveCoin(char[][] map, int dir, Coin coin1, Coin coin2) {
        if(map[coin1.r][coin1.c]=='#'){
            coin1.r = coin1.getR()-dx[dir];
            coin1.c = coin1.getC()-dy[dir];
            map[coin1.r][coin1.c] = 'o';
        }else{  // 빈칸인 경우
            map[coin1.r][coin1.c] = 'o';
        }

        if(map[coin2.r][coin2.c]=='#'){ // 이동하려는 칸이 벽인 경우
            coin2.r = coin2.getR()-dx[dir]; // 뒤로 한칸 미루기
            coin2.c = coin2.getC()-dy[dir];
            if(map[coin2.r][coin2.c]=='o'){ // 뒤로 이동한 칸이 동전이 있는 경우
                coin2.r = coin2.getR()-dx[dir]; // 한 번 더 뒤로 간다.
                coin2.c = coin2.getC()-dy[dir];
                map[coin2.r][coin2.c] = 'o';
            }else{  // 빈칸인 경우
                map[coin2.r][coin2.c] = 'o';
            }
        }
        else if(map[coin2.r][coin2.c]=='o'){    // 이동하려는 칸이 동전이 있는 경우
            coin2.r = coin2.getR()-dx[dir];
            coin2.c = coin2.getC()-dy[dir];
            map[coin2.r][coin2.c] = 'o';
        }else{ // 이동하려는 칸이 빈칸인 경우
            map[coin2.r][coin2.c] = 'o';
        }
    }
    private static int outCheck(Coin coin1, Coin coin2) {
        int result = 0;
        if(coin1.r<0||coin1.r>=R||coin1.c<0||coin1.c>=C) result++;            
        if(coin2.r<0||coin2.r>=R||coin2.c<0||coin2.c>=C) result++;
        return result;
    }
    private static void mapCopy(char[][] tmpMap, char[][] map) {
        for(int i=0; i<R; i++) System.arraycopy(map[i], 0, tmpMap[i], 0, C);
    }
    static class Coin{
        int r;
        int c;
        public Coin(int r, int c) {
            this.r = r;
            this.c = c;
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
    }
}
// https://www.acmicpc.net/problem/16197