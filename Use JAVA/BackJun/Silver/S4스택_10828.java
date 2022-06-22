package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S4스택_10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            if(st.countTokens()==1){
                String order = st.nextToken();
                if(order.equals("top")){
                    if(stack.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(""+stack.peek());
                    }
                }else if(order.equals("size")){
                    bw.write(""+stack.size());
                }else if(order.equals("empty")){
                    if(stack.isEmpty()){
                        bw.write("1");
                    }else{
                        bw.write("0");
                    }
                }else{
                    if(stack.isEmpty()){
                        bw.write("-1");
                    }else{
                        bw.write(""+stack.pop());
                    }
                }
                bw.newLine();
            }else{
                st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
        }
        bw.flush();
    }    
}
// https://www.acmicpc.net/problem/10828