package BackJun.Silver;

import java.io.*;
public class S4괄호_9012 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            bw.write(check(br.readLine()));
            bw.newLine();
        }
        bw.flush();
    }
    
    private static String check(String input) {
        int count=0;            
        for(char a : input.toCharArray()){
            if(a=='(') count++;
            else if(count==0){  // (가 없는 상태에서  ) 가 나 온경우
                return "NO";                
            }else{
                count--;
            }
        }
        if(count==0){
            return "YES";
        }else{
            return "NO";
        }
    }

}
// https://www.acmicpc.net/problem/9012