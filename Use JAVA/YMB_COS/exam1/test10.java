package YMB_COS.exam1;

class Main {
    int solution(int[] prices) {

        int inf = 1000000001;
        int tmp = inf;
        int answer = -inf;
        for (int price : prices) {
            if (tmp != inf)
                answer = Math.max(answer, price - tmp); // 변경 부분
            tmp = Math.min(tmp, price);
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int[] prices1 = { 1, 2, 3 };
        int ret1 = sol.solution(prices1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int[] prices2 = { 3, 1 };
        int ret2 = sol.solution(prices2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839404/1%EC%B0%A8-%EB%AC%B8%EC%A0%9C10-%EC%A3%BC%EC%8B%9D%EC%9C%BC%EB%A1%9C-%EC%B5%9C%EB%8C%80-%EC%88%98%EC%9D%B5%EC%9D%84-%EB%82%B4%EC%84%B8%EC%9A%94-java