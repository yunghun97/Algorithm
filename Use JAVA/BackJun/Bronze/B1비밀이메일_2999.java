package BackJun.Bronze;
import java.io.*;
public class B1비밀이메일_2999 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb= new StringBuilder();
        int size = input.length();
        int a =0;
        int b =0 ;
        for(int i=1; i<size; i++){
            if(size%i==0){
                if(i<=size/i){
                a= i;
                b = size/i;
                }else break;
            }
        }
        for(int i=0; i<a; i++){
            for(int j=i; j<a*b; j+=a){
                sb.append(input.charAt(j));
            }
        }
        System.out.println(sb.toString());
    }
}
//https://www.acmicpc.net/problem/2999
// 입력 boudonuimilcbsai
// 결과 bombonisuuladici