package BackJun.Bronze;
import java.io.*;
public class B3직사각형을만드는방법_8320 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        int answer=0; // ex input = 10
        for(int i=1; i<=input; i++){    // 1,2,3,4,5,6,7,8,9,10
            for(int j=i; i*j<=input; j++){  // 1 -> 1,2,3,4,5,6,7,8,9,10 | 2 -> 4,6,8,10 | 3 -> 9
                answer++;
            }
        }
        // -< 가로*세로 = 사용한 사각형 개수 -> 가로*세로가 input보다 같거나 작으면 적절한 사각형
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
// 