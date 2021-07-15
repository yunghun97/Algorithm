import java.util.Arrays;
public class ProgrammersLv1SecretMap{
    public static void main(String[] args) {
        int n = 5;
        int[] map = new int[n];
        int[] arr1= {9,20,28,18,11}; int[] arr2 = {30,1,21,17,28};
        String[] user = new String[n];
        for(int i =0; i<n; i++){
            map[i] = (arr1[i] | arr2[i]);
        }
        for(int i =0; i<n; i++){
        user[i] = Integer.toBinaryString(map[i]);
        user[i] = user[i].replaceAll("1", "#");
        user[i] = user[i].replaceAll("0", " ");
        }
        System.out.println(Arrays.toString(user));

    }
}