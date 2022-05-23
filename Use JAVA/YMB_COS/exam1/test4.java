package YMB_COS.exam1;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public long solution(long num) {

        long answer = 0;
        answer = num;
        while (true) {
            answer += 1;
            String a = String.valueOf(answer);
            if (a.contains("0"))
                continue;
            else
                break;
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        long num = 9949999;
        long ret = sol.solution(num);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839398/1%EC%B0%A8-%EB%AC%B8%EC%A0%9C4-%ED%83%80%EC%9E%84%EB%A8%B8%EC%8B%A0-java