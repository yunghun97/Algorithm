package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1미로탐색 {
    static int[][] map;
    static boolean[][] isChecked;
    static int disR, disC,answer;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        disR = r-1;
        disC = c-1;
        map = new int[r][c];
        isChecked = new boolean[r][c];
        char[] arr = new char[c];
        answer=1;
        for(int i=0; i<r; i++){
            arr = br.readLine().toCharArray();
            for(int j=0; j<c; j++){
                map[i][j] = arr[j]-48;
            }
        }
        bfs();
        bw.write(""+answer);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        isChecked[0][0]=true;
        while(!q.isEmpty()){
            int qsize = q.size();
            for(int i=0; i<qsize; i++){
            int r = q.peek()[0];
            int c = q.poll()[1];
            for(int d=0; d<4; d++){
                int nr = r+dx[d];
                int nc = c+dy[d];
                if(nr<0||nr>=disR+1||nc<0||nc>=disC+1||map[nr][nc]==0||isChecked[nr][nc]) continue;

                if(nr==disR&&nc==disC){ answer++;return;}
                isChecked[nr][nc] =true;
                q.add(new int[]{nr,nc});
                }
            }
            answer++;
        }
    }
}
//https://www.acmicpc.net/problem/2178

/*
입력
4 6
110110
110110
111111
111101
출력
9
*/