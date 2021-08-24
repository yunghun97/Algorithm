package BackJun.Silver;
import java.io.*;
import java.util.*;
public class S5참회밭_2477 {    // 1 동 2 서 3 남 4 북
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int avail = Integer.parseInt(br.readLine());
        int[][] map = new int[6][2];
        int[] all = new int[2];
        int[] fake = new int[2];
        for(int i=0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            map[i][0] = direction;
            map[i][1] = size;   
        }
        int longR =0;
        int longC =0;
        
        for(int i=0; i<6; i++){         // 가장 긴 세로변의 |좌-우| = 빈 공간의 세로 길이   // 가장 긴 가로변의 |좌-우| = 빈 공간의 가로 길이
        int direction = map[i][0];
        int size = map[i][1];
        if(direction==3||direction==4){
            if(size>all[0]){
                all[0] = size;
                longR=i;
            }
        }
        if(direction==1||direction==2){
            if(size>all[1]){
                all[1] = size;
                longC=i;
            }
        }
    }
    if(longR==0) fake[0] = Math.abs(map[5][1]-map[1][1]);
    else if(longR==5) fake[0] = Math.abs(map[4][1]-map[0][1]);
    else fake[0] = Math.abs(map[longR-1][1]-map[longR+1][1]);

    if(longC==0) fake[1] = Math.abs(map[5][1]-map[1][1]);
    else if(longC==5) fake[1] = Math.abs(map[4][1]-map[0][1]);
    else fake[1] = Math.abs(map[longC-1][1]-map[longC+1][1]);
    

    int answer = ((all[0]*all[1]) - (fake[0]*fake[1]))*avail;
    bw.write(""+answer);
    bw.flush();
    bw.close();
    br.close();
    
    }
}
//https://www.acmicpc.net/problem/2477
/*
입력
7
4 50
2 160
3 30
1 60
3 20
1 100
출력
47600
*/