package BackJun.Bronze;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class B3사과10883 {
    public static void main(String[] args)throws FileNotFoundException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Bronze\\B3사과10883.txt"));
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int answer = 0;
        int a =0; int b=0;
        for(int i=0; i<size; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            answer += b-((b/a)*a);
        }
        System.out.println(answer);
        sc.close();
    }
    
}
