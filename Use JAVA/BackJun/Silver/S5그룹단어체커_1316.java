package BackJun.Silver;

import java.io.*;

public class S5그룹단어체커_1316 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int count = T; 
        for (int i = 0; i < T; i++) { 
            String word = br.readLine();
            for (int j = 1; j < word.length(); j++) {
                 if (word.indexOf(word.charAt(j - 1)) > word.indexOf(word.charAt(j))){  // indexOf는 해당 문자가 나온 처음위치를 알려준다 앞 과 뒤에서 비교시 뒤에 문자가 앞문자보다 작으면 안된다.
                     count--; break; 
                } 
            } 
        } 
        bw.write(""+count);
        bw.flush();
    }
}
//https://www.acmicpc.net/problem/1316