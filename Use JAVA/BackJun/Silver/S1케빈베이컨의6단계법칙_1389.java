package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S1케빈베이컨의6단계법칙_1389 {
	static int N, M, road[][];
 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(st.nextToken()); // 유저수
		M = Integer.parseInt(st.nextToken()); // 관계 수
 
		// 초기화
		road = new int[N + 1][N + 1]; // 1번부터 사용하기 위해
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					road[i][j] = 0; // 자기 자신으로 가는 경우
				else
					road[i][j] = 999999; // INF
			}
		}
 
		// 간선 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
 
			road[from][to] = road[to][from] = 1; // 직접 연결은 가중치 1
		}
 
		// 플로이드 와샬
		for (int k = 1; k <= N; k++) // 거쳐가는 노드
			for (int i = 1; i <= N; i++) // 시작 노드
				for (int j = 1; j <= N; j++) // 도착 노드
					road[i][j] = Math.min(road[i][j], road[i][k] + road[k][j]);
 
 
		// 최소 노드 찾기
		int min_node = Integer.MAX_VALUE;
		int min_road = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++)
				sum += road[i][j];
 
			if (min_road > sum) {
				min_node = i;
				min_road = sum;
			}
		}
        bw.write(""+min_node);
	}
}
//https://www.acmicpc.net/problem/1389