package BackJun.Bronze;
import java.io.*;
public class B1슈퍼마리오 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        for(int i=0; i<10; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int abs = Integer.MAX_VALUE;
        int temp =0; int answer=0;
        for(int i=0; i<10; i++){
            temp+=arr[i];
            int nowAbs= Math.abs(100-temp);
            if(nowAbs<=abs){ 
                abs = nowAbs;
                answer = temp;
            }
            if(answer==100) break;
        }
        System.out.println(answer);
    }
}
