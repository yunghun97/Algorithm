package BackJun.Silver;
import java.io.*;
import java.util.*;
public class S3바이러스_2606 {
    static boolean[] isVisited;
    static ArrayList<ArrayList<Node>> list;
    static Queue<Integer> q;
    static int answer;
    public static void main(String[] args) throws FileNotFoundException, IOException{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        q = new LinkedList<>();
        list = new ArrayList<>();
        int com = Integer.parseInt(br.readLine());
        int connect = Integer.parseInt(br.readLine());
        answer = 0;
        isVisited = new boolean[com+1];
        for(int i=0; i<=com; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<connect; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(a, b));    // 시작점과 도착점, 도착점과 출발점 저장 -> 양 방향 그래프이므로
            list.get(b).add(new Node(b, a));
        }
        q.add(1);   // 1번 부터 시작
        isVisited[1] = true;    // 1번 방문 표시
        bfs();

        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=0; i<list.get(num).size(); i++){
                if(!isVisited[list.get(num).get(i).end]){
                    answer++;
                    q.add(list.get(num).get(i).end);
                    isVisited[list.get(num).get(i).end] = true;
                }
            }
        }
    }

    static class Node{
        int start;
        int end;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
//https://www.acmicpc.net/problem/2606