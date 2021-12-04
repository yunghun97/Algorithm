package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G1마법사상어와복제_23290 {
    static int N, M, S;
    static int[] sdx = { -1, 0, 1, 0 }, sdy = { 0, -1, 0, 1 }, // 상어 방향
            fdx = { 0, -1, -1, -1, 0, 1, 1, 1 }, fdy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 물고기 방향

    static boolean[][] smellMap, sharkAllocation; // 상어 위치와 냄새위치 보여줄 boolean형 배열
    static ArrayList<Fish>[][][] fishList; // 3차원 배열을 통해 방향당 count를 통해 물고기를 관리하여 반복을 줄인다.
    static PriorityQueue<Smell> smellPq; // 냄새를 age 오름차순 순으로 관리하는 큐
    static Queue<Fish> copyFishes, tmpFishes; // copy는 복사할 물고기 정보 저장 tmp는 이동하는 물고기를 임시로 저장
    static Shark shark; // 상어 위치에 대한 전역변수

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = 4;
        fishList = new ArrayList[N][N][8];
        smellMap = new boolean[N][N];
        sharkAllocation = new boolean[N][N];
        smellPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.age, o2.age)); // 냄새 저장할 배열 age는 냄새의 세대를 나타낸다.
        copyFishes = new LinkedList<>(); // 복사 마법 저장 큐
        tmpFishes = new LinkedList<>(); // 물고기 이동할 때 사용할 임시 큐
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int z = 0; z < 8; z++) {
                    fishList[i][j][z] = new ArrayList<>();
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            if (fishList[r][c][dir].size() == 0) { // 물고기 해당 좌표와 방향에 처음 나오는 경우
                fishList[r][c][dir].add(new Fish(r, c, dir, 1));
            } else { // 이미 있는 경우 count +1
                fishList[r][c][dir].get(0).count += 1;
            }
        }
        // 상어 정보
        st = new StringTokenizer(br.readLine());
        shark = new Shark(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        sharkAllocation[shark.r][shark.c] = true;
        // firshCheck(); // 처음 상어와 물고기가 같이 있는 경우 체크
        for (int order = 0; order < S; order++) {
            copyMagic(); // 복사하기
            moveFish(); // 물고기 움직이기
            findSharkDir(order); // 상어방향찾기 -> 상어 이동하기
            removeSmell(order); // 냄새 지우기
            doCopy(); // 복사실행
        }
        long answer = sumFish();
        bw.write("" + answer);
        bw.flush();
    }

    // 총합 구하기
    private static long sumFish() {
        long tmp = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int d = 0; d < 8; d++) {
                    if (fishList[r][c][d].size() >= 1) {
                        tmp += fishList[r][c][d].get(0).count;
                    }
                }
            }
        }
        return tmp;
    }

    // 복제 마법 진행 copyFishes에 저장된걸 fishList에 더 해준다.
    private static void doCopy() {
        while (!copyFishes.isEmpty()) {
            Fish fish = copyFishes.poll();
            // 이미 존재
            if (fishList[fish.r][fish.c][fish.dir].size() >= 1) {
                fishList[fish.r][fish.c][fish.dir].get(0).count += fish.count;
            }
            // 처음이면
            else {
                fishList[fish.r][fish.c][fish.dir].add(new Fish(fish.r, fish.c, fish.dir, fish.count));
            }
        }
    }

    // param : order = 현재 order 세대
    private static void removeSmell(int order) {
        Queue<Smell> q = new LinkedList<>();
        while (!smellPq.isEmpty()) {
            Smell smell = smellPq.peek(); // 제일 앞에 탐색 -> 오름차순으로 정렬되어 있으므로 0,1,2 순 제일 처음에 저장된 냄새 정보가 나온다.
            if (smell.age > order - 2) { // 2세대 전보다 큰 경우 -> 냄새 지우기를 하지 않으므로 break;
                break;
            } else { // 2세대 전 -> (3,4세대 전은 존재하지 않는다. 2세대 전일 떄 무조건 다 지우므로)
                smellPq.poll();
                smellMap[smell.r][smell.c] = false; // 냄새 정보 없애기
            }
        }
        while (!smellPq.isEmpty()) { // 남아있는 냄새가 중첩되어 있을 수 도 있으므로
            Smell smell = smellPq.poll(); // 임시로 저장
            smellMap[smell.r][smell.c] = true; // 냄새 추가
            q.add(new Smell(smell.r, smell.c, smell.age));
        }
        while (!q.isEmpty()) { // 다시 q에 저장해준다.
            Smell smell = q.poll();
            smellPq.add(new Smell(smell.r, smell.c, smell.age));
        }
    }

    // 상어 방향 찾기 order는 현재 order 턴
    private static void findSharkDir(int order) {
        int sr = shark.r;
        int sc = shark.c;
        int removeCount = -1; // 총 지우는 물고기 개수
        SharkDir sharkDir = new SharkDir(0, 0, 0);
        for (int d1 = 0; d1 < 4; d1++) {
            int sr1 = sr + sdx[d1];
            int sc1 = sc + sdy[d1];
            if (!outLineCheck(sr1, sc1))
                continue; // 벽 밖이면 false return;
            for (int d2 = 0; d2 < 4; d2++) {
                int sr2 = sr1 + sdx[d2];
                int sc2 = sc1 + sdy[d2];
                if (!outLineCheck(sr2, sc2))
                    continue; // 벽 밖이면 false return;
                for (int d3 = 0; d3 < 4; d3++) {
                    int sr3 = sr2 + sdx[d3];
                    int sc3 = sc2 + sdy[d3];
                    if (!outLineCheck(sr3, sc3))
                        continue; // 벽 밖이면 false return;
                    int result = removeCheck(d1, d2, d3); // 얼마나 물고기를 먹을 수 있는지 체크
                    if (result > removeCount) { // result가 같으면 이미 0~3으로 사전순으로 for문 돌렸으므로 더 작을 때만 상어의 방향이 바뀐다.
                        sharkDir.d1 = d1;
                        sharkDir.d2 = d2;
                        sharkDir.d3 = d3;
                        removeCount = result;
                    }
                }
            }
        }
        // 상어 이동하기
        moveShark(sharkDir, order);
    }

    // 상어 이동하기 -> 이동 및 냄새 정보 smellPq에 저장까지
    private static void moveShark(SharkDir sharkDir, int age) {
        int sr = shark.r;
        int sc = shark.c;

        boolean smellCheck = false;
        int sr1 = 0;
        int sc1 = 0;
        for (int d = 0; d < 3; d++) {
            if (d == 0) {
                sr1 += sr + sdx[sharkDir.d1];
                sc1 += sc + sdy[sharkDir.d1];
            } else if (d == 1) {
                sr1 += sdx[sharkDir.d2];
                sc1 += sdy[sharkDir.d2];
            } else {
                sr1 += sdx[sharkDir.d3];
                sc1 += sdy[sharkDir.d3];
            }
            for (int i = 0; i < 8; i++) {
                if (fishList[sr1][sc1][i].size() >= 1) {
                    smellCheck = true; // 먹은 경우이므로 smell을 추가해줘야 한다.
                }
                fishList[sr1][sc1][i].clear();
            }
            if (smellCheck) { // 먹은 경우
                smellMap[sr1][sc1] = true;
                smellPq.add(new Smell(sr1, sc1, age));
                smellCheck = false;
            }
        }
        // 이동 끝났으니 상어 위치정보를 최신화 해준다.
        sharkAllocation[sr][sc] = false;
        sharkAllocation[sr1][sc1] = true;
        shark.r = sr1;
        shark.c = sc1;
    }

    private static int removeCheck(int d1, int d2, int d3) {
        int result = 0;
        boolean[][] isVisited = new boolean[N][N];

        int sr1 = 0;
        int sc1 = 0;
        for (int d = 0; d < 3; d++) {
            if (d == 0) {
                sr1 += shark.r + sdx[d1];
                sc1 += shark.c + sdy[d1];
            } else if (d == 1) {
                sr1 += sdx[d2];
                sc1 += sdy[d2];
            } else {
                sr1 += sdx[d3];
                sc1 += sdy[d3];
            }
            if (!isVisited[sr1][sc1]) {
                for (int i = 0; i < 8; i++) {
                    if (fishList[sr1][sc1][i].size() >= 1) {
                        result += fishList[sr1][sc1][i].get(0).count;
                    }
                }
                isVisited[sr1][sc1] = true;
            }
        }
        return result;
    }

    private static void moveFish() {
        // 물고기 이동 체크
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int fd = 0; fd < 8; fd++) { // 3차원 이므로 방향 8개 다 탐색
                    if (fishList[r][c][fd].size() != 0) { // 해당 방향을 가진 물고기가 있는 경우만
                        for (Fish fish : fishList[r][c][fd]) { // forEach문 -> 어짜피 크기 1이라 한 번만 돈다.
                            boolean moveCheck = false;
                            for (int d = 0; d < 8; d++) {
                                int nr = r + fdx[fish.dir];
                                int nc = c + fdy[fish.dir];

                                // 벽 밖 체크 할 때 사용 -> 상어 이동에도 사용
                                if (outLineCheck(nr, nc)) {
                                    // 냄새가 존재하지 않을 때만
                                    if (!smellMap[nr][nc] && !sharkAllocation[nr][nc]) {
                                        tmpFishes.add(new Fish(nr, nc, fish.dir, fish.count));
                                        moveCheck = true; // 이동했는지 안했는지 체크
                                        break;
                                    }
                                }
                                fish.dir = fish.dir - 1;
                                if (fish.dir == -1)
                                    fish.dir = 7;
                            }
                            if (!moveCheck) { // 이동할 수 없어서 이동하지 않으면 기존 정보를 tmp에 저장
                                tmpFishes.add(new Fish(r, c, fish.dir, fish.count));
                            }
                        }
                        fishList[r][c][fd].clear(); // 해당좌표를 탐색했으니 초기화 시켜준다.
                    }
                }
            }
        }
        // 실제 물고기 이동하는 부분
        while (!tmpFishes.isEmpty()) {
            Fish fish = tmpFishes.poll();
            // 처음 추가
            if (fishList[fish.r][fish.c][fish.dir].size() == 0) {
                fishList[fish.r][fish.c][fish.dir].add(new Fish(fish.r, fish.c, fish.dir, fish.count));
            }
            // 중복일 때 count만 ++;
            else {
                fishList[fish.r][fish.c][fish.dir].get(0).count += fish.count;
            }
        }
    }

    // 벽 밖이면 false return
    private static boolean outLineCheck(int nr, int nc) {
        if (nr < 0 || nr >= N || nc < 0 || nc >= N)
            return false;
        return true;
    }

    // copyFishes에 복사할 물고기의 정보를 담아 놓는 메소드
    private static void copyMagic() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int dx = 0; dx < 8; dx++) {
                    if (fishList[i][j][dx].size() >= 1) {
                        for (Fish fish : fishList[i][j][dx]) {
                            copyFishes.add(new Fish(i, j, dx, fish.count));
                        }
                    }
                }
            }
        }
    }

    // 물고기 방향 정보
    static class Fish {
        int r;
        int c;
        int dir;
        int count;

        public Fish(int r, int c, int dir, int count) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.count = count;
        }
    }

    // 냄새
    static class Smell {
        int r;
        int c;
        int age;

        public Smell(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }

    // 상어 좌표
    static class Shark {
        int r;
        int c;

        public Shark(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    // 상어 방향
    static class SharkDir {
        int d1;
        int d2;
        int d3;

        public SharkDir(int d1, int d2, int d3) {
            this.d1 = d1;
            this.d2 = d2;
            this.d3 = d3;
        }
    }
}
// https://www.acmicpc.net/problem/23290