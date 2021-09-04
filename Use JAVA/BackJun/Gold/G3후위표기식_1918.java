package BackJun.Gold;
import java.io.*;
import java.util.Stack;
public class G3후위표기식_1918 {
    // 대문자 A = 65;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        char[] arr = input.toCharArray();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<input.length(); i++){
            if(arr[i]>='A'&&arr[i]<='Z') bw.write(arr[i]);
            else if(arr[i]=='('){
                st.push(arr[i]);
            }else if(arr[i]==')'){
                while(!st.isEmpty()){
                    if(st.peek()=='('){
                        st.pop();
                        break;
                    }
                    bw.write(st.pop());
                }
            }else{
                while(!st.isEmpty()&&comparison(st.peek())>=comparison(arr[i])){    // 자신보다 우선순위가 낮으면 자신을 그냥 저장 -> 같으면 비거나 작을때 까지 stack 값 출력
                    bw.write(st.pop());
                }
                st.push(arr[i]);
            }
        }
        while(!st.isEmpty()){
            bw.write(st.pop());
        }
        bw.flush();
        bw.close();
        br.close();
    }
    // 괄호는 )나올 떄 다 제거가 되므로 ( ) 구분이 따로 필요 없다.
    public static int comparison(char ch) {
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }
}
//https://www.acmicpc.net/problem/1918