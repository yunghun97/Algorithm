package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S1연산자끼워넣기_14888 {
    static int N, OPCOUNT,answer,answerMin;
    static int[] input,inputTemp, operArr, opers, result;
    static boolean[] isSelected;
        public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S1연산자끼워넣기_14888.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; 
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        inputTemp = new int[N];
        st = new StringTokenizer(br.readLine()); 
        for(int i=0; i<N; i++){
            inputTemp[i] = Integer.parseInt(st.nextToken());
        }
        operArr = new int[4];
        OPCOUNT = 0;    // 연산자 총 갯수 구하기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            int temp = Integer.parseInt(st.nextToken());
            operArr[i] = temp;
            OPCOUNT += temp;
        }
        answer=Integer.MIN_VALUE;
        answerMin = Integer.MAX_VALUE;
        opers = new int[OPCOUNT];   // 연산자 0,0,1,1,1,2,2,2 이런식으로 나눠서 저장할 배열
        result= new int[OPCOUNT];   // 연산자 순열 저장 배열
        isSelected = new boolean[OPCOUNT];  // 연산자 index 사용했는지 안했는지 체크용
        int index = 0;
        for(int i=0; i<4; i++){
            if(operArr[i]!=0){
                for(int j=0; j<operArr[i]; j++){
                    opers[index++] = i;
                }
            }
        }
        permutation(0);
        bw.write(""+answer+"\n"+answerMin);
        bw.flush();
        bw.close();
        br.close();
    }
        private static void permutation(int cnt) {
            if(cnt==OPCOUNT){
                copyInput();
                int temp = cal2();
                answer = Math.max(answer, temp);
                answerMin = Math.min(temp, answerMin);
                return;
            }
            for(int i=0; i<OPCOUNT; i++){
                if(isSelected[i]) continue;

                isSelected[i]=true;
                result[cnt] = opers[i];
                permutation(cnt+1);
                isSelected[i]=false;
            }

        }
        private static void copyInput() {
            for(int i=0; i<N; i++){
                input[i] = inputTemp[i];
            }
        }
        private static int cal2() {    // 숫자 인덱스 0,1,2 -> 연산자는 0,1
            // 0 덧셈 1 뺄셈 2 곱셈 3 나눗셈
            for(int i=0; i<OPCOUNT; i++){
                int a = input[i];
                int b = input[i+1];
                int oper = result[i];
                if(oper==0){
                    input[i+1] = a+b;
                }else if(oper==1){
                    if(b<0){
                        input[i+1] = a+b;
                    }else{
                        input[i+1] = a-b;
                    }
                }else if(oper==2){
                    input[i+1] = a*b;
                }else{
                    if((a>0&&b<0)||(a<0&&b>0)){
                        input[i+1] = (Math.abs(a)/Math.abs(b))*-1;
                    }else{
                        input[i+1] = a/b;
                    }
                }
            }
            return input[OPCOUNT];
        }    
}
