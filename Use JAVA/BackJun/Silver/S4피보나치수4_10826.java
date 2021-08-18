package BackJun.Silver;
import java.io.*;
import java.math.BigInteger;
public class S4피보나치수4_10826 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        BigInteger arr[];
        if(input==0) bw.write(""+0);
        else if(input==1) bw.write(""+1);
        else{
        arr = new BigInteger[input+1];
        arr[0]= BigInteger.ZERO;
        arr[1]= BigInteger.ONE;
        for(int i=2; i<input+1; i++){
            arr[i] = arr[i-2].add(arr[i-1]);
        }
        
        bw.write(String.valueOf(arr[input]));}
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/10826
