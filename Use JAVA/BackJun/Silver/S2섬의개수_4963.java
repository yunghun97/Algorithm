package BackJun.Silver;
import java.io.*;
import java.util.*;
public class S2섬의개수_4963 {
    static int[][] dArr = {
        {-1,-1},{-1,0},{-1,1},
        {0,-1},{0,0},{0,1},
        {1,-1},{1,0},{1,1},
    };
    static int[][] map;
    static boolean[][] isChecked;
    static int R,C,answer;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S2섬의개수_4963.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            if(R==0&&C==0) break;
            map = new int[R][C];
            
            for(int i=0; i<R; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isChecked = new boolean[R][C];
            answer=0;
            
            for(int x=0; x<R; x++){
                for(int y=0; y<C; y++){
                    if(!isChecked[x][y]&&map[x][y]==1) answer++;
                    cal(x,y);
                }
            }
            bw.write(""+answer+"\n");
            bw.flush();
        }// while 문 끝
        bw.close();
        br.close();
    }
    static void cal(int start, int end) {
        if(isChecked[start][end]||map[start][end]==0) return;
        isChecked[start][end] = true;
        for(int i=0; i<9; i++){
            int nr = start + dArr[i][0];
            int nc = end + dArr[i][1];
            if(nr<0||nr>=R||nc<0||nc>=C) continue;
            if(!isChecked[nr][nc]&&map[nr][nc]==1){
                cal(nr, nc); 
            }
        }
        
    }
}
//https://www.acmicpc.net/problem/4963