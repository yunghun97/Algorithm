package BackJun.Gold;

import java.io.*;
import java.util.*;

// 기준점 x,y  1 <= X < x+d1+d2<=N,  1 <=y-d1 < y < y+d2
// 경계 길이 d1, d2 >=1, 
public class G4게리맨더링2 {
    static int[][] map, kindMap;
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };
    static int N, countAll, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        kindMap = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        countAll = (N - 1) * (N - 1);
        for (int x = 1; x < N; x++) {
            for (int y = 1; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 > N)
                            continue;
                        if (y + d2 > N)
                            continue;
                        if (y - d1 < 1)
                            continue;
                        areaSet(x, y, d1, d2);
                    }
                }
            }
        }
        bw.write("" + answer);
        bw.flush();
    }

    private static void areaSet(int x, int y, int d1, int d2) {
        resetArray();
        for (int d = 0; d <= d1; d++) { // 5번째 구역 세팅
            kindMap[x + d][y - d] = 5; // 1
            kindMap[x + d2 + d][y + d2 - d] = 5; // 3
        }
        for (int d = 0; d <= d2; d++) {
            kindMap[x + d][y + d] = 5; // 2
            kindMap[x + d1 + d][y - d1 + d] = 5; // 4
        }
        fristArea(x + d1, y); // 각 구역 세팅 -> 각 구역 세팅 중 5를 만나면 break; -> 2,4는 오른쪽 열부터 탐색
        secondArea(x + d2, y + 1);
        thirdArea(x + d1, y - d1 + d2);
        fourthArea(x + d2 + 1, y - d1 + d2);
        int[] result = new int[6];
        result = addSum();
        answer = Math.min(answer, result[5] - result[1]);
    }
    private static int[] addSum() {
        int[] result = new int[6];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (kindMap[r][c] == 0) {
                    result[5] +=map[r][c];
                } else {
                    result[kindMap[r][c]] += map[r][c];
                }
            }
        }
        Arrays.sort(result);
        return result;
    }

    private static void fristArea(int x, int y) {
        for (int r = 1; r < x; r++) {
            for (int c = 1; c <= y; c++) {
                if (kindMap[r][c] != 0) break;
                kindMap[r][c] = 1;
            }
        }
    }

    private static void secondArea(int x, int y) {
        for (int r = 1; r <= x; r++) {
            for(int c=N; c>=y; c--){
                if (kindMap[r][c] != 0) break;
                kindMap[r][c] = 2;
            }
        }
    }

    private static void thirdArea(int x, int y) {
        for (int r = x; r <= N; r++) {
            for (int c = 1; c < y; c++) {
                if (kindMap[r][c] != 0) break;                 
                kindMap[r][c] = 3;
            }
        }
    }

    private static void fourthArea(int x, int y) {
        for (int r = x; r <= N; r++) {            
            for(int c=N; c>=y; c--){                
                if (kindMap[r][c] != 0) break;
                kindMap[r][c] = 4;
            }
        }

    }

    private static void resetArray() {
        for (int i = 1; i <= N; i++) {
            Arrays.fill(kindMap[i], 0);
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
// https://www.acmicpc.net/problem/17779