package BackJun.Gold;

import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class G2새로운게임2_17837 {
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, -1, 0, 1 };
    static Deque<Integer>[][] nodeMap;
    static ArrayList<Node> list;
    static int[][] map;
    static int N, K, time;
    static Deque<Integer> resultDQ;

    // 1 빨강 2 파랑 0 하양
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        nodeMap = new Deque[N][N];
        list = new ArrayList<>();
        resultDQ = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nodeMap[i][j] = new LinkedList<>();
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        list.add(new Node(0, 0, 0, 0));
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = i;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            if (dir == 0) { // 오른쪽
                dir = 3;
            } else if (dir == 1) { // 왼쪽
                dir = 1;
            } else if (dir == 2) { // 위
                dir = 0;
            } else { // 아래
                dir = 2;
            }
            list.add(new Node(num, r, c, dir));
            nodeMap[r][c].add(num);
        }

        time = 0;
        for (int i = 1; i <= 1000; i++) {
            if (move()) {
                time = i;
                break;
            }
        }
        if (time == 0)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(time));
        bw.flush();
    }

    private static boolean move() {
        // 흰색이면 그대로 뒤에 넣기
        // 빨강이면 뒤에 역순으로 넣기
        // 파랑, 벽넘어가면 방향 바꿔서 이동(또 파랑이거나 범위 밖이면 방향만 바꾸고 이동 X)
        for (int i = 1; i < list.size(); i++) { // 노드 번호순서대로 이동
            Node node = list.get(i);
            int num = node.num;
            int r = node.r; // 해당 행 좌표
            int c = node.c; // 해당 열 좌표
            int dir = node.dir; // 해당 노드 방향

            int dqSize = nodeMap[r][c].size();  // 해당 노드가 위치한 노드 원소개수 만큼만 탐색
            for (int x = 0; x < dqSize; x++) {  
                int tmp = nodeMap[r][c].pollFirst();    // 맨 앞의 값 뽑아내기

                if (num == tmp) { // 같은 번호를 찾으면 그 뒤 이동 후 break;
                    int[] arr = checkColor(r, c, dir);      // 결과 0,2이면 정방향, 1이면 빨간색이므로 역방향
                    list.get(num).dir = arr[3]; // 일치하는 노드 번호의 방향을 설정
                    nodeMap[r][c].addFirst(tmp);    // 다시 처음에 넣어준다.
                    for (int y = x; y < dqSize; y++) {  // 일치하는 노드부터 끝까지 탐색하기 위한 for문
                        tmp = nodeMap[r][c].pollFirst();    // 처음꺼 뽑아내서
                        if (arr[0] == 2 || arr[0] == 0) { // 이동해도 파란색 or 벽이므로 방향만 바꾸어준다.
                            resultDQ.addLast(tmp); // A, B, C
                            list.get(tmp).r = arr[1];   // 이동하는 행 좌표
                            list.get(tmp).c = arr[2];   // 이동하는 열 좌표
                        } else { // 빨간색 역순으로 넣기
                            resultDQ.addFirst(tmp);    // C, B, A
                            list.get(tmp).r = arr[1];   // 이동하는 행 좌표 
                            list.get(tmp).c = arr[2];   // 이동하는 열 좌표
                        }
                    }
                    while (!resultDQ.isEmpty()) {  // 
                        nodeMap[arr[1]][arr[2]].addLast(resultDQ.pollFirst());
                    }
                    if (nodeMap[arr[1]][arr[2]].size() >= 4) {
                        return true;
                    }
                    break;
                } else {    // 다른 번호면 다시 맨 뒤에 붙여준다.
                    nodeMap[r][c].addLast(tmp);
                }
            }
        }
        return false;
    }

    private static int[] checkColor(int r, int c, int dir) {    // 이동 어떻게 할지 정하는 메소드
        int[] arr = new int[4]; // 결과 배열
        int nr = r + dx[dir];   // 한번 이동 후 좌표
        int nc = c + dy[dir];
        int result = 0; 
        int d = dir;    // 처음 방향
        if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {   // 처음 파란색이나 벽을 만나면
            nr = r + dx[(dir + 2) % 4]; // 반대 좌표 탐색하기 위한 좌표 재 설정
            nc = c + dy[(dir + 2) % 4];
            d = (dir + 2) % 4;  // 방향 반대로
            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 2) {   // 또 벽이나 파란색이면 원래 좌표를 할당
                nr = r;
                nc = c;
                result = 2;
            } else if (map[nr][nc] == 0) {  // 하얀색
                result = 0;
            } else {    // 빨간색
                result = 1;
            }
        } else if (map[nr][nc] == 1) { // 처음 탐색했을 때 빨간색
            result = 1; 
        } else {    // 처음 탐색했을 때 하얀색
            result = 0;
        }
        arr[0] = result;
        // 반환값 0 이면 그대로 진행    
        // 1 이면 역순으로 넣어서 옮기기
        // 2 이면 바꿔도 갈수 없는 경우 그자리에 그대로 (방향만 바꿔준다.)
        arr[1] = nr;    // 이동할 행 좌표
        arr[2] = nc;    // 이동할 얄 좌표
        arr[3] = d;     // 방향
        return arr;
    }

    static class Node {
        int num;
        int r;
        int c;
        int dir;

        public Node(int num, int r, int c, int dir) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Node [ num=" + num + ", r=" + r + ", c=" + c + ",dir=" + dir + "]";
        }

    }
}
