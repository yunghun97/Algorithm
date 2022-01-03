package Programmers.Lv2;

import java.util.*;

public class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        ArrayList<User> list = new ArrayList<>();
        int[] answer = new int[query.length];
        
        for(int i=0; i<info.length; i++){
            String[] arr = info[i].split(" ");
            list.add(new User(arr[0],arr[1],arr[2],arr[3],Integer.parseInt(arr[4])));
        }       
        
        for(int i=0; i<query.length; i++){
            int peopleCount = 0;
            String[] arr = query[i].split(" ");
            String lan = arr[0];
            String job = arr[2];
            String career = arr[4];
            String food = arr[6];
            int score = Integer.parseInt(arr[7]);
            
            for(int x=0; x<list.size(); x++){
                User user = list.get(x);
                if(lan.equals("-")||lan.equals(user.language)){
                    if(job.equals("-")||job.equals(user.job)){
                        if(career.equals("-")||career.equals(user.career)){
                            if(food.equals("-")||food.equals(user.food)){
                                if(score<=user.score) peopleCount++;
                                else continue;
                            }else continue;
                        }else continue;
                    }else continue;
                }else continue;


            }
            answer[i] = peopleCount;
        }

        return answer;
    }
    static class User{
        String language;
        String job;
        String career;
        String food;
        int score;
        public User(String language, String job, String career, String food, int score){
            this.language = language;
            this.job = job;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }
}
//https://programmers.co.kr/learn/courses/30/lessons/72412?language=java
// 효율성 테스트에서 걸리는 코드
// 각 집합을 만들어서 걸러야 할 듯