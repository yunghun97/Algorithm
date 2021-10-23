package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5뱀_3190 {
    static int N, apple;
    static int[][] map;
    static boolean[][] appleMap, snakeMap;
    static int[] dx={0,1,0,-1}, dy={1,0,-1,0};
    static ArrayList<Order> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        apple = Integer.parseInt(br.readLine());
        map = new int[N][N];
        appleMap = new boolean[N][N];
        snakeMap = new boolean[N][N];
        list = new ArrayList<>();
        for(int i=0; i<apple; i++){
            st = new StringTokenizer(br.readLine());
            appleMap[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }
        int order = Integer.parseInt(br.readLine());
        for(int i=0; i<order; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Order(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }
        int answer = move();
        bw.write(""+answer);
        bw.flush();
    }    
    private static int move() {
        Deque<Node> dq = new ArrayDeque<>();
        int dir = 0;
        int orderCount = 0;
        int result = 0;
        snakeMap[0][0] = true;
        dq.add(new Node(0, 0));
        while(!dq.isEmpty()){
            int nr = dq.peekFirst().r+dx[dir];
            int nc = dq.peekFirst().c+dy[dir];
            if(nr<0||nr>=N||nc<0||nc>=N) return result+1;
            if(snakeMap[nr][nc]) return result+1;
            dq.addFirst(new Node(nr,nc));   // 그냥 add 하면 맨 뒤로 들어간다.
            snakeMap[nr][nc]=true;
            if(appleMap[nr][nc]){
                appleMap[nr][nc]=false;
            }else{
                snakeMap[dq.peekLast().r][dq.pollLast().c] = false;
            }
            result++;
            if(orderCount<list.size()){
                if(list.get(orderCount).time==result){
                    if(list.get(orderCount).direction=='D'){// 오른쪽
                        dir = (dir+1)%4;
                    }else{
                        dir = dir-1;
                        if(dir==-1) dir = 3;
                    }
                    orderCount++;
                }
            }
        }
        return result;
    }

    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static class Order{
        int time;
        char direction;
        public Order(int time, char direction){
            this.time = time;
            this.direction = direction;
        }
    }
}
//https://www.acmicpc.net/problem/3190