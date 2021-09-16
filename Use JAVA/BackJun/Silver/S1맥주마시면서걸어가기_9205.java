package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1맥주마시면서걸어가기_9205 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int conShop = Integer.parseInt(br.readLine());
            boolean check = false;
            boolean[] isVisited = new boolean[conShop+2];
            int[][] map = new int[conShop+2][2];
            
            for(int i=0; i<conShop+2; i++){
                st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(0, map[0][0],map[0][1]));
            outer : while(!q.isEmpty()){
                Node node = q.poll();
                if(isVisited[node.num]) continue;   // 이미 탐색했으면 탐색 안함
                isVisited[node.num] = true;
                for(int i=0; i<conShop+2; i++){
                    if(!isVisited[i]){
                        if(Math.abs(node.x-map[i][0])+Math.abs(node.y-map[i][1])<=1000){    // 좌표 조건
                            q.add(new Node(i,map[i][0],map[i][1]));
                            if(i==conShop+1){   // 마지막 페스티벌 좌표가 조건 만족 시 더 볼 필요없이 break;
                                check = true;
                                break outer;
                            }
                        }
                    }else continue;
                }
            }
            if(check) bw.write("happy\n");
            else bw.write("sad\n");
            bw.flush();
        }
    }
    static class Node{
        int num;
        int x;
        int y;
        public Node(int num,int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
        
    }
}

//https://www.acmicpc.net/problem/9205