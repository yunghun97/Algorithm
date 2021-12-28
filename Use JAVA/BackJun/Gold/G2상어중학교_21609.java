package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2상어중학교_21609 {
    static int N, COLORCOUNT, answer, RAINBOW;
    static int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
    static int[][] map;
    static boolean[][] isVisited;   // 방문 배열
    static Node maxNode;    // 최대 블록그룹 시작 점 저장
    static boolean end; // 끝 표시

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        COLORCOUNT = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isVisited = new boolean[N][N];
        RAINBOW = 999;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 0)
                    map[i][j] = RAINBOW;
                else
                    map[i][j] = a;
            }
        }
        maxNode = new Node(0, 0);
        answer = 0;
        end = false;
        // 초기 세팅 끝

        while (true) {
            checkMax();
            if (end)    // 블록 그룹 크기가 2이상이 없을 경우 break;
                break;
            removeBlock();
            gravity();
            rotate();
            gravity();
        }

        bw.write("" + answer);
        bw.flush();
    }

    private static void rotate() {  // 반 시계 90 회전 메소드
        int[][] tmpMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmpMap[N - 1 - j][i] = map[i][j];
            }
        }
        for (int i = 0; i < N; i++)
            System.arraycopy(tmpMap[i], 0, map[i], 0, N);
    }

    // 중력 적용 메소드
    private static void gravity() {
        for (int x = 0; x < N; x++) {
            for (int i = N - 1; i > 0; i--) {
                if (map[i][x] == 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (map[j][x] == 0)
                            continue;
                        else if (map[j][x] == -1)
                            break;
                        else {
                            map[i][x] = map[j][x];
                            map[j][x] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void removeBlock() { // 찾은 최대 블록그룹 지우는 부분
        resetVisit();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(maxNode.r, maxNode.c));
        isVisited[maxNode.r][maxNode.c] = true;
        int block = map[maxNode.r][maxNode.c];
        map[maxNode.r][maxNode.c] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || isVisited[nr][nc] || map[nr][nc] == -1)
                    continue;
                if (map[nr][nc] == block || map[nr][nc] == RAINBOW) {
                    q.add(new Node(nr, nc));
                    isVisited[nr][nc] = true;
                    map[nr][nc] = 0;
                } else
                    continue;
            }
        }
    }

    private static void checkMax() { // 최대 블록좌표 찾는 메소드
        int count = 0;
        int rainbowCount = 0;
        resetVisit();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == -1 || map[i][j] == 0 || map[i][j] == RAINBOW || isVisited[i][j])
                    continue;
                int tmp[] = blockCount(i, j);
                if (tmp[0]<2) continue;
                if (tmp[0] > count) {   // count가 더 크면 새로 바꿔줌
                    maxNode.r = i;
                    maxNode.c = j;
                    count = tmp[0];
                    rainbowCount = tmp[1];
                } else if (tmp[0] == count) {   // count가 같을 경우
                    if (tmp[1] >= rainbowCount) {   // 무지개 개수가 같거나 클 때만 바꿔주기
                        maxNode.r = i;
                        maxNode.c = j;
                        rainbowCount = tmp[1];
                    }
                }
            }
        }
        if (count < 2) {    // 블록그룹 2보다 작을 경우
            end = true;
            return;
        }
        answer += (int) Math.pow(count, 2);
        return;
    }

    private static void resetVisit() { // 방문체크 배열 초기화
        for (int i = 0; i < N; i++)
            Arrays.fill(isVisited[i], false);
    }

    private static int[] blockCount(int r, int c) { // 연결된 블록개수 return하는 메소드 
        Queue<Node> rainBowQ = new LinkedList<>();
        int result[] = new int[2];
        int block = map[r][c];
        int count = 1;
        int rainbowBlock = 0;
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(r, c));
        isVisited[r][c] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = node.r + dx[d];
                int nc = node.c + dy[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || isVisited[nr][nc] || map[nr][nc] == -1)
                    continue;
                if (map[nr][nc] == block || map[nr][nc] == RAINBOW) {
                    if (map[nr][nc] == RAINBOW) {
                        rainbowBlock++;
                        rainBowQ.add(new Node(nr,nc));
                    }
                    q.add(new Node(nr, nc));
                    count++;
                    isVisited[nr][nc] = true;
                } else
                    continue;
            }
        }
        result[0] = count;
        result[1] = rainbowBlock;
        while(!rainBowQ.isEmpty()){
            Node node = rainBowQ.poll();
            isVisited[node.r][node.c] = false;
        }
        return result;
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
//https://www.acmicpc.net/problem/21609