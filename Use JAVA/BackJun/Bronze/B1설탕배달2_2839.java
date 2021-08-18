package BackJun.Bronze;
import java.util.Scanner;
public class B1설탕배달2_2839 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] memo = new int[M+1];
        for(int i=0; i<memo.length; i++){
            if(i%3==0){
                memo[i] = i/3;
            }else{
                memo[i] = 987654321;
            }
        }
        for(int i=5; i<memo.length; i++){
            if(memo[i]>memo[i-5]+1){
                memo[i]=memo[i-5]+1;
            }
        }
        System.out.println(memo[M]==987654321 ? -1 : memo[M]);
        sc.close();
    }
}
