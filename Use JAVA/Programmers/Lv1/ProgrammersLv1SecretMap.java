package Programmers.Lv1;
import java.util.Arrays;
public class ProgrammersLv1SecretMap{
    public static void main(String[] args) {
        int n = 5;
        int[] arr1= {9,20,28,18,11}; int[] arr2 = {30,1,21,17,28};
        String[] user = new String[n];
        for(int i =0; i<n; i++){
        user[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        user[i] = String.format("%"+n+"s",user[i]); // 앞에 자리가 0일경우 생략하게 되므로 강제로 추가 해준다.
        user[i] = user[i].replace("1", "#");
        user[i] = user[i].replace("0", " ");
        }
        System.out.println(Arrays.toString(user));

    }
}
