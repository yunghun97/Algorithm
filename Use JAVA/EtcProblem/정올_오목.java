package EtcProblem;

import java.util.Scanner;

public class 정올_오목 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] map = new int[21][21];  // 범위체크를 하지 않도록 크기를 행과 열 2씩 늘린다.
		
		// 4가지 오목의 체크 방향 : 주의점. 왼쪽우선, 왼쪽 좌표가 같다면 위 좌표를 선택
		// 오른쪽 이동, 아래쪽 이동, 오른쪽 아래로 이동, 오른쪽 위로 이동
		int[] dx = {0, 1, 1, -1};
		int[] dy = {1, 0, 1,  1};
		
		// 초기 데이터 입력 완료
		for (int i = 1; i < 20; i++)
			for (int j = 1; j < 20; j++)
				map[i][j] = sc.nextInt();
		
		sc.close();
		// 좌표를 하나씩 이동하면서 오목이 되는지 체크시작
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				int currVal = map[i][j];
				if (currVal == 0) continue;	// 0은 오목의 시작점이 될 수 없다.
				// 4가지 방향 
				for (int d = 0; d < 4; d++) {
					// 현재의 위치에서 진행하려는 방향의 반대 방향의 첫번째 값을 가져와서 현재 위치의 값과 같은지 체크한다.
					// 만약, 값이 같다면 시작점이 아니므로 해당 방향의 진행을 하지 않는다.
					if (currVal == map[i + dx[d] * -1][j + dy[d] * -1]) continue;
					
					int count = 1;
					while (currVal == map[i + dx[d] * count][j + dy[d] * count]) count++;
					
					if (count == 5) {	// 오목
						System.out.println(currVal);
						System.out.println(i + " " + j);
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
}
