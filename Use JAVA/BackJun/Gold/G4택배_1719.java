package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4택배_1719 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int MAX = 500000;
        int[][] map = new int[N+1][N+1];
        int[][] dir = new int[N+1][N+1];
        for(int i=0; i <= N; i++){
            Arrays.fill(map[i], MAX);
            map[i][i]=0;
        }
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            map[start][end] = time;
            map[end][start] = time;

            dir[start][end] = end;
            dir[end][start] = start;
        }
        // i는 출발 k는 경유지 j는 도착지
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                if(i==k) continue;
                for(int j=1; j<=N; j++){
                    if(j==k||j==i) continue;
                    if(map[i][j]>map[i][k]+map[k][j]){
                        map[i][j] = map[i][k]+map[k][j];
                        dir[i][j] = dir[i][k];
                    }
                }
            }
        }   
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j) bw.write("- ");
                else bw.write(String.valueOf(dir[i][j])+" ");
            }
            bw.newLine();
        }

        bw.flush();        
    }
}
// https://www.acmicpc.net/problem/1719