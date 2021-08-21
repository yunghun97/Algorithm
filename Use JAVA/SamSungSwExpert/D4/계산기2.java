package SamSungSwExpert.D4;
import java.io.*;
import java.util.*;
public class 계산기2 {  // 배열써서 비교 더 배열x보다 더 느림
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\계산기2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for(int t=1; t<=10; t++){
            int size = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            char[] arr = new char[size];
            arr = br.readLine().toCharArray();      // 처음 문자열 배열로
            Stack<Character> operator = new Stack<>();
            Stack<Integer> num = new Stack<>();
            for(int i=0; i<size; i++){
                if(!Character.isDigit(arr[i])){ // 숫자가 아니면
                    while(true){    // 계속 돌린다
                    if(operator.isEmpty()){operator.add(arr[i]); break;  // 비었으므로 넣고 break;
                    }else if(operator.peek()==arr[i]){
                        sb.append(operator.pop());          // 같은 우선순위면 pop하고 다시 아래꺼 탐색
                    }else if(arr[i]=='*'&&operator.peek()=='+'){    // 우선순위가 더 높으므로 바로 stack에 저장한다.
                        operator.add(arr[i]);
                        break;
                    }else{
                        sb.append(operator.pop());      // 입력값 + 일 때 스택에 +,*가 있으면 스택에 있는거 sb에 저장 후 다시 아래꺼 부터 탐색
                    }
                }
                }else{
                    sb.append(arr[i]);      // 숫자면 sb에 바로 저장
                }
            }
            while(!operator.isEmpty()){     // 연산자 스택에 남은거 모두 sb에 저장하겠다.
            sb.append(operator.pop());}
            char[] arr2 = new char[size];   // 후위연산자로 정렬된 arr2배열 선언
            arr2 = sb.toString().toCharArray();
            for(int i=0; i<size; i++){
                if(Character.isDigit(arr2[i])){ // 숫자면 stack에 저장한다 0은 아스키코드 48이니까 -48
                    num.add(arr2[i]-48);
                }else{
                    int b = num.pop();      // 먼저 뽑힌게 뒤로 가야한다.
                    int a = num.pop();      // 나중에 뽑힌 숫자를 앞으로
                    if(arr2[i]=='*') num.add(a*b);  // *면 곱셈 아니면 +
                    else num.add(a+b);
                }
            }
            sb.setLength(0);    //sb 초기화
            bw.write("#"+t+" "+num.pop()+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14nnAaAFACFAYD&

/*
후위 연산자 만드는법 : 숫자면 그냥 읽기 연산자면 stack에 저장하며 비교하면서 문자열 만들기
후위 연산자 계산 : 숫자면 스택에 저장 -> 연산자 읽으면 그 연산자와 스택에 2개 원소 가져와서 계산(스택이므로 처음 꺼내오는게 b 그 다음꺼 a -> a~b연산) -> 다시 스택에 결과 저장


레벨 높은거 : ex) /, *   낮은거 ex) + -
스택에 저장되어있는 연산자 레벨 > 새로 읽어온 연산자 -> 스택에 있는거 출력
스택에 저장되어있는 연산자 레벨 == 새로 읽어온 연산자 -> 스택에 있는거 출력
스택에 저장되어있는 연산자 레벨 < 새로 읽어온 연산자 -> 새로운 연산자 스택에 저장

즉 스택이 비어있거나 스택에 있는 연산자가 새로 읽어온 연산자보다 우선순위가 낮을 때 까지 계속 while문으로 돌려야 함.
*/