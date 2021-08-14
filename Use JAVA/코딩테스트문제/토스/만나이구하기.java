package 코딩테스트문제.토스;

public class 만나이구하기 {
    
}
/*
import java.util.*;
class Solution {
    public int solution(String date, String[] requests) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6));
        int day = Integer.parseInt(date.substring(6,8));
        int available =0;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i=0; i<requests.length; i++){
            st = new StringTokenizer(requests[i],",");
            st.nextToken();
            sb.setLength(0);
            sb.append(st.nextToken());
            int yearTemp = Integer.parseInt(sb.substring(0,4));
            int monthTemp = Integer.parseInt(sb.substring(4,6));
            int dayTemp = Integer.parseInt(sb.substring(6,8));
            if(year-yearTemp>20){
                available ++;
                sb.setLength(0);
                continue;
            }
            else if(year-yearTemp==20){ // 생일이 지나야함 -> 나의 월, 일이 더 작거나 같아야 한다.
                if(month<monthTemp){
                    continue;       
                }
                else if(month==monthTemp){ // 일로 비교
                    if(day<=dayTemp){
                        available++;
                        continue;
                    }
                    else{
                        continue;
                    }
                }
                else{
                    available++;
                    continue;
                }
            }
        }
        return available;
    }
}
*/

//입력 형태 : String a = 20210701 String[] b = ["김토스,19900605", "이토스,20020729"]~~~ 를 매개변수로 받아 준다.

/*토스신용카드 발급 가능 연령
토스신용카드는 만 19세부터 발급 받을 수 있습니다.

요구사항
발급을 희망하는 사용자들의 개인정보를 통해 발급 가능 여부를 확인하는 프로그램을 작성해주세요.

입력 설명
date 에는 토스신용카드 발급 신청 날짜(yyyyMMdd)가 주어집니다. 이 날짜는 토스신용카드 발급 가능 여부를 판단하는 기준 날짜가 됩니다.

20210701
requests 에는 토스신용카드 발급을 신청한 사람들의 이름과 생년월일(yyyyMMdd)이 주어집니다. 이름과 생년월일 사이에는 공백 없이 쉼표(,)로 구분합니다.

["김토스,19900605", "이토스,20020729"]
출력 설명
토스신용카드 신청자 중, 발급 가능한 사람의 수를 반환합니다.*/