package BackJun.Silver;

import java.io.*;
import java.util.*;


public class S2DFS와BFS {
    static int nodeCount, order, start;
    static LinkedList<LinkedList<Node>> list;
    static BufferedWriter bw;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        nodeCount = Integer.parseInt(st.nextToken());
        order = Integer.parseInt(st.nextToken());
        start =Integer.parseInt(st.nextToken());
        list = new LinkedList<LinkedList<Node>>();
        for(int i=0; i<=nodeCount; i++){
            list.add(new LinkedList<Node>());
        }
        for(int i=0; i<order; i++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(new Node(from, to));
            list.get(to).add(new Node(to, from));
        }
        isVisited = new boolean[nodeCount+1];
        for(int i=0; i<list.size(); i++){
            Collections.sort(list.get(i), (o1, o2)->            // 종료 정점 기준 오름차순 정렬
            {
                return Integer.compare(o1.end, o2.end);
            });
        }
        dfs(start);
        bw.flush();
        isVisited = new boolean[nodeCount+1];
        bw.newLine();
        bfs();
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static void dfs(int num) throws IOException{
        if(!isVisited[num]){
            bw.write(""+num+" ");
            isVisited[num] = true;}
        else return;
        if(list.get(num).size()>=1){
            for(int i=0; i<list.get(num).size(); i++){
                int temp = list.get(num).get(i).end;
                if(!isVisited[temp]){
                    dfs(temp);
                }
            }
        }
    }


    private static void bfs() throws IOException{
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        isVisited[start] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            bw.write(""+temp+" ");
            if(list.get(temp).size()>=1){
                for(int i=0; i<list.get(temp).size(); i++){
                    int num = list.get(temp).get(i).end;
                    if(!isVisited[num]){
                        isVisited[num] = true;
                        q.add(num);
                    }
                }
            }
        }
        bw.newLine();
        
    }
    static class Node{
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Node [end=" + end + ", start=" + start + "]";
        }
        
    }
}
//https://www.acmicpc.net/problem/1260

/*
5 5 3
5 4
5 2
1 2
3 4
3 1

결과
3 1 2 5 4
3 1 4 2 5
*/