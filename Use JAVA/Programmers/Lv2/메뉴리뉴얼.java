package Programmers.Lv2;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {        
    }
}
class Solution {
    static HashMap<String,Integer> map;
    static char[] result;
    static int[] input;
    static int Length, Max;
    static String now;
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
        
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0; i<course.length; i++){ // 코스 길이 만큼 돌기
        
            for(int x=0; x<orders.length; x++){ // 주문 개수
                if(course[i]>orders[x].length()) break;
                now = orders[x];
                Max = course[i]; // 코스요리 최대 길이
                Length = orders[x].length(); // 음식 최대 길이
            }
            
            
        }
        String[] result = new String[5];
        return result;
    }
    private void combination(int cnt, int start){
        if(cnt==Max){
            for(int i=0; i<cnt; i++){
                sb.append(result[i]);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(),1)+1);
            sb.setLength(0);
            return;
        }
        for(int i=start; i<Length; i++){
            result[cnt] = now.charAt(i);
            combination(cnt+1, i+1);
        }
    }
}
