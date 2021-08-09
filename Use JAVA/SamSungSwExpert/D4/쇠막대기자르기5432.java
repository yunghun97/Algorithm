package SamSungSwExpert.D4;


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기자르기5432{    
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("Use JAVA\\input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++){
		Stack<Character> s = new Stack<>();
		int ans =0, cnt =0;
		char[] data = br.readLine().toCharArray();
		for(char c : data){
			if(c =='('){
				cnt =0;
				s.push(c);
				continue;
			}
			s.pop(); // 현재의 닫는 괄호와 쌍이되는 여는 괄호 꺼내기
			cnt++; 
			if(cnt ==1){ // 레이저
				ans += s.size();
			}
			else{	//막대의 끝
				ans++;
			}
		}
		// c가 여는 괄호일 경우 카운트 0으로 스택에 넣는다.
		// c가 닫는 괄호을 경우 여는 괄호 하나 스택에서 빼낸다. count 1증가 
		//count 1이면 레이저 ->> 기존 막대 수 + 스택의 크기를 더한다.
		//count 1이 아니면 이건 막대의 끝 -> 기존 막대의 수 +1
		System.out.printf("#%d %d\n",t,ans);


	}// 테케 끝
    }
}

// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVl47b6DGMDFAXm&categoryId=AWVl47b6DGMDFAXm&categoryType=CODE&problemTitle=%EC%9E%90%EB%A5%B4%EA%B8%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1