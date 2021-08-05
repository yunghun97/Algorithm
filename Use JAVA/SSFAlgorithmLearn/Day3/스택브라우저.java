package SSFAlgorithmLearn.Day3;

import java.util.Stack;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class 스택브라우저 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        String input = null;
        String current ="https://default.com";

        Stack<String> back = new Stack<>();
        Stack<String> foward = new Stack<>();

        while(true){
            input = br.readLine();
            if(input.charAt(0)=='Q') break;
            st = new StringTokenizer(input, " ");
            switch(st.nextToken()){
                case "V":
                    foward.clear();
                    back.push(current);
                    current = st.nextToken();
                    System.out.println(current);
                break;
                case "B":
                if(!back.empty()){
                    foward.push(current);
                    current = back.pop();  
                    System.out.println(current);
                }
                else{
                    System.out.println("불가능함");
                }
                break;
                    
                case "F":
                if(!foward.empty()){
                    back.push(current);
                    current = foward.pop();  
                    System.out.println(current);
                }
                else{
                    System.out.println("불가능함");
                }
                break;
                


            }
        }
    }
}
