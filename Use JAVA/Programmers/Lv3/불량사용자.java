package Programmers.Lv3;

import java.util.*;
public class 불량사용자 {
    HashSet<String> set;
    String[] regex;
    String[] user;
    boolean[] visited;
    
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();
        user = user_id;
        
        regex = new String[banned_id.length];
        for(int i = 0; i < banned_id.length; i++) {
            regex[i] = banned_id[i].replace("*", ".");
        }
        
        visited = new boolean[user.length];
        backtracking(0, "");
        return set.size();
    }
    
    public void backtracking(int idx, String result) {
        if(idx == regex.length) {
            String[] str = result.split(" ");
            Arrays.sort(str);
            
            String newstr = "";
            for(int i = 0; i < str.length; i++) {
                newstr += str[i];
            }
            set.add(newstr);
            return;
        }
        
        for(int i = 0; i < user.length; i++) {
            if(visited[i] == false && user[i].matches(regex[idx])) {
                visited[i] = true;
                backtracking(idx + 1, result + " " + user[i]);
                visited[i] = false;
            }
        }
    }
}
// Java 정규표현식 Matches를 사용하여 풀이한다. 이 부분도 이 문제를 보면서 처음 접하는 기능이여서 외워 두어야 겠다.
// https://programmers.co.kr/learn/courses/30/lessons/64064