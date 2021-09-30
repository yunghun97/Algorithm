package SamSungSwExpert.D4;

import java.io.*;
import java.util.*;

public class 보급로 {
    static int[][] arr, distance;
    static char[][] temp;
    static int N;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static boolean[][] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            distance = new int[N][N];
            temp = new char[N][N];
            isVisited = new boolean[N][N];
            for(int i=0; i<N; i++){
                temp[i] = br.readLine().toCharArray();  // 공백이 없어서 
                for(int j=0; j<N; j++){
                    arr[i][j] = temp[i][j] - 48;
                    distance[i][j] = 9999999;
                }
            }
            bw.write("#"+t+" "+move()+"\n");
            bw.flush();
        } //테케 끝
        bw.close();
        br.close();
    }
    private static int move() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.weight, o2.weight));
        distance[0][0] = arr[0][0];
        pq.add((new Node(0, 0, distance[0][0])));
        isVisited[0][0] =true;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int r = node.r;
            int c = node.c;
            if(r==N-1&&c==N-1) return distance[r][c];
            for(int d=0; d<4; d++){
                int nr = r + dx[d];
                int nc = c + dy[d];
                if(nr<0||nr>=N||nc<0||nc>=N) continue;
                if(isVisited[nr][nc]) continue;
                if(distance[nr][nc]>distance[r][c]+arr[nr][nc]){  // arr은 해당정점으로 가는 가중치, dis는 해당정점까지 가는데 걸리는 총 시간
                    distance[nr][nc] = distance[r][c]+arr[nr][nc];
                    isVisited[nr][nc] = true;
                    pq.add(new Node(nr, nc, distance[nr][nc]));
                }
            }
        }
        return 0;
    }
    static class Node{
        int r;
        int c;
        int weight;
        public Node(int r, int c, int weight) {
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
        
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15QRX6APsCFAYD&categoryId=AV15QRX6APsCFAYD&categoryType=CODE&problemTitle=%EB%B3%B4%EA%B8%89%EB%A1%9C&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1