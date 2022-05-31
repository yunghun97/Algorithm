package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G3색종이3_2571 {
    static int N, Max, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Max = 100;
        answer = 0;
        map = new int[Max][Max];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            int c = column;
            int r = 100 - row - 10;
            for (int R = r; R < r + 10; R++) {
                for (int C = c; C < c + 10; C++) {
                    map[R][C] = 1;
                }
            }
        }
        for(int i=0; i<Max; i++){
            for(int j=1; j<Max; j++){
                if(map[i][j]!=0){
                    map[i][j]+=map[i][j-1];
                }
            }
        }
        cal();
        bw.write(""+answer);
        bw.flush();
    }

    private static void cal() {
        for(int r=1; r<Max; r++){
            for(int c=0; c<Max; c++){
                if(map[r][c]==0) continue;
                int now = map[r][c];
                int sum = 0;
                for(int nowR = r; nowR<Max; nowR++){
                    if(map[nowR][c]>=now) sum+=now;
                    else{
                        break;
                    }
                }
                for(int nowR = r; nowR>=0; nowR--){
                    if(nowR==0){
                        if(map[nowR][c]>=now) sum+=now;
                        sum-=now;
                        answer = Math.max(sum, answer);
                        break;
                    }else{                        
                        if(map[nowR][c]>=now) sum+=now;            
                        else{
                            sum-=now;
                            answer = Math.max(sum, answer);
                            break;
                        }
                    }
                }
            }
        }
    }
}
// https://www.acmicpc.net/problem/2571