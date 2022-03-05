package Programmers.Lv3;

import java.util.*;

public class 섬연결하기 {
    class Solution {
        int[] arr;

        public int solution(int n, int[][] costs) {
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.len, o2.len));

            for (int i = 0; i < costs.length; i++) {    // 간선의 개수 만큼
                arr = new int[n];
                int start = costs[i][0];
                int end = costs[i][1];
                int len = costs[i][2];
                pq.add(new Node(start, end, len));
            }
            int count = 0; // 간선의 개수가 n-1개면 끝
            int answer = 0; // 정답
            setArr(n);  // 배열 초기화

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int start = node.start;
                int end = node.end;

                int result1 = find(start);
                int result2 = find(end);
                if (result1 != result2) {
                    union(result1, result2);
                    answer += node.len;
                    count++;
                } else {
                    continue;
                }

                if (count == n - 1) {   // 최소 스패닝 그래프의 간선의 개수는 n-1 개이므로 n-1개가 되면 더 탐색 안해도 된다.
                    break;
                }
            }

            return answer;
        }

        void setArr(int n) {
            for (int i = 1; i < n; i++) {
                arr[i] = i;
            }
        }

        int find(int num) {
            if (num != arr[num]) { // 같지 않으면
                return find(arr[num]);
            } else
                return num;
        }

        void union(int a, int b) {
            int num1 = find(a);
            int num2 = find(b);
            if (num1 != num2) { // 다르면 num2를 num1 안에 통합시키기
                arr[num2] = num1;
            } else {
                return;
            }
        }

        class Node {
            int start;
            int end;
            int len;

            public Node(int start, int end, int len) {
                this.start = start;
                this.end = end;
                this.len = len;
            }
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/42861