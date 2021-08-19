package BackJun.Gold;
import java.io.*;
import java.util.*;

public class G4알파벳_1987 {
    static int R, C,result;
    static char[][] map;
    static boolean[] isSelected;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException { // A는 아스키 코드 65
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        isSelected = new boolean[26];
        result =0;
        cal(0,0,1);     // 1부터 시작
        bw.write(""+result);
        bw.flush();
        bw.close();
        br.close();
        //System.out.println(Arrays.deepToString(map));

    }
    private static void cal(int r, int c,int count) {   
        if(isSelected[map[r][c]-65]) return;    // 현재 알파벳이 사용되었으면 종료
        isSelected[map[r][c]-65] = true;
        result = Math.max(result, count);
        for(int d=0; d<4; d++){
            int nr = r+dx[d];
            int nc = c+dy[d];
            if(nr>=0&&nr<R&&nc>=0&&nc<C){
                cal(nr,nc,count+1);
            }
        }
        isSelected[map[r][c]-65] = false;
}
    /*private static boolean isAvailable(int nr, int nc){
        if(!isSelected[map[nr][nc]-65]) return true;
        return false;
    }*/

}
//https://www.acmicpc.net/problem/1987
/*
5 5
IEFCJ
FHFKC
FFALF
HFGCF
HMCHH
*/