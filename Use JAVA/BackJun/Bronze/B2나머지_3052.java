package BackJun.Bronze;
import java.io.*;
import java.util.*;
public class B2나머지_3052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Integer> hs = new HashSet<>();
        for(int i=0; i<10; i++){
            hs.add(Integer.parseInt(br.readLine())%42);
        }
        bw.write(""+hs.size());
        bw.flush();
        bw.close();
        br.close();
    }
} 
// https://www.acmicpc.net/problem/3052
/* 
입력
42
84
252
420
840
126
42
84
420
126
출력
1

*/
