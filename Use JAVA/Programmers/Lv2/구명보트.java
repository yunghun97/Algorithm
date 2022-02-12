package Programmers.Lv2;

import java.util.*;
public class 구명보트 {
    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int minIndex = 0;
            int maxIndex = people.length-1;
            int now = 0;
            Arrays.sort(people);        
            while(minIndex<=maxIndex){
                now = people[maxIndex];
                // 2명이서 탈 수 없는 경우 -> 제일 무거운 사람만 우선 이동
                if(now+people[minIndex]>limit){
                    maxIndex--;
                    answer++;
                }else{  // 제일 무거운 사람 + 가벼운 사람으로 탈 수 있는 경우 -> 2명 이동 후 다음 최대, 최소 탐색
                    minIndex++;
                    maxIndex--;
                    answer++;
                }
            }
            return answer;
        }
    }
}
