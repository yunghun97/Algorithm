package SamSungSwExpert.D4;
import java.io.*;
import java.util.*;
public class 계산기2배열X {     // 배열 안쓰고 char 선언하고 비교하는게 30% 더 빠름
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\계산기2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int t=1; t<=10; t++){
            int size = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(br.readLine());
            Stack<Character> operator = new Stack<>();
            Stack<Integer> num = new Stack<>();
            for(int i=0; i<size; i++){
                char checkO = sb2.charAt(i);
                if(!Character.isDigit(checkO)){ // 숫자가 아니면
                    while(true){    // 계속 돌린다
                    if(operator.isEmpty()){operator.add(checkO); break;  // 비었으므로 넣고 break;
                    }else if(operator.peek()==checkO){
                        sb.append(operator.pop());          // 같은 우선순위면 pop하고 다시 아래꺼 탐색
                    }else if(checkO=='*'&&operator.peek()=='+'){    // 우선순위가 더 높으므로 바로 stack에 저장한다.
                        operator.add(checkO);
                        break;
                    }else{
                        sb.append(operator.pop());      // 입력값 + 일 때 스택에 +,*가 있으면 스택에 있는거 sb에 저장 후 다시 아래꺼 부터 탐색
                    }
                }
                }else{
                    sb.append(checkO);      // 숫자면 sb에 바로 저장
                }
            }
            while(!operator.isEmpty()){     // 연산자 스택에 남은거 모두 sb에 저장하겠다.
            sb.append(operator.pop());}
            // System.out.println(sb.toString());

            for(int i=0; i<size; i++){
                char calNum = sb.charAt(i);
                if(Character.isDigit(calNum)){ // 숫자면 stack에 저장한다 0은 아스키코드 48이니까 -48
                    num.add(calNum-48);
                }else{                      // 연산자가 나오면 7-8 = 78-가 된다 따라서 8이 앞으로 가고 7이 뒤로 가야하며 결과 값을 stack에 다시 저장한다.
                    int b = num.pop();      // 먼저 뽑힌게 뒤로 가야한다.
                    int a = num.pop();      // 나중에 뽑힌 숫자를 앞으로
                    if(calNum=='*') num.add(a*b);  // *면 곱셈 아니면 +
                    else num.add(a+b);
                }
            }
            sb.setLength(0);    //sb 초기화
            sb2.setLength(0);
            bw.write("#"+t+" "+num.pop()+"\n");
            bw.flush();
            
        }
        bw.close();
        br.close();
    }
}
