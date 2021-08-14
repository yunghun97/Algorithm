package BackJun.Bronze;
import java.io.*;
public class B2농구경기_1159 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for(int i=0; i<size; i++){
            int temp = br.readLine().charAt(0);
            arr[temp-97]++;
        }
        StringBuilder sb = new StringBuilder();
        int answer =0;
        for(int i=0; i<26; i++){
            if(arr[i]>=5){
                sb.append((char)(i+97));
            }
        }
        if(sb.length()==0){
            bw.write("PREDAJA");
        }
        else{
        bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
