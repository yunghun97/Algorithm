package Programmers.Lv1;
public class ProgrammersLv1PlusMinus {
    public static void mainPlus(String[] args){
        int[] absolutes = {4,7,12};
        boolean[] signs = {true, false, true};
        Solution5 sol5 = new Solution5();
        int answer = sol5.solution(absolutes, signs);
        System.out.print(answer);
    }
}
class Solution5 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer =0;
        for(int i=0; i<signs.length; i++){
            if(signs[i]==true){
                answer += absolutes[i];
            }
            else{
                answer -= absolutes[i];
            }
        }
        return answer;
    }
}