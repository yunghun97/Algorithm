package Programmers.Lv2;
import java.util.*;
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i : progresses){
            q.add(i);
        }
        int idx = 0;
        while(!q.isEmpty()){                        
            int progress = q.poll();
            int result = 0;
            int time = 0;
            while(progress<100){    // 실행율 100이상일 때 까지 돌리고 얼마나 시간 걸리는 지 체크
                time++;
                progress+=speeds[idx];
            }
            result++;
            idx++;
            while(!q.isEmpty()){ // 그 다음 부분들 탐색하기
                int nextprogress = q.peek();
                if(nextprogress+speeds[idx]*time>=100){ // 해당 시간만큼 돌았을 때 100 이상이면
                    idx++;  // 다음 인덱스로 이동
                    result++;   // result++;
                    q.poll();   // 그 작업 제외하기
                    continue;
                }else break;   // 다시 처음부터 계산한다.
            }
            list.add(result);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/42586?language=java