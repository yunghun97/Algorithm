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

/*
입력 ["김토스,19900605", "이토스,20020729"]
출력 1
*/
