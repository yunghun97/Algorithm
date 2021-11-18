package BackJun.Silver;
import java.io.*;
import java.util.*;

public class S1컨베이어벨트위의로봇_20055 {
    static int[] map;
    static boolean[] islocated;
    static int N, Limit, ZeroCount, Turn;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Limit = Integer.parseInt(st.nextToken());
        ZeroCount = 0;
        map = new int[N*2];
        islocated = new boolean[N*2];
        Turn = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        while(true){
            ++Turn;
            beltMove();
            drop();
            robotMove();
            if(check()) break;
            drop();
            raise();
            if(check()) break;
        }
        bw.write(""+Turn);
        bw.flush();
    }
    private static void robotMove() {
        for(int i=N-2; i>=0; i--){  // 윗줄 마지막 칸에서 계속 내려가기 때문에 윗줄에서 마지막 칸 전부터 탐색하면 된다.
            if(islocated[i]&&!islocated[i+1]&&map[i+1]>0){    //현재위치에 로봇이 있고, 다음 위치 내구도 1이상, 로봇이 없을 때
                islocated[i] = false;
                islocated[i+1] = true;
                --map[i+1];
                if(map[i+1]==0) ZeroCount++;
            }
        }
    }
    private static void drop() {    // 로봇 떨어뜨리기
        if(islocated[N-1]) islocated[N-1] = false;  
    }
    private static void beltMove() {    // 벨트랑 로봇 같이 움직이기
        int tempNum = map[N*2-1];
        boolean set = islocated[N*2-1];
        for(int i=N*2-1; i>=1; i--){
            map[i] = map[i-1];
            islocated[i] = islocated[i-1];
        }
        islocated[0] = set;
        map[0] = tempNum;
    }
    private static boolean check() {
        if(ZeroCount<Limit) return false;
        else return true;
    }
    private static void raise() {   // 로봇 올리기
        if(map[0]!=0&&!islocated[0]){
            --map[0];
            if(map[0]==0) ZeroCount++;
            islocated[0] = true;
        }
        else return;
    }
}
// https://www.acmicpc.net/problem/20055