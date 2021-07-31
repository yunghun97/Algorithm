package D2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ThreeSixNineGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i=1; i<=num; i++){
        	int a = i/10;
            int b = i%10;
           	if(a==3||a==6||a==9){
            	if(b==3||b==9||b==6){
                	System.out.printf("-- ");
                }
                else System.out.printf("- ");
            }
            else{
            	if(b==3||b==9||b==6){
               	System.out.printf("- ");
                }
                else
                    System.out.printf("%d ",i);
            }
        }
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PTeo6AHUDFAUq

/*
입력 50
출력 1 2 - 4 5 - 7 8 - 10 11 12 - 14 15 - 17 18 - 20 21 22 - 24 25 - 27 28 - - - - -- - - -- - - -- 40 41 42 - 44 45 - 47 48 - 50
*/
