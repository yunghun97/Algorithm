package SSFAlgorithmLearn.Day3;
import java.util.Scanner;
public class 부분집합합구하기 {
    static int totalcount,N,S;
    static int[] input;
    static boolean[] isSelected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("배열 크기 입력 : ");
        N = sc.nextInt();
        System.out.print("목표로 하는 합 : ");
        S = sc.nextInt(); // 목표로 하는 합
        input = new int[N];
        isSelected = new boolean[N];
        totalcount =0;
        for(int i=0; i<N; i++){
            input[i] = sc.nextInt();
        }
        generateSubset(0);
        System.out.println("경우의 수 "+totalcount);
        sc.close();
    }
    private static void generateSubset(int cnt){
        if(cnt ==N){
            int sum=0;
            for(int i=0; i<N; i++){
                if(isSelected[i]) sum+=input[i];
            }
            if(sum==S){
                totalcount++;
                for(int i=0;i <N; i++){
                    if(isSelected[i]) System.out.print(input[i]+" ");
                }            
                System.out.println();
            }
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
