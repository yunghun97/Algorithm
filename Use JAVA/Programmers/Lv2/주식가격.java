package Programmers.Lv2;

public class 주식가격 {   
     
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            for(int i=0; i<answer.length; i++){
                for(int j=i+1; j<answer.length; j++){
                    answer[i]++;
                    if(prices[i]>prices[j]) break;
                }
            }
            return answer;
        }
    }
    ///https://programmers.co.kr/learn/courses/30/lessons/42584
}
