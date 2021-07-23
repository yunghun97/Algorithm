import java.util.Scanner;
public class expert1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();
        int answer =1;
        for(int i=1; i<=x; i++){
            System.out.printf("%d ",answer);
       		answer *=2;
        }
    }
}
