package Programmers.Lv3;

public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int low = 1; 
		int high = 200000000; 
		int mid = 0;
		int answer = 0;

		while(low <= high){
			mid = (low + high) / 2; 

			if(!cross(stones, k, mid)) {
				high = mid - 1; 
			} else {
				low = mid + 1; 
				answer = Math.max(answer, mid); 
			}
		}

		return answer;
	}
	
	public static boolean cross(int[] stones, int k, int mid) {
		int cnt = 0;

		for (int stone : stones) {
			if (stone - mid < 0) { 
				cnt++;
			} else {
				cnt = 0;
			}

			if (cnt == k) 
				return false;
		}

		return true; 
	}
}
// 이진 탐색을 응용한 파라메트릭 서치 풀이로 푸는거였다. -> 공부해야 겠다....
// https://programmers.co.kr/learn/courses/30/lessons/64062