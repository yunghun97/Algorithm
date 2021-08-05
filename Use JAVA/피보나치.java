import java.io.*;
import java.util.StringTokenizer;
public class 피보나치{
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));
    }
    static long fibo(long num){
        if(num<=1) return num;
        
        return fibo(num-1) + fibo(num-2);
    }
    
}