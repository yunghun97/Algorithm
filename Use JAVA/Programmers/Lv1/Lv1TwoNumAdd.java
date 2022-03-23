package Programmers.Lv1;
import java.util.Arrays;
public class Lv1TwoNumAdd {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] answer = new int[201];
        int a=0;
        int n=0;
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length;j++){
                n = numbers[i]+numbers[j];
                answer[n]=1;
            }
        }
        //Arrays.sort(answer);
        for(int x=0; x<answer.length; x++){
            if(answer[x]!=0){
                a++;
                answer[x] = x;
            }
        }
        Arrays.sort(answer);
        int[] result = new int[a];
        int count=0;
        for(int y=201-a; y<201; y++){
            result[count]=answer[y];
            count++;
        }
        System.out.println(Arrays.toString(result));
    }
}
