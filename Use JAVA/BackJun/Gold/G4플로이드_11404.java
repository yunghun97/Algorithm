package BackJun.Gold;

import java.util.*;
import java.io.*;
public class G4플로이드_11404 {
    static int[][] dis;
    static int N,V;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        V = Integer.parseInt(br.readLine());
        int MAX = 10000001;       
        dis = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dis[i],MAX);            
        }
        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int time = Integer.parseInt(st.nextToken());
            dis[start][end] = Math.min(dis[start][end],time);
        }
        
        for(int k = 0; k < N; k++){    
            for(int i = 0; i < N; i++){          
                if(i==k) continue;      
                for(int j = 0; j < N; j++){
                    if(i==k||i==j) continue;
                    dis[i][j] = Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(dis[i][j]==MAX) dis[i][j] = 0;
                bw.write(String.valueOf(dis[i][j])+" ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/11404