package BackJun.Bronze;
import java.io.*;
import java.util.*;
public class B1평균은넘겠지4344{
    public static void main(String[] args) throws IOException{
            System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Bronze\\B1평균은넘겠지4344.txt"));
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           StringTokenizer st;      
           int T= Integer.parseInt(br.readLine());
           for(int t=1; t<=T; t++){
           st = new StringTokenizer(br.readLine());
           int num = Integer.parseInt(st.nextToken());
           int[] arr = new int[num];
           int avg =0;
           Double cnt=0.0;
           for(int i=0; i<num; i++){
               arr[i] = Integer.parseInt(st.nextToken());
               avg += arr[i];
            }
           avg/=num;
           for(int number : arr){
               if(number>avg){
               cnt++;}
           }
           cnt=cnt/num; cnt*=100;
           System.out.printf("%.3f%%\n",cnt);
           }// 테케 끝
    }
}