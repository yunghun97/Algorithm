import java.util.*;
public class Number{
public static void main(String[] args) {
    Scanner sc1 = new Scanner(System.in);
     int a = sc1.nextInt();
     int b = sc1.nextInt();
     int c = sc1.nextInt();
     sc1.close();
     int result = a*b*c;
     int x = 0; int y = 10;
     int[] answer = new int[10];
     while(y<result){
         x = result%10;
         answer[x] += 1;
         result /= 10;
     }
     x = result%10;
     answer[x] += 1;
     for(int i=0 ; i<answer.length; i++){
         System.out.println(answer[i]);
     }
        }
}