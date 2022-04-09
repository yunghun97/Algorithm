package BackJun.Silver;

import java.io.*;
import java.util.*;
public class S4카드2_2164 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            q.add(i);
        }

        int result = 0;
        if(q.size()>1){
            while(true){
                q.poll();
                result = q.poll();
                if(q.isEmpty()){
                    break;
                }
                q.add(result);
            }
        }else{
            result = q.poll();
        }
        bw.write(""+result);
        bw.flush();
    }    
}
// https://www.acmicpc.net/problem/2164