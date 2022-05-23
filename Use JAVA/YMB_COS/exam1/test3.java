package YMB_COS.exam1;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    class Pair {
        public int firstNum;
        public int secondNum;
    }

    public int func_a(int numA, int numB, char exp) {
        if (exp == '+')
            return numA + numB;
        else if (exp == '-')
            return numA - numB;
        else
            return numA * numB;
    }

    public int func_b(String exp) {
        for (int i = 0; i < exp.length(); i++) {
            char e = exp.charAt(i);
            if (e == '+' || e == '-' || e == '*')
                return i;
        }
        return -1;
    }

    public Pair func_c(String exp, int idx) {
        Pair ret = new Pair();
        ret.firstNum = Integer.parseInt(exp.substring(0, idx));
        ret.secondNum = Integer.parseInt(exp.substring(idx + 1));
        return ret;
    }

    public int solution(String expression) {
        int expIndex = func_b(expression);
        Pair numbers = func_c(expression, expIndex);
        int result = func_a(numbers.firstNum, numbers.secondNum, expression.charAt(expIndex));
        return result;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String expression = "123+12";
        int ret = sol.solution(expression);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839397/1%EC%B0%A8-%EB%AC%B8%EC%A0%9C3-%EA%B3%84%EC%82%B0%EA%B8%B0-by-%EB%AC%B8%EC%9E%90%EC%97%B4-java