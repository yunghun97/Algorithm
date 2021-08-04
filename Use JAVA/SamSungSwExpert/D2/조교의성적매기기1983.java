package SamSungSwExpert.D2;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 조교의성적매기기1983{
    	static String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};    // 성적표
	public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D2\\조교의성적매기기1983.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
      	int T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int all = Integer.parseInt(st.nextToken());
            int find = Integer.parseInt(st.nextToken());
            Double[] arr = new Double[all];
            for(int i=0; i<all; i++){
            	st = new StringTokenizer(br.readLine()," ");
                arr[i] = (Double.parseDouble(st.nextToken())*0.35) + (Double.parseDouble(st.nextToken())*0.45) + (Double.parseDouble(st.nextToken())*0.2);   // 총합 저장
            }
            double temp = arr[find-1];         // 배열은 0부터 이므로 찾는 번호에서 -1해준다
            int answer =0;
            Arrays.sort(arr, Collections.reverseOrder()); // 오름차순 정렬
            for(int j=0; j<all; j++){
            	if(arr[j]==temp){
    				answer = j;
                   	answer++;   // answer = 배열이라 현재순위 -1 되있으므로 +1;
                    break;
                }
            }
            int percent = all/10;   // 10%에 해당하는 숫자
            int result =0;  //성적표 배열 index로 활용
            while(true){             
            	if(answer>percent){     // 순위가 현재 10%단위 보다 낮으면 퍼센트 10%씩 증가 + 배열 인덱스 +1
                	percent+=all/10;
                    result++;
                }
                else{
                	System.out.printf("#%d %s\n",t,grade[result]);  // 현재 순위가 (n-1)0%<answer<=n0% 이므로 출력
                    break;
                }
            }
        }	//테케 끝
    
    }
}