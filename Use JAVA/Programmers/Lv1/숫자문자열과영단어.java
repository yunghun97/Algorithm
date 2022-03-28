package Programmers.Lv1;

public class 숫자문자열과영단어 {
    public int solution(String s) {

        String[] word= {"zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"}; 
        String[] number= {"0","1","2","3","4","5","6","7","8","9"};
        
        for (int i = 0 ; i <10 ; i++){

            s = s.replace(word[i] , number[i]);            
        }
        return Integer.parseInt(s);
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/81301