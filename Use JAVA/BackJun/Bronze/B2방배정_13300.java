package BackJun.Bronze;

import java.io.*;
import java.util.*;

public class B2방배정_13300 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int roomSize = Integer.parseInt(st.nextToken());
        int[][] student = new int[2][7];
        int answer=0;
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            student[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
        }
        for(int i=0; i<2; i++){
            for(int j=1; j<7; j++){
                if(student[i][j]<=0) continue;
                int temp = student[i][j];
                while(temp>0){
                    temp -= roomSize;
                    answer++;
                }
            }
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();

    }
}
//https://www.acmicpc.net/problem/13300
/*
입력
16 2
1 1
0 1
1 1
0 2
1 2
0 2
0 3
1 3
1 4
1 3
1 3
0 6
1 5
0 5
1 5
1 6
결과
12
*/