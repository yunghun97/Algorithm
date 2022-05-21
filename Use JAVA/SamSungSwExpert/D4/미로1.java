package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;
public class 미로1 {
    static int[][] map;
    static int[] dx = {-1,0,0,1}, dy ={0,-1,1,0};
    static int N;
    static Node startNode, endNode;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = 16;
        for(int t=1; t<=10; t++){            
            br.readLine();
            map = new int[N][N];
            for(int i=0; i<N; i++){
                String a= br.readLine();
                for(int j=0; j<N; j++){
                    char word = a.charAt(j);
                    if(word=='1'){
                        map[i][j] = 1;
                    }else if(word=='2'){
                        startNode = new Node(i, j);
                        map[i][j] = 2;
                    }else if(word=='3'){
                        endNode = new Node(i, j);
                        map[i][j] = 3;
                    }
                }
            }
            if(bfs()){
                bw.write("#"+t+" "+1+"\n");
            }else{
                bw.write("#"+t+" "+0+"\n");
            }

        } // 테케 끝
        bw.flush();
    }
    private static boolean bfs() {        
        boolean[][] isVisited = new boolean[N][N];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startNode.r, startNode.c));
        isVisited[startNode.r][startNode.c] = true;
        while(!q.isEmpty()){
            Node node = q.poll();
            if(node.r==endNode.r&&node.c==endNode.c) return true;
            for(int d=0; d<4; d++){
                int nr = node.r+ dx[d];
                int nc = node.c+ dy[d];
                if(outCheck(nr, nc)||map[nr][nc]==1||isVisited[nr][nc]) continue;
                isVisited[nr][nc] = true;
                q.add(new Node(nr,nc));
            }
        }
        return false;
    }
    private static boolean outCheck(int r, int c){
        if(r<0||r>=N||c<0||c>=N) return true;
        return false;
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV14vXUqAGMCFAYD&categoryId=AV14vXUqAGMCFAYD&categoryType=CODE&problemTitle=1226&orderBy=INQUERY_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1&&&&&&&&&&