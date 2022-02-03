package Programmers.Lv2;

import java.util.*;

public class 오픈채팅방 {

    class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> map = new HashMap();
            StringTokenizer st;
            String[][] result = new String[2][record.length];
            int idx = 0;
            for (int i = 0; i < record.length; i++) {
                st = new StringTokenizer(record[i]);
                String action = st.nextToken();
                String id = st.nextToken();
                if (action.equals("Leave")) {
                    result[0][idx] = id;
                    result[1][idx++] = action;
                } else {
                    String name = st.nextToken();

                    if (map.containsKey(id)) { // 이미 키가 있는 경우 이름 새로 갱신하기
                        map.replace(id, name);
                    } else { // 무조건 처음 등장하므로 map에 추가
                        map.put(id, name);
                    }
                    if (action.equals("Enter")) {
                        result[0][idx] = id;
                        result[1][idx++] = action;
                    }
                }
            }
            String[] answer = new String[idx];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < idx; i++) {
                sb.append(map.get(result[0][i]) + "님이 ");
                if (result[1][i].equals("Enter"))
                    sb.append("들어왔습니다.");
                else
                    sb.append("나갔습니다.");
                answer[i] = sb.toString();
                sb.setLength(0);
            }
            return answer;
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/42888?language=java