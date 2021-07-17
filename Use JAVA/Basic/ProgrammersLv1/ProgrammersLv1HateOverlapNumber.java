
import java.util.*;
public class ProgrammersLv1HateOverlapNumber {
    public static void mainHate(String[] args){
            int[] Number = {1,1,3,3,0,1,1}; 
            Solution8 Sol8 = new Solution8();
            int[] output;
            output = Sol8.solution8(Number);
            System.out.println(Arrays.toString(output));


    }
}
class Solution8 {
    public int[] solution8(int []arr) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int input = 10;
        for(int num : arr){
            if(input!=num)
                temp.add(num);
            input = num;
        }
        
        int[] answer = new int[temp.size()];
        for(int i =0; i<answer.length; i++){
            answer[i] = temp.get(i).intValue();
        }
        return answer;
    }
}
