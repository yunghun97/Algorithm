package BackJun.Bronze;
import java.io.*;
public class B1설탕배달_2839 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer=0;
        int input = Integer.parseInt(br.readLine());
        while(input>0){
            if(input%5==0){
                answer+=input/5;
                input-=input/5*5;
            }
            else{
                answer++;
                input-=3;
            }
        }
        bw.write(""+(input<0 ? -1 : answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
