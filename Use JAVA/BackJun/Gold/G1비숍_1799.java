package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G1비숍_1799 {
    private static int N, whiteCount, blackCount;
    private static ArrayList<Node> blackList, whilteList;
    private static boolean[][] map;
    private static int[] dx = { -1, -1 }, dy = { -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        whiteCount = 0;
        blackCount = 0;
        blackList = new ArrayList<>();
        whilteList = new ArrayList<>();
        int index = 0;
        boolean swap = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            if(N%2==0){
                if(swap){
                    index = 1;
                    swap = false;
                }else{
                    index = 0;
                    swap = true;
                }
            }
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    if (index % 2 == 0)
                        blackList.add(new Node(i, j));
                    else
                        whilteList.add(new Node(i, j));
                }
                index++;
            }
        }
        // N^2 만큼 possible 체크 실행

        blackCheck(0, 0);
        whiteCheck(0, 0);
        int answer = whiteCount + blackCount;
        bw.write("" + answer);
        bw.flush();
    }

    // 흰색칸에 있는 비숍 개수
    private static void whiteCheck(int cnt, int count) {
        if (whiteCount >= whilteList.size() - cnt + count)
            return;
        if (cnt == whilteList.size()) {
            whiteCount = Math.max(whiteCount, count);
            return;
        }
        Node node = whilteList.get(cnt);
        if (!bishopCheck(node.r, node.c)) {
            map[node.r][node.c] = true;
            whiteCheck(cnt + 1, count + 1);
            map[node.r][node.c] = false;
        }

        whiteCheck(cnt + 1, count);

    }

    // 검정칸에 있는 비숍 개수
    private static void blackCheck(int cnt, int count) {
        if (blackCount >= blackList.size() - cnt + count)
            return;
        if (cnt == blackList.size()) {
            blackCount = Math.max(blackCount, count);
            return;
        }
        Node node = blackList.get(cnt);
        if (!bishopCheck(node.r, node.c)) {
            map[node.r][node.c] = true;
            blackCheck(cnt + 1, count + 1);
            map[node.r][node.c] = false;
        }
        blackCheck(cnt + 1, count);

    }

    // 위 대각선에 비숍이 있는지 확인
    // 있으면 true 없으면 false Return
    private static boolean bishopCheck(int r, int c) {
        if (map[r][c])
            return true;
        for (int d = 0; d < 2; d++) {
            int nr = r;
            int nc = c;
            while (true) {
                nr += dx[d];
                nc += dy[d];
                if (outCheck(nr, nc))
                    break;
                if (map[nr][nc])
                    return true;
            }
        }
        return false;
    }

    private static boolean outCheck(int r, int c) {
        if (r < 0 || c < 0 || c >= N)
            return true;
        return false;
    }
}

class Node {
    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
// https://www.acmicpc.net/problem/1799