package Softeer2021모의알고리즘코딩대회;
import java.util.*;
import java.io.*;

// 다익스트라 쓰면 된다.
public class test3
{
    static int N;
    static boolean[] isVisited;
    static ArrayList<Navi>[] list;
    static int[] dis;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N];
        dis = new int[N];
        isVisited = new boolean[N];
        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int w = Integer.parseInt(st.nextToken());
                if(j==i){                    
                    continue;
                }
                list[i].add(new Navi(j,w));
            }
        }
        Arrays.fill(dis, Integer.MAX_VALUE);

        cal();
        long answer = 0;
        for(int i=0; i<N; i++){
            answer+=dis[i];
        }
        bw.write(""+answer);
        bw.flush();
    }
    static void cal(){
        dis[0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.sumTime,o2.sumTime));
        pq.add(new Node(0,0));        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(isVisited[node.startPoint]) continue;
            isVisited[node.startPoint] = true;
            for(int i=0; i<list[node.startPoint].size(); i++){
                Navi navi = list[node.startPoint].get(i);
                if(isVisited[navi.endPoint]) continue;
                if(dis[navi.endPoint]>navi.time){
                    dis[navi.endPoint]=navi.time;
                    pq.add(new Node(navi.endPoint, dis[navi.endPoint]));
                }
            }
            if(endCheck()) return;
        }
    }

    // 전부 다 연결되면 true return
    static boolean endCheck(){
        for(int i=0; i<N; i++){
            if(!isVisited[i]) return false;
        }
        return true;        
    }
    static class Navi{
        int endPoint;
        int time;
        public Navi(int endPoint, int time){
            this.endPoint = endPoint;
            this.time = time;
        }
    }
    static class Node{
        int startPoint;
        int sumTime;
        public Node(int startPoint, int sumTime){
            this.startPoint = startPoint;
            this.sumTime = sumTime;
        }
    }
}