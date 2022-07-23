package BackJun.Silver;

import java.io.*;
import java.util.*;

public class S5덩치_7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        People[] arr = new People[N];        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));            
        }
        int[] answer = new int[N];                
        for(int i=0; i<N; i++){
            int count = 0;
            for(int j=0; j<N; j++){
                if(i==j) continue;
                if(arr[i].cm<arr[j].cm&&arr[i].kg<arr[j].kg) count++;
            }
            answer[i] = 1+count;
        }
        for(int rank : answer){
            bw.write(""+rank+" ");
        }
        bw.flush();        
    }
    static class People{        
        int kg;
        int cm;
        public People(int kg, int cm){
            this.kg = kg;
            this.cm = cm;
        }
    }
}
// https://www.acmicpc.net/problem/7568