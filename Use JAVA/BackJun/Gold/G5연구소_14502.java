package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5연구소_14502 {
        static ArrayList<Node> list;
        static ArrayList<Node> Viruslist;
        static int R,C;
        static int[][] map;
        static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        list = new ArrayList<>();
        Viruslist = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        int wallCount = 0;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){ 
                int a = Integer.parseInt(st.nextToken());
                if(a==0) list.add(new Node(i,j));
                else if(a==1){
                    map[i][j] = a;
                    wallCount++;
                }
                else{
                    map[i][j] = a;
                    Viruslist.add(new Node(i, j));
                }
            }
        }
        int max = R*C-wallCount-Viruslist.size()-3;   // 최대 값
        int answer = 0;
        outer : for(int x=0; x<list.size()-2; x++){ // 1,2,3 벽 == 3,2,1이므로 중복이 없도록 하기위해서 다음꺼 부터 탐색
            for(int y=x+1; y<list.size()-1; y++){
                for(int z = y+1; z<list.size(); z++){
                    int[][] copyMap = mapCopy();
                    copyMap[list.get(x).r][list.get(x).c] = 1;  // 벽 가로 막기
                    copyMap[list.get(y).r][list.get(y).c] = 1;
                    copyMap[list.get(z).r][list.get(z).c] = 1;


                    Queue<Node> q = new LinkedList<>();
                    for(int i=0; i<Viruslist.size(); i++){  // 바이러스 좌표 저장
                        q.add(new Node(Viruslist.get(i).r,Viruslist.get(i).c));
                    }
                    int vCount = 0;
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        vCount++;
                        for(int d=0; d<4; d++){
                            int nr = node.r + dx[d];
                            int nc = node.c + dy[d];
                            if(nr<0||nr>=R||nc<0||nc>=C) continue;
                            if(copyMap[nr][nc]==1||copyMap[nr][nc]==2) continue;    // 바이러스거나 벽 -> 전파할 수 없음
                            copyMap[nr][nc] = 2;    // 바이러스 전파 
                            q.add(new Node(nr,nc)); // 전파된 좌표 큐에 넣기
                        }
                    }
                    answer = Math.max(answer, R*C-vCount-wallCount-3);
                    if(answer==max) break outer;    // 이미 최대 공간이므로 더 볼 필요없이 break;
                }
            }
        }
        bw.write(""+answer);
        bw.flush();
    }
    private static int[][] mapCopy() {
        int[][] temp = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }
    static class Node{
        int r;
        int c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
//https://www.acmicpc.net/problem/14502