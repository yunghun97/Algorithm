package SSFAlgorithmLearn.Day8;

import java.io.*;
import java.util.*;



public class AdhMatrixTest {
    static int N;
    static boolean[][] adjMatrix;
    public static void main(String[] args)  throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        adjMatrix = new boolean[N][N];
        int C = Integer.parseInt(in.readLine());
        for(int i=0; i<C; i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[to][from] = adjMatrix[from][to]= true;
        }
        System.out.println("==============bfs=================");
        bfs();
        System.out.println("===============dfs===================");
        boolean[] vistied = new boolean[N];
        dfs(0, vistied);
    }
    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visit = new boolean[N];

        queue.offer(0);
        visit[0] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println((char)(current+65));

            for(int i=0; i<N; i++){
                if(!visit[i] // 미방문
                    && adjMatrix[current][i]) // 인접 정점
            {
                queue.offer(i);
                visit[i] = true;
            }
        }
        
    }
}
    private static void dfs(int current, boolean[] visited){
        visited[current] =true;
        System.out.println((char)(current+65));

        for(int i=0; i<N; i++){
            if(!visited[i] && adjMatrix[current][i]){
                dfs(i, visited);
            }
        }
    }
        
}

