package Programmers.Lv3;

public class Lv3가장먼노드 {
    /*
        import java.util.*;
class Solution {
    static ArrayList<Integer>[] list;
    static boolean[] isVisited;
    static int[] dis;
    public int solution(int n, int[][] edge) {
        list = new ArrayList[n+1];
        isVisited = new boolean[n+1];
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        for(int i=0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<edge.length; i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        int max = cal();
        int answer=0;
        for(int i=1; i<=n; i++){
            if(dis[i]==max) answer++;
        }
        return answer;
    }
    int cal(){
        int max = 0;
        dis[1] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0; i<list[num].size(); i++){
                if(dis[list[num].get(i)]>dis[num]+1){
                    dis[list[num].get(i)]=dis[num]+1;
                    q.add(list[num].get(i));
                    max = Math.max(max,dis[list[num].get(i)]);
                }
            }
            
        }
        return max;
    }
}




    */
}
