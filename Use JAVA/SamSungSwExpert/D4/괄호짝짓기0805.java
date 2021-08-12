package SamSungSwExpert.D4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호짝짓기0805{    
	public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\괄호짝짓기0805.txt"));
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        for(int t=1; t<=10; t++){	// 10번 돌아야 함
		int size = Integer.parseInt(br.readLine());	// 문자열의 크기
		String input = br.readLine();	// 문자열
		

		for(int i=0; i<size; i++){
			stack.push(input.charAt(i));	// 크기만큼 1글자씩 쪼개서 stack에 넣는다.
		}
		int[] arr = new int[8];		// 괄호 비교용 배열 
		while(!stack.empty()){		// stack.empty !(false)이므로 empty가 true 나올때 빠져나옴.
			switch(stack.peek()){	// 비교해서 배열에 집어넣고 넣은 요소 stack에서 제거
				case '(' :
					arr[0]++;
					stack.pop();	
				break;
				case ')' :
					arr[1]++;
					stack.pop();
				break;
				case '[' :
					arr[2]++;
					stack.pop();
				break;
				case ']' :
					arr[3]++;
					stack.pop();
				break;
				case '{' :
					arr[4]++;
					stack.pop();
				break;
				case '}' :
					arr[5]++;
					stack.pop();
				break;
				case '<' :
					arr[6]++;
					stack.pop();
				break;
				case '>' :
					arr[7]++;
					stack.pop();
				break;
			}
		}
		int answer =0;
		for(int j=0; j<8; j+=2){	// 0,1 | 2,3 | 4,5 | 6,7 비교해서 숫자가 같아야만 짝을 이룬다.
			if(arr[j]==arr[j+1]){
				answer++;		//answer가 4가 되면 서로 짝이 이룬다
			}
		}
		if(answer==4) answer =1;	// 4면 true
		else answer =0;	// 4보다 작으면 false
		System.out.printf("#%d %d\n",t,answer); //출력
		} // 테케 끝
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=%EA%B4%84%ED%98%B8&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1