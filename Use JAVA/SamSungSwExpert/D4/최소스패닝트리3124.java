package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;
public class 최소스패닝트리3124 {
    static int V,E;
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());                    
            E = Integer.parseInt(st.nextToken());
            ArrayList<Node> list = new ArrayList<>();
            for(int i =0; i<E; i++){
                st = new StringTokenizer(br.readLine());
                list.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
            parent = new int[V+1];
            make();
            long answer = 0; int Vcount =0;
            Collections.sort(list);
            for(int i=0; i<E; i++){
                if(union(list.get(i).start,list.get(i).end)){
                    answer+=list.get(i).weight;
                    Vcount++;
                }
                if(Vcount==V-1){
                    break;
                }
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();

        }// 테케 끝
        bw.close();
        br.close();
    }
    private static boolean union(int start, int end) {
        int a = find(start);
        int b = find(end);
        if(a==b) return false;
        parent[b] = a;
        return true;
        
    }
    private static int find(int start) {
        if(parent[start]==start) return start;
        return parent[start] = find(parent[start]);
    }
    private static void make() {
        for(int i=1; i<=V; i++){
            parent[i] = i;
        }
    }
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return "Node [end=" + end + ", start=" + start + ", weight=" + weight + "]";
        }
        
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV_mSnmKUckDFAWb&categoryId=AV_mSnmKUckDFAWb&categoryType=CODE&problemTitle=%EC%B5%9C%EC%86%8C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1