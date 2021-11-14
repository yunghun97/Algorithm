package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G1마법사상어와블리자드_21611 {
    static int[][] map;
    static int[] dx = { 0, 1, 0, -1 }, dy = { -1, 0, 1, 0 };
    static int N, M, sR, sC, answer;
    static Queue<Magic> q;
    static Queue<Node> boomQ;
    static Queue<Integer> groupQ;
    static boolean isBoom;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        answer = 0;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        groupQ = new LinkedList<>(); 
        boomQ = new LinkedList<>();
        q = new LinkedList<>();
        isBoom = true;
        sR = N / 2; // 기준 핼
        sC = N / 2; // 기준 열
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            if (d == 1)
                d = 3;
            else if (d == 2)
                d = 1;
            else if (d == 3)
                d = 0;
            else{
                d = 2;
            }
            q.add(new Magic(d, Integer.parseInt(st.nextToken())));
        }
        while (!q.isEmpty()) {
            bllizard(q.poll());
            fill(sR, sC, 0, 1, 0);
            while (isBoom) {
                isBoom = false;
                boom(sR, sC, 0, 1, 0,map[sR+dx[0]][sC+dy[0]]);
                fill(sR, sC, 0, 1, 0);      
            }
            isBoom = true;
            group(sR, sC, 0, 1, 0,map[sR+dx[0]][sC+dy[0]],0);
            for(int i=0; i<N; i++) Arrays.fill(map[i], 0);  // map 초기화
            groupFill(sR, sC, 0, 1, 0);
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }


    private static void fill(int r, int c, int dir, int distance, int twoCheck) { // 채울 구슬 탐색
        if (twoCheck == 2) {
            ++distance;
            twoCheck = 0;
        }
        int nr = r;
        int nc = c;
        for (int d = 0; d < distance; d++) {
            nr += dx[dir];
            nc += dy[dir];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                return; // 벽 밖이므로 탐색 X
            if (map[nr][nc] == 0) {
                int result = move(nr, nc, dir, distance, twoCheck, d + 1);
                if (result == 0)
                    return; // 뒤에 숫자가 0 이므로 더 이동 불가능하다.
                else {
                    map[nr][nc] = result;
                }
            } else
                continue;
        }
        twoCheck++;
        fill(nr, nc, (dir + 1) % 4, distance, twoCheck);
    }

    private static void bllizard(Magic magic) { // 부수기
        int nr = sR;
        int nc = sC;
        for (int d = 0; d < magic.distance; d++) {
            nr += dx[magic.dir];
            nc += dy[magic.dir];
            map[nr][nc] = 0;
        }
    }

    private static int move(int r, int c, int dir, int distance, int twoCheck, int nowDistance) { // 구슬 움직이기
        if (distance == nowDistance) {
            dir = (dir + 1) % 4;
            nowDistance = 0;
            twoCheck++;
        }
        if (twoCheck == 2) {
            ++distance;
            twoCheck = 0;
        }
        int nr = r;
        int nc = c;
        int result = 0;
        for (int d = nowDistance; d < distance;) {
            nr += dx[dir];
            nc += dy[dir];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N)
                return 0;
            else {
                result = map[nr][nc];
                if (result == 0) {
                    result = move(nr, nc, dir, distance, twoCheck,d+1);
                    break;
                } else {
                    map[nr][nc] = 0;
                    return result;
                }
            }
        }
        return result;
    }

    private static void boom(int r, int c, int dir, int distance, int twoCheck, int num) {
        if (twoCheck == 2) {
            ++distance;
            twoCheck = 0;
        }
        int nr = r;
        int nc = c;
        for (int d = 0; d < distance; d++) {
            nr += dx[dir];
            nc += dy[dir];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc]==0){
                if(boomQ.size()>=4){
                    while(!boomQ.isEmpty()){
                        Node node = boomQ.poll();
                        answer += map[node.r][node.c];
                        map[node.r][node.c] = 0;
                        isBoom = true;
                    }
                }
                boomQ.clear();
                return;
            }
            else{
                if(num==map[nr][nc]){
                    boomQ.add(new Node(nr,nc));
                    continue;
                }else{
                    num = map[nr][nc];
                    if(boomQ.size()>=4){
                        while(!boomQ.isEmpty()){
                            Node node = boomQ.poll();
                            answer += map[node.r][node.c];
                            map[node.r][node.c] = 0;
                            isBoom = true;
                        }
                    }else{
                        boomQ.clear();
                        boomQ.add(new Node(nr,nc));
                    };
                }
            }
        }
        twoCheck++;
        boom(nr, nc, (dir + 1) % 4, distance, twoCheck, num);
    }

    private static void groupFill(int r, int c, int dir, int distance, int twoCheck) {      
        if (twoCheck == 2) {
            ++distance;
            twoCheck = 0;
        }
        int nr = r;
        int nc = c;
        for (int d = 0; d < distance; d++) {
            nr += dx[dir];
            nc += dy[dir];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N){
                groupQ.clear();
                return;
            }
            if(groupQ.size()>0){
                map[nr][nc] = groupQ.poll();
            }
            else return;
        }
        twoCheck++;
        
        groupFill(nr, nc, (dir + 1) % 4, distance, twoCheck);

    }

    private static void group(int r, int c, int dir, int distance, int twoCheck, int num, int repeat) {
        if (twoCheck == 2) {
            ++distance;
            twoCheck = 0;
        }
        int nr = r;
        int nc = c;
        for (int d = 0; d < distance; d++) {
            nr += dx[dir];
            nc += dy[dir];
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc]==0){
                groupQ.add(repeat);
                groupQ.add(num);
                return;
            }
            else{
                if(num==map[nr][nc]){
                    repeat++;
                }else{
                    groupQ.add(repeat);
                    groupQ.add(num);
                    repeat = 1;
                    num = map[nr][nc];
                }
            }
        }
        twoCheck++;
        
        group(nr, nc, (dir + 1) % 4, distance, twoCheck, num, repeat);
    }


    static class Magic {
        int dir;
        int distance;

        public Magic(int dir, int distance) {
            this.dir = dir;
            this.distance = distance;
        }
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
