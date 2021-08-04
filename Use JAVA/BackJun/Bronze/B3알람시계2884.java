package BackJun.Bronze;
import java.io.*;
import java.util.*;
public class B3알람시계2884 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\B3알람시계2884.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minu = Integer.parseInt(st.nextToken());
        minu-=45;
        if(minu<0){
            hour--;
            minu+=60;
        }
        if(hour<0){
            hour +=24;
        }
        System.out.printf("%d %d\n",hour,minu);
    }
}
