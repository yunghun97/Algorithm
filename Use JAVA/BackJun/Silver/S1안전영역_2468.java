package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1안전영역_2468 {
    static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
    static int N, maxHeight, minHeight, answer;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Node> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N]; // 방문체크용
        minHeight = 101;
        q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, a); // 최대높이
                minHeight = Math.min(minHeight, a); // 최소높이
                map[i][j] = a;
            }
        }
        answer = 1;
        for (int h = minHeight; h <= maxHeight; h++) { // 최소높이 -> 최대높이까지 반복
            for (int i = 0; i < N; i++) { // 초기화
                Arrays.fill(isVisited[i], false);
            }
            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !isVisited[i][j]) { // 잠기지 않고 방문 안했으면 BFS탐색실시
                        check(i, j, h);
                        result++; // BFS 끝날 때 마다 +1
                    }
                }
            }
            answer = Math.max(result, answer); // answer 최대 값 설정
        }
        bw.write("" + answer);
        bw.flush();
    }

    private static void check(int r, int c, int height) {
        q.add(new Node(r, c));  // 처음 좌표 추가
        isVisited[r][c] = true; // 처음 좌표 방문 표시
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] <= height || isVisited[nr][nc]) continue;   // 범위에서 벗어나거나, 잠긴 경우, 이미 체크한 경우 continue
                isVisited[nr][nc] = true;
                q.add(new Node(nr, nc));
            }
        }
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
