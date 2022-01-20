package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4문자열폭발_9935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();
        char[] arr = br.readLine().toCharArray();
        String boom = br.readLine();        
        
        for(int i=0; i<arr.length; i++){
            stack.push(arr[i]); // 넣기
            if(stack.size()>=boom.length()){ // 비교할 수 있는 길이가 되면 비교
                if(checkBoom(stack,boom)){
                    for(int x = 0; x<boom.length(); x++) stack.pop();   // 포함되어 있으면 stack 뒤에서 길이만큼 제거하기
                }
            }
            
        }
        if(stack.size()==0){
            bw.write("FRULA");
        }else{            
            for(char a : stack){
                bw.write(a);                
            }            
        }
        bw.flush();
    }
    /**
     * 문자열 비교 하는 메소드
     * @param stack 기존 문자열을 저장
     * @param boom  폭발하는 문자열
     * @return
     */
    private static boolean checkBoom(Stack<Character> stack, String boom) {
        for(int i=0; i<boom.length(); i++){
            if(stack.get(stack.size()-1-i)==boom.charAt(boom.length()-1-i)) continue;   // 끝에서 한글자 씩 비교해서 같으면 true return
            else return false;
        }
        return true;
    }
}
// https://www.acmicpc.net/problem/9935