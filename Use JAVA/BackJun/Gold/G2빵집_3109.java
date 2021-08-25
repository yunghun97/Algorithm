package BackJun.Gold;
import java.io.*;
import java.util.StringTokenizer;


public class G2빵집_3109 {
    static int R,C, answer;
    static char[][] map;
    static boolean[][] isSelectedMap;
    static int[] dx = {-1,0,1};
    //static boolean check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isSelectedMap = new boolean[R][C];
        for(int i=0; i<R; i++){
            map[i]=br.readLine().toCharArray();
        }
        answer =0;
        for(int x=0; x<R; x++){
            //check=false;
            cal(x,0);
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
        
    }
    private static boolean cal(int r, int c) {
        if(c==C-1){ // 마지막 열 전에 도착했다 ->  현재 연결된 상태를 말한다.
            answer++;
            //check=true;
            return true;
        }
        for(int i=0; i<3; i++){
                //if(check) return true;
                int nr = dx[i]+r;
                int nc = 1+c;
                //System.out.println(Arrays.deepToString(isSelectedMap));
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(!isSelectedMap[nr][nc]&&map[nr][nc]=='.'){   // 빈칸일때만 파이프 놓기
                    isSelectedMap[nr][nc] = true;   // 선택해서 진행했는지 안했는지 확인하기위해 -> 선택했으므로 true 값을 넣어준다.
                    if(cal(nr,nc)) return true;     // 다음 좌표에서 true가 나오면 == 마지막 전 열까지 도착했다는 뜻으로 retrun true를 해줘서 메소드를 끝낸다.
                }
            }
        
        return false;   // 3번 돌아서 여기까지 온 상태이므로 더 이상 진행하지 못 함을 뜻한다. -> false를 반환하여 이 좌표는 불가능하다고 알려준다.
    } 
}
//https://www.acmicpc.net/status?user_id=yunghun97&problem_id=3109&from_mine=1
/*
5 5
.xx..
..x..
.....
...x.
...x.
*/