
import java.util.*;
public class ProgrammersLv1PonketMon {
    public static void main5(String[] args){
    int[] input = {3,3,3,2,2,4};
    Solution3 sol= new Solution3();
    int output = sol.solution3(input);
    System.out.print(output);
    }
}
class Solution3 {
    public int solution3(int[] nums) {
        int[] answer = nums; 
        int j=1; int count =1;
        Arrays.sort(answer);
        for(int i =0; i<answer.length-1; i++){
            if(count >=answer.length/2){
                break;
            }
            if(answer[i]==answer[j]){
                j++;
            }
            else{
                count +=1;
                j++;
            }
        }
        return count;
    }
}
