package BackJun.Silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S1곱셈_1629 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
    
        int num1 = Integer.parseInt(st.nextToken());
        int multi = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(solve(num1, multi, divide)));
        bw.flush();
        
    }

    private static long solve(int num1, int multi, int divide){      
        if(multi==0){
            return 1;
        }  
        long n = solve(num1, multi / 2 , divide);
        if(multi % 2 == 0){
            return n * n % divide;
        }else{
            return n * n % divide * num1 % divide;
        }
    }
}


// 참고자료 https://st-lab.tistory.com/237