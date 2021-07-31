package SamSungSwExpert.D2;
import java.util.Scanner;
public class MostNumber {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int test = sc.nextInt();
        for(int T=1; T<=test; T++){
            int t = sc.nextInt();
            int[] arr = new int[101];
            for(int i=0; i<1000; i++){
            	arr[sc.nextInt()]++;
            }
            int count =0;
            int max =-1;
             for(int j=0; j<101; j++){      // 0~100까지 최빈수 출력 같은 값이면 큰거 출력
             	if(arr[j]>=count){
                	count=arr[j];
                    max = j;
                }
             }
            System.out.printf("#%d %d\n",T,max);
        }
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh