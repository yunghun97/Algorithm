package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G4이차원배열과연산_17140 {

    // R연산 행의 개수 >= 열개수
    // C 연산 열의 개수 > 행 개수
    // 배열 크기 100넘어가면 앞에 100개만 저장

    static int r,c,k;
    static int[][] defaultMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        defaultMap = new int[100][100];

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                defaultMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cal(0,0,3,3,defaultMap);
    }
    // 0 은 R 연산 1은 C 연산
    private static void cal(int time, int how, int r, int c, int[][] map) {
        
        if(time==100){
            return;
        }

    }
    
    static class Node{
        int num;
        int repeat;
    }
}
//https://www.acmicpc.net/problem/17140