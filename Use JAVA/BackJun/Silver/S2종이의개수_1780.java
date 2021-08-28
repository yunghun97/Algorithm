package BackJun.Silver;
import java.io.*;
import java.util.*;


public class S2종이의개수_1780 {
    static int zero, m1, one;
    static int[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        zero = m1 = one = 0;
        int len = Integer.parseInt(br.readLine());
        map = new int[len][len];
        for(int i=0; i<len; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<len; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal(0, 0, len);
        bw.write(""+m1+"\n"+zero+"\n"+one);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void cal(int r, int c, int len) {
        if(check(r, c, len)){
            if(map[r][c]==0) zero++;
            else if(map[r][c]==-1) m1++;
            else one++;
            return;
        }
        len /= 3;
        cal(r,c,len);
        cal(r,c+len,len);
        cal(r,c+len*2,len);
        cal(r+len,c,len);
        cal(r+len,c+len,len);
        cal(r+len,c+len*2,len);
        cal(r+len*2,c,len);
        cal(r+len*2,c+len,len);
        cal(r+len*2,c+len*2,len);
    }

    private static boolean check(int r, int c, int len){
        int temp = map[r][c];
        for(int i=r; i<r+len; i++){
            for(int j=c; j<c+len; j++){
                if(temp!=map[i][j]) return false;
            }
        }
        return true;
    }
}

//https://www.acmicpc.net/problem/1780
/*
입력
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1
출력
10
12
11
*/