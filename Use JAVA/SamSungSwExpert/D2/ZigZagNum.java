package D2;
import java.util.Scanner;
public class ZigZagNum {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T= sc.nextInt();
        for(int x=1; x<=T; x++){
            int input = sc.nextInt();
            int answer = 0;
        for(int i=1; i<=input; i++)
        {
            if(i%2!=0)
                answer+=i;
            else
                answer-=i;
        }
            System.out.printf("#%d %d\n",x,answer);
            answer =0;
        }
        sc.close();}
}
/*
입력
2
5
6

출력 
#1 3
#2 -3
*/