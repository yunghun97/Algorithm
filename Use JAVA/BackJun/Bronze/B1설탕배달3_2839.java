package BackJun.Bronze;
import java.util.Scanner;
public class B1설탕배달3_2839 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.close();
        if(M==4 || M==7){
            System.out.println(-1);
            return;
        }
        int answer = M/5;
        if(M%5 ==1 || M%5 ==3){
            answer++;
        }
        else if(M%5 ==2 || M%5 ==4){
            answer +=2;
        }
        System.out.println(answer);
    }
    
}
