package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1맥주마시면서걸어가기_9205_fw {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int conShop = Integer.parseInt(br.readLine());
            int[][] dist = new int[conShop+2][conShop+2];
            int[][] arr = new int[conShop+2][2];
            
            for(int i=0; i<conShop+2; i++){
                st = new StringTokenizer(br.readLine());
                arr[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            }

            for(int i=0; i<conShop+2; i++){
                for(int j=0; j<conShop+2; j++){
                    if(i==j) continue;
                    if(Math.abs(arr[i][0]-arr[j][0])+Math.abs(arr[i][1]-arr[j][1])<=1000) dist[i][j] = 1;
                    else dist[i][j] = 102;
                }
            }
            for(int k=0; k<conShop+2; k++){ // 경유
                for(int i=0; i<conShop+2; i++){ // 출발
                    if(k==i) continue;
                    for(int j=0; j<conShop+2; j++){ // 도착
                        if(i==j||k==j) continue;
                        dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                    }
                }
            }
            bw.write(dist[0][conShop+1]<102 ? "happy\n" : "sad\n");
            bw.flush();
        }
    }
}

//https://www.acmicpc.net/problem/9205