package Programmers.Lv1;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
       int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌 체육복을 가져온 학생이 도난당한 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){  // 여별을 가져온 학생이 도난 당한 경우 -1로 혈당.
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        // 도난당한 학생에게 체육복 빌려주는 경우
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){ // 자기 앞 뒤로해서 탐색해서 빌려주기
                    answer++;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        return answer; 
    }
}
//https://programmers.co.kr/learn/courses/30/lessons/42862?language=java