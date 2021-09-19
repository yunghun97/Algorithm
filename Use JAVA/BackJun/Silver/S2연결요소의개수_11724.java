package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S2연결요소의개수_11724 {
    static ArrayList<ArrayList<Node>> list;
    static int V, M;
    static boolean[] isVisited, countArr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        isVisited = new boolean[V+1];
        countArr = new boolean[V+1];
        for(int i=0; i<V+1; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(a, b));
            list.get(b).add(new Node(b, a));
        }
        int answer = 0;
        for(int i=1; i<=V; i++){
            if(!countArr[i]){
                isVisited[i] = true;
                countArr[i] = true;
                answer++;
                dfs(i);
            }
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void dfs(int num){
        for(int i=0; i<list.get(num).size(); i++){
            int input = list.get(num).get(i).endNode;
            if(!isVisited[input]){
                isVisited[input] = true;
                countArr[input] = true;
                dfs(input);
            }
        }
    }
    static class Node{
        int startNode;
        int endNode;
        public Node(int startNode, int endNode){
            this.startNode = startNode;
            this.endNode = endNode;
        }
    }
}
//https://www.acmicpc.net/problem/11724