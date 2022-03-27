package Programmers.Lv3;

import java.util.*;

public class 양과늑대 {
    private static int MaxCnt;
	private static Map<Integer, List<Integer>> nodes;
    public int solution(int[] info, int[][] edges) {
        MaxCnt = 0;
		nodes = new HashMap<>();
		for(int[] e : edges) {
			if(!nodes.containsKey(e[0])) nodes.put(e[0], new ArrayList<>()); // 해당 키가 존재하지 않으면 새거 넣어주기
			nodes.get(e[0]).add(e[1]); // 이미 존재시 추가
		}
		List<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, 0, 0, list, info);
		return MaxCnt;
    }
    public void dfs(int idx, int s, int w, List<Integer> list, int[] info) {
		if(info[idx]==0) s+=1; // 양 추가
		else w+=1; // 늑대 추가
		if(s<=w) return; // 늑대가 양 개수 이상일 때 return
		
		MaxCnt = Math.max(MaxCnt, s); // 최대값 갱신
		
		List<Integer> next = new ArrayList<>();
		next.addAll(list); // 그 전 arrayList 복사
		if(nodes.containsKey(idx)) next.addAll(nodes.get(idx)); // 해당 좌표에서 이동할 수 있으면 이동 가능한 경우의수 추가
		next.remove(Integer.valueOf(idx)); // 현재 위치한 좌표는 경우의수 삭제
		
		for(int n : next) { // 경우의 수 한번씩 다 돌기
			dfs(n, s, w, next, info);
		}
		
		return;
	}
}
// https://programmers.co.kr/learn/courses/30/lessons/92343