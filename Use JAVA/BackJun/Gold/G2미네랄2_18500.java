package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2미네랄2_18500 {
    static int R, C, N;
    static boolean[][] map;
    static int[][] cluster;
    static boolean[][] isVisited;
    static int[] dx = { -1, 0, 0, 1 }, dy = { 0, 1, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        cluster = new int[R][C];
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (arr[j] == 'x')
                    map[i][j] = true;
            }
        }
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int x = 0; x < N; x++) {
            // 높이 1이 바닥, R = 최상
            int height = R - Integer.parseInt(st.nextToken());
            if (x % 2 == 0) { // 왼쪽에서 오른쪽
                throwToRight(height);
            } else { // 오른쪽에서 왼쪽
                throwToLeft(height);
            }
            for (int r = 0; r < R; r++) {   // 클러스터 map, 방문 체크 배열 초기화
                Arrays.fill(cluster[r], 0);
                Arrays.fill(isVisited[r], false);
            }
            int clusterCount = checkCluster();

            for (int r = 0; r < R; r++) { // 방문 체크 배열 초기화, map 초기화
                Arrays.fill(isVisited[r], false);
                Arrays.fill(map[r],false);
            }
            moveCluster(clusterCount);
            if(x==N-1) break;   // 마지막 명령인 경우 map을 다시 세팅하지 않는다 -> 시간 절약
            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    if(cluster[r][c]!=0) map[r][c] = true;
                }
            }        
        }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(cluster[r][c]!=0) bw.write('x');
                else bw.write('.');
            }
            bw.newLine();
        }
        bw.flush();
    }

    /**
     * 생성된 클러스터맵을 통해 클러스터 떨구기
     * @param clusterCount 클러스터 개수 ex) 5 -> 클러스터가 5개
     */
    private static void moveCluster(int clusterCount) {
        boolean[] endCluster = new boolean[clusterCount + 1];
        endCluster[0] = true;
        int endCount = 0;
        for (int c = 0; c < C; c++) { // 맨 아래 행 체크
            if (!endCluster[cluster[R - 1][c]]) {   // 처음 바닥에 있는 클러스터 체크해주기                
                endCluster[cluster[R - 1][c]] = true;   // 해당번호 클러스터 방문 표시
                endCount++; // 끝난 클러스터 개수 추가
            }
        }
        ArrayList<Node> list = new ArrayList<>();   // 해당 클러스터 좌표 저장하기 위한 ArrayList
        Queue<Node> q = new LinkedList<>(); // bfs 탐색용 q
        while (endCount < clusterCount) {
            for (int r = R - 1; r >= 0; r--) {
                for (int c = 0; c < C; c++) {
                    if (!endCluster[cluster[r][c]]) {   // 끝난 클라스터가 아닐 경우
                        int num = cluster[r][c];    // num : 클러스터 번호
                        isVisited[r][c] = true; // 방문체크
                        list.add(new Node(r, c, num));  // list에 저장
                        q.add(new Node(r, c, num)); // q 추가
                        while (!q.isEmpty()) {  // BFS 탐색
                            Node node = q.poll();
                            for (int d = 0; d < 4; d++) {
                                int nr = node.r + dx[d];
                                int nc = node.c + dy[d];
                                if (nr < 0 || nr >= R || nc < 0 || nc >= C || isVisited[nr][nc]
                                        || cluster[nr][nc] != num)
                                    continue;
                                isVisited[nr][nc] = true;
                                q.add(new Node(nr, nc, num));  
                                list.add(new Node(nr, nc, num));
                            }
                        }
                        // 끝나지 않은 클러스터가 list에 존재한다.                        
                        int downCount = 1;  // 몇칸 내려갈지 정하기
                        outer : while(true){    // 바닥에 도달하지 못하면
                            for(Node node : list){
                                int nr = node.r+downCount;  // 1칸씩 아래로 내려가기
                                int nc = node.c;
                                if(nr==R||(cluster[nr][nc]!=0&&cluster[nr][nc]!=num)){  // 벽 밖으로 나가거나 해당 칸에 다른 클러스터가 존재할 경우                                    
                                    break outer;    // while문 빠져나가기
                                }
                            }
                            downCount++;    // +1 칸씩 더 내려가도록
                        }
                        for(Node node : list){  // list(해당 번호 클러스터의 좌표 모음)
                            cluster[node.r][node.c] = 0;   // 초기좌표 0 으로 만들기
                        }
                        for(Node node : list){
                            cluster[node.r+downCount-1][node.c] = num;  // 중력으로 내려가는 좌표 해당 클러스터 번호로 세팅 (벽 밖으로 나가거나 해당 칸위치가 downCount 이므로 -1)
                        }
                        endCluster[num] = true; // 해당 클러스터 끝남 체크
                        endCount++; // 끝난 클러스터 개수 추가
                        list.clear();   // list 비워주기
                    }
                }
            }
        }
    }
    /**
     * 클러스터를 찾아서 클러스터 번호매겨서 cluster[][] 세팅
     * @return
     */
    private static int checkCluster() {
        int num = 0;
        Queue<Node> q = new LinkedList<>();
        for (int r = R - 1; r >= 0; r--) {
            for (int c = 0; c < C; c++) {
                if (isVisited[r][c])
                    continue;
                if (map[r][c]) {
                    ++num;
                    cluster[r][c] = num;
                    isVisited[r][c] = true;
                    q.add(new Node(r, c, num));
                    while (!q.isEmpty()) {
                        Node node = q.poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = node.r + dx[d];
                            int nc = node.c + dy[d];
                            if (nr < 0 || nr >= R || nc < 0 || nc >= C || isVisited[nr][nc] || !map[nr][nc])
                                continue;
                            isVisited[nr][nc] = true;
                            cluster[nr][nc] = num;
                            q.add(new Node(nr, nc, num));
                        }
                    }
                }
            }
        }
        return num;
    }
    /**
     * 왼쪽으로 던지는 메소드
     * @param height 던지는 높이
     */
    private static void throwToLeft(int height) {
        for (int c = C - 1; c >= 0; c--) {
            if (map[height][c]) {
                map[height][c] = false;
                return;
            }
        }
    }
    /**
     * 오른쪽으로 던지는 메소드
     * @param height 던지는 높이
     */
    private static void throwToRight(int height) {
        for (int c = 0; c < C; c++) {
            if (map[height][c]) {
                map[height][c] = false;
                return;
            }
        }
    }

    static class Node {
        int r;
        int c;
        int num;

        public Node(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }
    }
}
// https://www.acmicpc.net/problem/18500