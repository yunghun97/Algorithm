package BackJun.Gold;

import java.io.*;
import java.util.*;

// 이분 그래프 개념
// 한 정점에서 갈 수 있는 각 정점의 색깔(이전에 방문했는지)이 다 달라야 한다.
// 모든 정점에서 다 탐색해야 된다. (색깔 칠하는 개념으로)
// bfs 사용
public class G4이분그래프_1707 {
    static int V,E;
    static int[] colores;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());   // 정점
            E = Integer.parseInt(st.nextToken());   // 간선
            list = new ArrayList<ArrayList<Integer>>();
            colores = new int[V+1];
            for(int i=0; i<=V; i++){
                list.add(new ArrayList<>());
            }
            for(int i=0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b); // 양뱡향 그래프이기 때문에 두개 다 저장
                list.get(b).add(a);
            }

            if(bfs()){
                bw.write("YES\n");
            }else{
                bw.write("NO\n");
            }
        }
        bw.flush();
    }
    private static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=V; i++){
            if(colores[i]==0){
                q.add(i);
                colores[i] = 1;
            }

            while(!q.isEmpty()){
                int num = q.poll();
                for(int x=0; x<list.get(num).size(); x++){
                    int node = list.get(num).get(x);
                    if(colores[node]==0){   // 처음 방문하는 노드면 기준 정점 색상의 반대를 넣어준다.
                        colores[node] = colores[num]*-1;
                        q.add(node);    // 처음 방문했기 때문에 q에 넣고 탐색
                    }else{
                        if(colores[node]==colores[num]){    // 이미 방문했던 노드 이면서 기준 정점과 색상이 같으면 이분 그래프가 아니다.
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}
