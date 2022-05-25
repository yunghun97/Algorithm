package YMB_COS.exam2;
/*
class Main {
    public int func_a(String times) {
        int hour = Integer.parseInt(times.substring(0, 2));
        int minute = Integer.parseInt(times.substring(3));
        return hour * 60 + minute;
    }

    public int solution(String[] subwayTimes, String currentTime) {
        int currentMinute = func_a(currentTime); // 바꾼 부분
        int INF = 1000000000;
        int answer = INF;
        for (int i = 0; i < subwayTimes.length; ++i) {
            int subwayMinute = func_a(subwayTimes[i]);  // 바꾼 부분
            if (currentMinute <= subwayMinute) {  // 바꾼 부분
                answer = subwayMinute - currentMinute;
                break;
            }
        }
        if (answer == INF)
            return -1;
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String[] subwayTimes1 = { "05:31", "11:59", "13:30", "23:32" };
        String currentTime1 = "12:00";
        int ret1 = sol.solution(subwayTimes1, currentTime1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        String[] subwayTimes2 = { "14:31", "15:31" };
        String currentTime2 = "15:31";
        int ret2 = sol.solution(subwayTimes2, currentTime2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}
*/
// https://edu.goorm.io/learn/lecture/17301/cos-pro-1%EA%B8%89-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-java/lesson/839406/2%EC%B0%A8-%EB%AC%B8%EC%A0%9C2-%EC%A7%80%ED%95%98%EC%B2%A0-%EA%B8%B0%EB%8B%A4%EB%A6%AC%EA%B8%B0-java