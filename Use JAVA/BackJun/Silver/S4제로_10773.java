package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S4제로_10773 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            if(num==0){
                if(stack.isEmpty()) continue;
                stack.pop();
            }else stack.add(num);
        }
        int answer = 0;
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        bw.write(""+answer);
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/10773