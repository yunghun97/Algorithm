package SSFAlgorithmLearn.Day9;
import java.io.*;
import java.util.*;

public class MSTPrimTest {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] adjMatrix = new int[N][N]; 
        boolean[] visited = new boolean[N];  // 포함여부 확인
        int[] minEdge = new int[N];     // 최솟값 저장 배열
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(in.readLine());
            for(int j=0; j<N; j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int result = 0;
        minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅(최솟값 으로);

        for(int i=0; i<N; i++){
            // 1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
            int min = Integer.MAX_VALUE;
            int minVertex = -1; // 최소간선비용의 정점 번호
            for(int j=0; j<N; j++){
                if(!visited[j] && min>minEdge[j]){
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            visited[minVertex] = true; // 신장트리에 포함시킴
            result += min; // 결과에 누적
            //2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
            for(int j=0; j<N; j++){
                if(!visited[j]&& adjMatrix[minVertex][j]!=0 &&minEdge[j]>adjMatrix[minVertex][j]){
                    minEdge[j] = adjMatrix[minVertex][j];
                }
            }

        }
        
        System.out.println(result);
    }
    
}
