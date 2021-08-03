package SSFAlgorithmLearn.Day2;

import java.util.Arrays;
// 1,2,3 순열 구할꺼임
public class 순열재귀2 {
    static int N=5, R =3; // n은 몇 개중    r= 몇개 뽑기
    static int[] numbers;
    static boolean[] isSelected;
    static int[] input;
    public static void main(String[] args) {
        input = new int[] {1,4,7,5,6};
        numbers = new int[R];
        isSelected = new boolean[input.length+1];
        permutation(0);
    }
    private static void permutation(int cnt){  // cnt는 자릿수를 의미한다.
        if(cnt==R) {        // r개 다 뽑을때 까지
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수들이 들어있는 배열 모든 원소에 대해서 i= index로
        for(int i=0; i<N; i++){    // 넣을 숫자 1~3까지
            if(isSelected[i]) continue; // true 일때 사용중이므로 다음 수로
            
            numbers[cnt] = input[i];    // number에 실제 숫자로 서장
            isSelected[i] = true;

            permutation(cnt+1);     // 다음 자리수 구하러 가기

            isSelected[i] = false;  // 기존의 사용했던 거를 다 초기화 시켜줍니다.
        }

    }
}
