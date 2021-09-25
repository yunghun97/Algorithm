package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4주사위굴리기_14499 {
    //1 오른쪽 2 왼쪽 3 위 4 아래
    static int[] dx = {0,0,0,-1,1}, dy = {0,1,-1,0,0};
    static int[] center;
    static int right,left,R,C,startR,startC,order;
    static int[][] map;
    static BufferedWriter bw ;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        center = new int[4];
        right = 0;
        left = 0;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<order; i++){
            move(Integer.parseInt(st.nextToken()));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    private static void move(int dir) throws IOException{
        int nr = startR+dx[dir];
        int nc = startC+dy[dir];
        if(nr<0||nr>=R||nc<0||nc>=C){
            nr -=dx[dir];
            nc -=dy[dir];    
            return;
        }
        diceSet(dir);
        if(map[nr][nc]==0){ // 바닥면 0 일 때 칸 = 주사위 바닥면
            map[nr][nc] = center[1];
            bw.write(""+center[3]+"\n");
        }else{  // 바닥면 숫자일 때 주사위 바닥 = 칸 and 칸 = 0
            center[1] = map[nr][nc];
            map[nr][nc] = 0;
            bw.write(""+center[3]+"\n");
        }
        startR = nr;
        startC = nc;
    }
    private static void diceSet(int dir) {
        if(dir==1){ // 오른쪽
            int temp = left;
            left = center[1];
            center[1] = right;
            right = center[3];
            center[3] = temp;

        }else if(dir==2){   // 왼쪽
            int temp = right;
            right = center[1];
            center[1] = left;
            left = center[3];
            center[3] = temp;
        }
        else if(dir==3){    // 위로
            int temp = center[0];
            for(int i=0; i<=2; i++){
                center[i] = center[i+1];
            } 
            center[3] = temp;
        }else{  // 아래로
            int temp = center[3];
            for(int i=3; i>0; i--){
                center[i] = center[i-1];
            }
            center[0] = temp;
        }

    }
}
//https://www.acmicpc.net/problem/14499