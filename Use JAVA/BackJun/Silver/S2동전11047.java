package BackJun.Silver;
import java.io.*;
import java.util.StringTokenizer;
public class S2동전11047{
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S2동전11047.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int[] arr = new int[len];
        int count =0;
        for(int i=0; i<len; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int j=len-1; j>=0; j--){
            while(true){
            if(money>=arr[j]){
                count++;
                money-=arr[j];
            }
            else break;
        }
        }
        System.out.println(count);
    }
}