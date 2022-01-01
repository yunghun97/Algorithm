package Programmers.Lv2;

public class 문자열압축 {
    public int solution(String s) {
        int answer = s.length();
        int N = s.length();

        for (int i = 1; i < N / 2 + 1; i++) { // 문자열 길이 6,7일경우 /2 한 3까지만 계산이 가능하다.
            String prev = s.substring(0, i); // 문자열 쪼개기
            int count = 1; // 일치한 문자 개수
            int enc = 0; // 현재 압축 단위의 문자열 길이
            String last = "";
            for (int j = i; j < N; j += i) { // 문자 끝까지 탐색
                if (j + i > s.length()) { // 길이가 넘어가는 경우
                    last = s.substring(j);
                    continue;
                }
                if (prev.equals(s.substring(j, j + i))) { // 다음 문자와 일치하는 경우
                    count++;
                } else { // 일치하지 않는 경우
                    enc += i; //
                    if (count != 1) { // 이미 겹치는 숫자가 있는 경우
                        enc += (int) Math.log10(count) + 1; // 자리수 만큼 더하기
                    }
                    prev = s.substring(j, j + i); // 다음 문자로 다시 세팅
                    count = 1; // 숫자 1로 초기화
                }
            }
            // 끝까지 다 온 경우 마지막 문자와 글자의 길이와 뒤에 짜투리 문자가 남아서 넘어온다.
            enc += prev.length() + last.length(); // 이전 문자열 길이 + 마지막 남은 문자 길이 더하기
            if (count != 1) {
                enc += (int) Math.log10(count) + 1; // 자리수 만큼 더하기
            }

            answer = Math.min(answer, enc);
        }

        return answer; // 정답 return
    }
}
