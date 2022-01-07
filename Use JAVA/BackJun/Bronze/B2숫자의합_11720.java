package BackJun.Bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class B2숫자의합_11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));                
        br.readLine();       
        char[] arr = br.readLine().toCharArray();
        int answer = 0;
        for(char tmp : arr){
            answer += ((int) tmp) - 48;
        }
        bw.write(""+answer);
        bw.flush();
    }
}
