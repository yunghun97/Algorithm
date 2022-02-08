package Programmers.Lv2;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {       
        Solution so = new Solution();
        String[] or = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] cor = {2,3,4};
        String[] tmp = so.solution(or, cor); 
        for(int i=0; i<tmp.length; i++){
            System.out.println(tmp[i]);
        }
    }
}
class Solution {
    static HashMap<String,Integer> map; // map
    static char[] result; // 조합으로 뽑을 문자열    
    static int Length, Max; // Length : 문자열 길이 Max : Course 길이
    static String now;  // 현재 조합으로 뽑을 문자열
    static StringBuilder sb;
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        char[] arr;
        sb = new StringBuilder();
        
        for(int i=0; i<orders.length; i++){
            arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);        // orders 정렬
        }
        
        ArrayList<String> tmpAnswer = new ArrayList<>();
        for(int i=0; i<course.length; i++){ // 코스 길이 만큼 돌기
            
            Max = course[i]; // 코스요리 최대 길이
            for(int x=0; x<orders.length; x++){ // 주문 개수
                if(course[i]>orders[x].length()) continue;
                now = orders[x];
                Length = orders[x].length(); // 음식 최대 길이
                result = new char[Max];
                combination(0, 0);
            }
            int max = 0;
            for(String key : map.keySet()){ // 최대로 뽑은 음식 개수 구하기
                max = Math.max(map.get(key),max);
            }
            if(max>=2){ // 2번 이상 나올 때만
                for(String key : map.keySet()){ // 해당 value 값 추가
                    if(map.get(key)==max) tmpAnswer.add(key);
                }
            }
            map.clear();
        }
        Collections.sort(tmpAnswer);    // ArrayList 오름차순 정렬
        String[] answer = new String[tmpAnswer.size()]; 
        for(int i=0; i<tmpAnswer.size(); i++){
            answer[i] = tmpAnswer.get(i);
        }
        
        return answer;
    }
    private void combination(int cnt, int start){
        if(cnt==Max){
            for(int i=0; i<cnt; i++){
                sb.append(result[i]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
            sb.setLength(0);
            return;
        }
        for(int i=start; i<Length; i++){
            result[cnt] = now.charAt(i);
            combination(cnt+1, i+1);
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/72411