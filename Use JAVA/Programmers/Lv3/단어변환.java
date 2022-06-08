package Programmers.Lv3;

public class 단어변환 {
    private static int answer = Integer.MAX_VALUE;
    private static boolean[] isVisited;
    public int solution(String begin, String target, String[] words) {
        isVisited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        if(answer==Integer.MAX_VALUE) return 0;
        else return answer;        
    }
    private static void dfs(String now, String target, String[] arr, int cnt){
        if(cnt>=answer) return; // 백 트래킹 
        if(now.equals(target)){            
            answer = Math.min(answer,cnt);
            return;            
        }
        for(int i=0; i<arr.length; i++){
            if(isVisited[i]) continue;
            
            int count = 0; // 일치하는 char 개수
            for(int j=0; j<now.length(); j++){
                if(now.charAt(j)==arr[i].charAt(j)){
                    count++;
                }
            }
            if(count==now.length()-1){
                isVisited[i] = true; // 해당 체크
                dfs(arr[i], target, arr, cnt+1);
                isVisited[i] = false; // 해당 단어 체크 해제
            }
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/43163