package BackJun.Bronze;
import java.io.*;
import java.util.StringTokenizer;

public class B1뒤집힌덧셈_1357 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        
        int a = reverse(Integer.parseInt(st.nextToken()));
        int b = reverse(Integer.parseInt(st.nextToken()));
        bw.write(""+reverse(a+b));
        bw.flush();
        bw.close();
        br.close();
    }
    static int reverse(int num){        // 숫자 뒤집는 메소드
        int result =0;
        while(num!=0){
            result = result*10+num%10;
            num/=10;
        }
        return result;
    }
}
