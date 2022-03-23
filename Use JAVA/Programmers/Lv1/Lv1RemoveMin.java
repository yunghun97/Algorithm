package Programmers.Lv1;

import java.util.Arrays;

public class Lv1RemoveMin {
    public static void main(String[] args) {
    int[] arr ={5,5,5,5,1,3,0,1};
    int[] zero = {-1};
        int first = arr.length;
        int MIN = 1000000;
        int map = 0;
        int a=0;
        int[] answer = new int[first-1];
        if(first==1){
            System.out.println(Arrays.toString(zero));
        }
        else{
            for(int i=0; i<first; i++){
                if(arr[i]<MIN){
                    map = i;
                    MIN = arr[i];
                }
            }
            for(int j=0; j<first; j++){
                if(j==map){
                    continue;
                }
                else{
                    answer[a]=arr[j];
                    a++;
                }
            }
        }
            System.out.println(Arrays.toString(answer));
    }
}
