package BackJun.Silver;

import java.io.*;
import java.util.*;
// 덧셈을 먼저 계산해서 -가 가장 크게 해준다.
public class S2잃어버린괄호_1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(),"-");        
        int result = Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int tmpResult =0;
            StringTokenizer plus = new StringTokenizer(st.nextToken(),"+");
            while(plus.hasMoreTokens()){
                tmpResult += Integer.parseInt(plus.nextToken());
            }
            if(result==Integer.MAX_VALUE){ // 처음부터 +로 시작하면 tmpResult로 초기값
                result = tmpResult;
            }else{ // -(a+b+c+e) 형태이므로 result-tmpResult하면 된다.
                result -= tmpResult;
            }
        }
        bw.write(""+result);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/1541