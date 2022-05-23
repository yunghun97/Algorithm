package YMB_COS.exam1;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int func(int record) {
        if (record == 0)
            return 1;
        else if (record == 1)
            return 2;
        return 0;
    }

    public int solution(int[] recordA, int[] recordB) {

        int cnt = 0;
        for (int i = 0; i < recordA.length; i++) {
            if (recordA[i] == recordB[i])
                continue;
            else if (recordA[i] == func(recordB[i])) // 가위 바위 보 -> return 값은 가위면 1 바위면 2 보면 0을 준다.
                cnt = cnt + 3;
            else
                cnt = Math.max(0, cnt - 1); // 변경 부분
        }
        return cnt;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int[] recordA = { 2, 0, 0, 0, 0, 0, 1, 1, 0, 0 };
        int[] recordB = { 0, 0, 0, 0, 2, 2, 0, 2, 2, 2 };
        int ret = sol.solution(recordA, recordB);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");

    }
}
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839403/1%EC%B0%A8-%EB%AC%B8%EC%A0%9C9-%EA%B3%84%EB%8B%A8-%EA%B2%8C%EC%9E%84-java