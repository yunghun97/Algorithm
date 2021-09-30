package SamSungSwExpert.D6;

// 플로이드 와샬 or 다익스트라
// 각 정점에서 모든 정점을 탐색하기 위해 거치는 간선의 개수를 구하면 된다. ex 1번 정점에서 2,3,4,5 탐색하기 위해 거치는 간선의 수
import java.io.*;
import java.util.*;
public class 사람네트워크2 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int INF = 9999999;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int[][] map = new int[V][V];
            for(int i=0; i<V; i++){
                for(int j=0; j<V; j++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a==0) a = INF;
                    if(i==j) map[i][j] = 0;
                    else map[i][j] = a;
                }
            }
            for(int k = 0; k<V; k++){   // 경유지
                for(int i=0; i<V; i++){ //출발지
                    if(i==k) continue;
                    for(int j=0; j<V; j++){ // 도착지
                        if(j==i||j==k) continue;
                        map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                        
                    }
                }
            }
            // D[2][3] -> Min D[2][3], D[2][1] D[1][3] -> 2번에서 3번 정점으로 가는거 vs 2에서 1정점들렸다가 1->3으로 가는거
            int answer = INF;
            for(int i=0; i<V; i++){
                int count =0;
                for(int j=0; j<V; j++){ 
                    count+=map[i][j];
                }
                answer = Math.min(answer,count);
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }// 테케 끝
    }
}
//https://swexpertacademy.com/main/talk/solvingClub/problemView.do?solveclubId=AXqgPAMaIlADFATi&contestProbId=AV18P2B6Iu8CFAZN&probBoxId=AXvqSE8aQegDFATN+&type=PROBLEM&problemBoxTitle=0916-WS&problemBoxCnt=++2+