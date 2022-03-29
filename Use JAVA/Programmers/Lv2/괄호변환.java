package Programmers.Lv2;

import java.util.*;

public class 괄호변환 {
    static StringBuilder sbAnswer; // 답 저장 용

    public static void main(String[] args) {        
        solution("()))((()");
    }

    private static String solution(String p) {
        sbAnswer = new StringBuilder();
        String input = p;
        if (rightCheck(input)) { // 이미 처음부터 완벽하면 그냥 바로 저장
            sbAnswer.append(input);
        } else { // 처음부터 완전하지 않으면
            String[] arr = separate(input);
            move(arr);
        }
        return sbAnswer.toString();
    }

    private static void move(String[] arr) { // 재귀 탐색
        if (arr[0].equals("") || rightCheck(arr[0])) { // arr[0]이 올바른 괄호 문자열인 경우
            sbAnswer.append(arr[0]); // 넣어주기
            if (arr[1] == null || arr[1].equals("")) // arr[1]이 비어있으면 return
                return;

            String[] tmpArr = separate(arr[1]); // 비어있지 않으면 뒤에 v도 계산한다.
            move(tmpArr);
        } else { // 문자열 u가 "올바른 괄호 문자열"이 아니라면  4-1부터
            sbAnswer.append('('); // 4-1  (  추가
            String[] tmpArr = separate(arr[1]); // 4-2 v 재귀 탐색하기 위한 arr[1]
            if (tmpArr[0] != null) { // v가 비어있지 않을 때만
                move(tmpArr);
            }
            sbAnswer.append(')'); // 4-3 ) 추가
            char[] tmp = arr[0].toCharArray(); // 기존 u 배열
            for (int i = 1; i < tmp.length - 1; i++) { // 기존 u배열의 맨앞과 맨뒤를 제외하고 반대로 해서 추가
                if (tmp[i] == '(')
                    sbAnswer.append(')');
                else
                    sbAnswer.append('(');
            }
        }
    }
    /**
     * 
     * @param input 문자열
     * @return true 올바른 문자열 flase = 올바른 문자열 아님
     */
    private static boolean rightCheck(String input) {
        if (!input.equals(null)) { // null 값이 아닐때만
            Stack<Character> stack = new Stack<>();
            char[] tmp = input.toCharArray();
            if (tmp[0] == ')') // 처음부터 ) 등장시 false return
                return false;
            else {
                stack.push(tmp[0]); // ( 넣고   ) 등장시 stack에서 스택 제거 -> 스택에 추가 삭제에서 오류가 발생하면 올바르지 않은 문자열
                for (int i = 1; i < tmp.length; i++) {
                    if (tmp[i] == '(') {
                        stack.push(tmp[i]);
                    } else { 
                        if (stack.isEmpty()) // 이미 비어있으면 올바르지 않은 문자열
                            return false;
                        stack.pop();
                    }
                }
            }
        }
        return true;
    }
    /**
     * 
     * @param input 문자열
     * @return String[0] = 처음 등장하는 균형잡힌 괄호 문자열 String[1] 는 나머지
     */
    private static String[] separate(String input) {
        char[] arr = input.toCharArray(); // 배열 toCharArray로 만들기
        String[] result = new String[2];
        int left = 0; // (  개수
        int right = 0; // ) 개수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) { // 길이 만큼 탐색
            if (arr[i] == '(') { // 왼쪽 개수
                left++;
                sb.append(arr[i]);
            } else { // 오른쪽 개수
                right++;
                sb.append(arr[i]);
            }
            if (left != 0 && right != 0 && left == right) { // 둘 다 0 이아니고 균형잡힌 문자열 처음 등장 시
                result[0] = sb.toString(); // 균형잡힌 문자열 세팅
                sb.setLength(0); // 초기화
                for (int j = i + 1; j < arr.length; j++) { // 다음 index부터 끝까지 나머지 넣어주기
                    sb.append(arr[j]);
                }
                result[1] = sb.toString(); 
                break;
            }
        }
        return result;
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/60058