package BackJun.Silver;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// 5 3 형태로 입력하면 됨.
public class S3N과M2_15650 {
        static int N,R;
        static int[] answer, input;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N];
        answer = new int[R];
        for(int i=0; i<N; i++){
            input[i] = i+1;
        }
        combination(0,0);
    }
    private static void combination(int cnt, int start){
        if(cnt==R){
            for(int i=0; i<R; i++){
                System.out.print(answer[i]+" ");
            }
            System.out.println();
            return;            
        }
        for(int x=start; x<N; x++){
            
            answer[cnt] = input[x];
            combination(cnt+1,x+1);
                        
        }
        
        
    }
}