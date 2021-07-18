package Basic.ProgrammersLv1;
import java.util.Arrays;
public class PromgrammersLv1Knum {
    public static void main_c(){
        Solution1 Solve = new Solution1();
        int array[] = {1,5,2,6,3,7,4};
        int commands[][] = {{2,5,3},{4,4,1},{1,7,3}};
        System.out.print(Solve.solution(array, commands));
    }
}
class Solution1{
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
    for(int i =0; i< commands.length; i++)
        {
         int[] temp = Arrays.copyOfRange(array,commands[i][0]-1,commands[i][1]);
         Arrays.sort(temp);
         answer[i]=temp[commands[i][2]-1];
        }
        return answer;
    }
}