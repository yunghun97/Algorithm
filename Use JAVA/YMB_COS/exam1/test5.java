package YMB_COS.exam1;

class Main {
    static int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };

    public int solution(int n) {
        int[][] map = new int[n][n];
        int nr = 0;
        int nc = 0;
        int number = 1;
        int dir = 0;
        int sum = 1;
        int answer = 0;
        while (true) {
            map[nr][nc] = number++;
            if (number > n * n)
                break;
            nr += dx[dir];
            nc += dy[dir];
            if (outCheck(n, nr, nc) || map[nr][nc] != 0) {
                nr -= dx[dir];
                nc -= dy[dir];
                dir = (dir + 1) % 4;
                nr += dx[dir];
                nc += dy[dir];
            }
            ++sum;
        }

        for (int i = 0; i < n; i++) {
            answer += map[i][i];
        }
        return answer;
    }

    public static boolean outCheck(int N, int r, int c) {
        if (r < 0 || r >= N || c < 0 || c >= N)
            return true;
        return false;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int n1 = 3;
        int ret1 = sol.solution(n1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int ret2 = sol.solution(n2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839399/1%EC%B0%A8-%EB%AC%B8%EC%A0%9C5-%EC%86%8C%EC%9A%A9%EB%8F%8C%EC%9D%B4-%EC%88%98-java