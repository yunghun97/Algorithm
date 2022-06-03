package BackJun.Gold;

import java.util.*;
import java.io.*;

public class G4RGB거리2_17404 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N+1][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<3; x++){
                arr[i][x] = Integer.parseInt(st.nextToken());
            }            
        }
        int INF = 1000*1000+1; // 최대 수는 N = 1000, 비용은 1000이므로 1000*1000+1로 설정
        int[][] result = new int[N+1][3];
        int answer = INF;
        for(int x=0; x<3; x++){ // 첫집을 어떤걸로 칠하는지 결정
            for(int y=0; y<3; y++){ // 해당 집 으로 칠하기 -> 나머지는 최대 수로 할당하여 해당 집을 고려하지 못하게 한다.
                if(x==y) result[1][y] = arr[1][y];
                else result[1][y] = INF;
            }
            for(int i=2; i<=N; i++){
                result[i][0] = Math.min(result[i-1][2], result[i-1][1]) + arr[i][0];
                result[i][1] = Math.min(result[i-1][0], result[i-1][2]) + arr[i][1];
                result[i][2] = Math.min(result[i-1][0], result[i-1][1]) + arr[i][2];
                if(i==N){ // 마지막 꺼 비교
                    for(int z=0; z<3; z++){ // 3번 비교해야 한다. x를 통해 칠한집 제외 하고 나머지로
                        if(x==z) continue;
                        answer = Math.min(answer, result[i][z]);
                    }
                }
            }
        }        
        bw.write(""+answer);
        bw.flush();
    }    
}
// https://www.acmicpc.net/problem/17404