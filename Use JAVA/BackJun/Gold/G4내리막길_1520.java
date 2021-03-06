package BackJun.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4내리막길_1520 {
	static int[][] dp;
	static int row, col;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(keyIn.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		dp = new int[row][col];
        
		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(keyIn.readLine());
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
	}

	public static int dfs(int x, int y) {
		if (y == col - 1 && x == row - 1) {
			return 1;
		}
		if (dp[x][y] != -1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if (0 <= nx && nx < row && 0 <= ny && ny < col) {
				if (map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx, ny);
				}
			}
		}
		return dp[x][y];
	}

	// 각 처음탐색을 0으로 해서 도착하면 1을 리턴해서 탐색한 좌표들을 +=1해서
	// 다음 탐색시 1이상일 떄(1이상은 해당 좌표에서 종료지점까지 가는 경우의 수이므로) 이동 이전좌표 += 해주기
}