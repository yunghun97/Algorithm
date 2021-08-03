package SSFAlgorithmLearn.Day2;

import java.util.Arrays;
// 1,2,3 순열 구할꺼임
public class 조합재귀1 {
    static int N=4, R =3; // n은 몇 개중    r= 몇개 뽑기
    static int[] numbers;
    static int[] input;
    public static void main(String[] args) {
        input = new int[] {1,4,5,8};
        numbers = new int[R];
        combination(0,0);
    }
    private static void combination(int cnt, int start){  // cnt는 자릿수를 의미한다.   // start 넣음으로써 바로 다음 수로 넘어가서 중복을 방지한다.
        if(cnt==R) {        // r개 다 뽑을때 까지
            System.out.println(Arrays.toString(numbers));
            return;
        }
        
        for(int i=start; i<N; i++){    // i : 인덱스
            numbers[cnt] = input[i];   
            System.out.println("**" + numbers[cnt]);
            // 조합이니까 바로 다음 자리순열 뽑으로 감
            combination(cnt+1,i+1);    
        }

    }
}
