
import java.util.*;
public class ProgrammersLv1MockExam{
    public static void main_b(String [] args){
        int[] input1 = {1,2,3,4,5};
        int[] input2 = {1,3,2,4,2};
        Solution Solve = new Solution();
        
        int answerPrint[] = Solve.solution(input1);
        System.out.print(Solve.solution(answerPrint));
        
        answerPrint= Solve.solution(input2);
        System.out.print(Solve.solution(answerPrint));
    }
}
class Solution{
    public int[] solution(int[] answers) {
        int j=0;
        int[] answer = {};
        int[] user1 = {1,2,3,4,5}; int user1Score = 0;
        int[] user2 = {2,1,2,3,2,4,2,5}; int user2Score = 0;
        int[] user3 = {3,3,1,1,2,2,4,4,5,5}; int user3Score = 0;
        for(int i = 0; i<answers.length; i++){
            if(j==5){
                j = 0;
            }
            if(answers[i]==user1[j]){
                user1Score++;
            }
            j++;
}
        j = 0;
        for(int i = 0; i<answers.length; i++){
            if(j==8){
                j = 0;
            }
            if(answers[i]==user2[j]){
                user2Score++;
            }
            j++;
}
        j = 0;
        for(int i = 0; i<answers.length; i++){
            if(j==10){
                j = 0;
            }
            if(answers[i]==user3[j]){
                user3Score++;
            }
            j++;
}
        //1번 1234 5
        //2번 2123 2425
        //3번 3311 2244 55 
        int max = Math.max(Math.max(user1Score,user2Score),user3Score);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(max==user1Score) list.add(1);
        if(max==user2Score) list.add(2);
        if(max==user3Score) list.add(3);
        answer = new int[list.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}