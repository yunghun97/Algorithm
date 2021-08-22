package BackJun.Gold;

import java.util.ArrayList;
import java.util.Scanner;

public class G5감시교수님꺼 {   // 0 : 위 1: 오른쪽 2: 아래 3: 왼쪽
	static int N, M, K, ans = Integer.MAX_VALUE;
	
	static int[][] map, dir = { {}, { 1 }, { 1, 3 }, { 0, 1 }, { 0, 1, 3 }, { 0, 1, 2, 3 } };
	// cctv 종류에 따른 방향 돌리기 갯수
	static int[] dCnt = {0, 4, 2, 4, 4, 1};
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = { 0, 1, 0,-1};
	
	static ArrayList<CCTV> cctvList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					cctvList.add(new CCTV(i, j, map[i][j]));
				}
			}
		}
		solve(0, map);
		System.out.println(ans);
	}
	static void solve(int idx, int[][]map) {
		if (idx == cctvList.size()) {
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) 
						cnt++;
				}
			}
			ans = Math.min(ans, cnt);
			return;
		}
		
		CCTV cctv = cctvList.get(idx); // 리스트에서 CCTV 뽑기
		for (int d = 0; d < dCnt[cctv.d]; d++) {  // CCTV 회전 방향
			int[][] copyMap = mapCopy(map);
			
			// CCTV의 종류에 따른 감시하는 모든 방향에 대해 체크한다
			for (int i = 0; i < dir[cctv.d].length; i++) {  //cctv감시 원소 갯수
				int cctvDir = (dir[cctv.d][i] + d ) % 4;
				int r = cctv.r;
				int c = cctv.c;
				while (true) {
					r += dr[cctvDir];
					c += dc[cctvDir];
					
					if (r < 0 || r >= N || c < 0 || c >= M) break;  // 범위를 벗어나면
					if (copyMap[r][c] == 6) break;  // 해당 위치가 벽이라면
					copyMap[r][c] = 9; // cctv 범위임을 표현
				}
			}
			solve(idx + 1, copyMap);
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}

	static int[][] mapCopy(int[][] map) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	static class CCTV {
		int r, c, d;
		CCTV(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}
}