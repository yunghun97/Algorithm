package YMB_COS.exam1;
/*
import java.util.*;
class Main {
    public int[] solution(int[] arrA, int[] arrB) {
        int arrA_idx = 0, arrB_idx = 0;
        int arrA_len = arrA.length;
        int arrB_len = arrB.length;
        int answer[] = new int[arrA_len + arrB_len];
        int answer_idx = 0;
        while(arrA_idx<arrA.length&&arrB_idx<arrB.length){
            if(arrA[arrA_idx] < arrB[arrB_idx])
                answer[answer_idx++] = arrA[arrA_idx++];
            else
                answer[answer_idx++] = arrB[arrB_idx++];
        }
        while(arrA_idx<arrA.length)
            answer[answer_idx++] = arrA[arrA_idx++];
        while(arrB_idx<arrB.length)
            answer[answer_idx++] = arrB[arrB_idx++];
        return answer;
    }
    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int[] arrA = {-2, 3, 5, 9};
        int[] arrB = {0, 1, 5};
        int[] ret = sol.solution(arrA, arrB);
 
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + Arrays.toString(ret) + " 입니다.");
    }
}
*/
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839401/1%EC%B0%A8-%EB%AC%B8%EC%A0%9C7-%EB%B3%91%ED%95%A9-and-%EC%A0%95%EB%A0%AC-java