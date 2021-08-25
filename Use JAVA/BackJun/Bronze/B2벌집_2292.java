package BackJun.Bronze;
import java.util.Scanner;
public class B2벌집_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int purpose = sc.nextInt();
        int answer =1;
        int start = 1;
        int temp =6;
        while(start<purpose){
            start+=temp;
            temp+=6;
            answer++;
        }
        System.out.println(answer);
        sc.close();
    }
}
//https://www.acmicpc.net/problem/2292
//입력 13 결과 -> 3