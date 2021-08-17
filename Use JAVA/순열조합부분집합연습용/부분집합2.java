package 순열조합부분집합연습용;
import java.util.Scanner;
public class 부분집합2 {
    static int totalcount,N;
    static int[] input;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열 크기 입력 : ");
        N = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        totalcount =0;
        System.out.println("배열 입력");
        for(int i=0; i<N; i++){
            input[i] = sc.nextInt();
        }
        System.out.println();
        generateSubset(0);
        System.out.println("경우의 수 "+totalcount);
        sc.close();
    }
    private static void generateSubset(int cnt){
        if(cnt ==N){
            totalcount++;
                for(int i=0; i<N; i++){
                    System.out.print((isSelected[i]?input[i]:"X")+" ");
                }
                System.out.println();
            return;
        }
        //현재 원소를 부분집합에 넣기
        isSelected[cnt] = true;
        generateSubset(cnt+1);
        
        //현재 원소를 부분집합에 넣지 않기 
        isSelected[cnt] =false;
        generateSubset(cnt+1);
    }
}
