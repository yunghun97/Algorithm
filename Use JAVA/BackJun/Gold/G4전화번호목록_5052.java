package BackJun.Gold;

import java.util.*;
import java.io.*;

public class G4전화번호목록_5052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));        
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            boolean useful = true;
            int N = Integer.parseInt(br.readLine());            
            String[] arr = new String[N];
            for(int i=0; i<N; i++){
                arr[i] = br.readLine();
            }
            Arrays.sort(arr);
            for(int i=0; i<N-1; i++){
                if(arr[i+1].startsWith(arr[i])){
                    useful = false;
                    break;
                }
            }
            if(useful){
                bw.write("YES");
            }else{
                bw.write("NO");
            }
            if(t!=T-1) bw.newLine();
        }
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/5052