package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S3프린터큐_1966 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            HashMap<Integer, Integer> hmap = new HashMap<>();
            Queue<Node> q= new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int level = Integer.parseInt(st.nextToken());
                hmap.put(level, hmap.getOrDefault(level, 0)+1);
                q.add(new Node(i, level));
            }
            int count = 1;            
            while(!q.isEmpty()){
                Node node = q.poll();
                
                if(maxCheck(node,hmap)){
                    q.add(node);
                    continue;                
                }else{
                    if(node.num==M){
                        break;
                    }
                    if(hmap.get(node.level)==1){
                        hmap.remove(node.level);
                    }else{
                        hmap.put(node.level, hmap.get(node.level)-1);
                    }
                    count++;
                }
            }
            bw.write(""+count);
            if(t!=T) bw.newLine();
            hmap.clear();
            q.clear();
        }
        bw.flush();
    }    
    private static boolean maxCheck(Node node, HashMap<Integer, Integer> hmap) {
        int nowLevel = node.level;
        for(int i=nowLevel+1; i<10; i++){
            if(hmap.containsKey(i)) return true;
        }
        return false;
    }
    static class Node{
        int num;
        int level;
        public Node(int num, int level){
            this.num = num;
            this.level = level;
        }
    }
}
// https://www.acmicpc.net/problem/1966