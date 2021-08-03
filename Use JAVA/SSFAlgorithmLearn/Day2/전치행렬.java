package SSFAlgorithmLearn.Day2;

import java.util.Arrays;
public class 전치행렬 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        int temp;
        System.out.println(Arrays.deepToString(arr));
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i>j){
                    temp = arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
