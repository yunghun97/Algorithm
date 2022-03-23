package Programmers.Lv1;
import java.util.*;
class ProgrammersLv1ArraysSum{
    public static void main(String[] args) {
        int[][] arr1 = {{5,6,7},{2,4,5},{4,5,6}};
        int[][] arr2 = {{5,6,7},{2,4,5},{4,5,6}};
        int[][] answer = arr1;
        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++)
                answer[i][j] = arr1[i][j]+arr2[i][j];
        }
        System.out.println(Arrays.deepToString(answer));
    }
}