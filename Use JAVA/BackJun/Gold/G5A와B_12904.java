package BackJun.Gold;

import java.io.*;
public class G5A와B_12904 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        String input = br.readLine();   // 초기값
        StringBuffer answer = new StringBuffer(br.readLine()); // 목표값

        while(input.length()<answer.length()){  // 목표값길이와 초기값 길이가 같아질 때 까지
            if(answer.charAt(answer.length()-1)=='A'){  // 목표값 마지막이 A면 초기값에서 뒤에 + A 한거이므로 목표값 마지막 A 삭제
                answer.deleteCharAt(answer.length()-1); 
            }else{
                answer.deleteCharAt(answer.length()-1); // B이면 뒤집고 B 추가한 것이므로 -> B 삭제후 뒤집기
                answer.reverse();
            }
        }
        if(input.equals(answer.toString())){    // 목표값과 초기값의 크기가 같을 때 -> 값이 같으면 1 아니면 0
            bw.write(""+1);
        }else bw.write(""+0);
        bw.flush();
    }
}
//https://www.acmicpc.net/problem/12904