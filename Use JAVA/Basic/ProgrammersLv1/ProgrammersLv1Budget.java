package Basic.ProgrammersLv1;

import java.util.*;
public class ProgrammersLv1Budget {
    public static void main(String[] args){
    int[] d = {1,3,2,5,4,2,2,3,3};
    int budget = 19;
    Solution6 sol6 = new Solution6();
    int answer = sol6.solution(d, budget);
    System.out.print(answer);
    }
}
class Solution6 {
    public int solution(int[] d, int budget) {
        int[] apply = d;
        int sum = 0;
        int count= 0;
        Arrays.sort(apply);
        for(int i =0; i<apply.length; i++){
            if(sum+apply[i]<=budget){
                sum+= apply[i];
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}