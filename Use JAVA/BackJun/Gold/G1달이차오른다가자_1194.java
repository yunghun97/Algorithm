package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G1달이차오른다가자_1194 {
    static int R,C,answer,index;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static char[][] map;
    static boolean [][][] isVisited;
    static Queue<Node> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[(int)Math.pow(2,6)][R][C];  // 부분집합 2^N 개수만큼 선언
        answer = 0;
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
        }
        q = new LinkedList<>();
        outer : for(int i=0; i<R; i++){ // 시작좌표 찾기
            for(int j=0; j<C; j++){
                if(map[i][j]=='0'){
                    q.add(new Node(i, j, 0, 0));   
                    break outer;
                }
            }
        }
        bfs();
        if(answer==0) bw.write(""+(-1));
        else bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void bfs() {
        while(!q.isEmpty()){
            Node node = q.poll();
            if(isVisited[node.key][node.r][node.c]) continue;   // 이미 방문했으면 continue
            isVisited[node.key][node.r][node.c] = true;   // 방문표시
            for(int d=0; d<4; d++){
                int nr = node.r +dx[d];
                int nc = node.c +dy[d];
                if(nr<0||nr>=R||nc<0||nc>=C) continue;
                if(map[nr][nc]=='#') continue; // 벽이면 탐색 X;
                if(map[nr][nc]=='.'){
                    q.add(new Node(nr, nc, node.key, node.time+1));
                    continue;
                }
                else if(map[nr][nc]=='1'){  // bfs -> 거리가 가장 적은거부터 탐색하므로 바로 return
                    answer = node.time+1;
                    return;
                }
                else if(map[nr][nc]=='0'){  // 다른 점에서 키를 가지고 되돌아 올 수도 있음
                    q.add(new Node(nr, nc, node.key, node.time+1));
                    continue;
                }
                else if("abcdef".contains(String.valueOf(map[nr][nc]))){ // a~f값 사이
                    q.add(new Node(nr,nc,node.key|(1<<map[nr][nc]-'a'),node.time+1));  // 비트 연산 결과(2진수) 1, 10, 100, 1000, 10000, 100000 맨 앞 비트로 키를 구분하면 된다. 
                                                                                       // 0000 0100 | 0000 0001 -> 0000 0101 -> C,A 키 값을 가진 상태
                    continue;
                }else{      // # . 0 1 a~f 가 아니므로 자동으로 A~F값일 때
                    if((node.key&(1<<map[nr][nc]-'A'))!=0){ // 키가 존재할 경우 키 검사 1, 10, 100, 1000, 10000, 100000을 빼서 같은 값이 있으면 최소 1이상의 값이 나오게 된다.
                                                            // 가진키값 & 현재 문에 필요한 키   111 & 100 = 100 -> 4    100 & 011 = 000 -> 0 -> 키가 없으면 0이 나옴
                        q.add(new Node(nr,nc,node.key,node.time+1));
                    }
                    continue;
                }
            }
        }
    }
    static class Node{
        int r;
        int c;
        int key;
        int time;
        public Node(int r, int c, int key, int time) {
            this.r = r;
            this.c = c;
            this.key = key;
            this.time = time;
        }
        @Override
        public String toString() {
            return "Node [c=" + c + ", key=" + key + ", r=" + r + ", time=" + time + "]";
        }
        
    }
}
//https://www.acmicpc.net/problem/1194