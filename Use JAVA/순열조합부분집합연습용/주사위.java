package 순열조합부분집합연습용;
import java.util.Arrays;
import java.util.Scanner;

public class 주사위 {
    static int N, R;
    static int[] answer, input;
    static boolean[] isSelected;
    static int totalcount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("주사위 던질 횟수 : ");
        R = sc.nextInt();
        answer = new int[R];
        totalcount = 0;
        System.out.println("1. 중복 순열 2. 순열 3. 중복조합 4. 조합");
        int M = sc.nextInt();
        switch(M){
            case 1:     // 중복 순열
            dice1(0);    
            break;

            case 2:     // 순열
            isSelected = new boolean[7];
            dice2(0);
            break;

            case 3:     // 중복조합
            dice3(0,1);
            break;

            case 4:     // 조합
            dice4(0,1);
            break;
        }
        System.out.println("경우의 수 : " + totalcount);
            sc.close();
    }
    private static void dice1(int cnt){ // 중복 순열
        if(cnt==R){
            totalcount++;
            System.out.println(Arrays.toString(answer));
            return;
        }
        for(int i=1; i<=6; i++){
        answer[cnt] = i;
        dice1(cnt+1);       // 중복이 가능하므로 중복확인이 필요 없다
    }

    }
    private static void dice2(int cnt){     //순열
            if(cnt==R){
                totalcount++;
                System.out.println(Arrays.toString(answer));
                return;
            }
            for(int i=1; i<=6; i++){

            if(isSelected[i]) continue;
            
            answer[cnt] = i;
            isSelected[i] = true;      // 중복된 수 안되므로 중복 확인
            dice2(cnt+1);
            isSelected[i] = false;
        }
    }
    private static void dice3(int cnt, int start){  //중복조합
        if(cnt==R){
            System.out.println(Arrays.toString(answer));
            totalcount++;
            return;
        }
        for(int i=start; i<=6; i++){
            answer[cnt]=i;
            dice3(cnt+1,i);     // 중복이 가능하므로 현재 선택한 수 부터
        }
    }
    private static void dice4(int cnt, int start){  // 조합
        if(cnt==R){
            System.out.println(Arrays.toString(answer));
            totalcount++;
            return;
        }
        for(int i=start; i<=6; i++){
            answer[cnt]=i;
            dice4(cnt+1,i+1);   // 중복 불가로 현재 선택한 다음 수부터
        }
    }
}
