package SSFAlgorithmLearn.Day2;

import java.util.Arrays;
// 1,2,3 순열 구할꺼임
public class 순열재귀1 {
    static int N=3, R =3; // n은 몇 개중    r= 몇개 뽑기
    static int[] numbers;
    static boolean[] isSelected;
    public static void main(String[] args) {
        numbers = new int[R];
        isSelected = new boolean[N+1];
        permutation(0);
    }
    private static void permutation(int cnt){  // cnt는 자릿수를 의미한다.
        if(cnt==R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for(int i=1; i<=N; i++){    // 넣을 숫자 1~3까지
            if(isSelected[i]) continue; // true 일때 사용중이므로 다음 수로
            
            numbers[cnt] = i;
            isSelected[i] = true;

            permutation(cnt+1);     // 다음 자리수 구하러 가기

            isSelected[i] = false;  // 기존의 사용했던 거를 다 초기화 시켜줍니다.
        }

    }
}
