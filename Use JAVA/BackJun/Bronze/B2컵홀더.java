package BackJun.Bronze;
import java.io.*;

public class B2컵홀더 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //StringTokenizer st;
        //StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        String input = br.readLine();
        char[] arr = new char[size];
        arr = input.toCharArray();
        int cupCount =1;
        for(int i=0; i<size; i++){
            if(arr[i]=='S') {cupCount++; continue;}
            i++; cupCount++;
        }
        if(cupCount>=size) bw.write(""+size);
        else bw.write(""+cupCount);
        bw.flush();
        br.close();
        bw.close();

        /*for(int i=0; i<size; i++){
            if(arr[i]=='S') sb.append("*S");
            else{ sb.append("*LL"); i++; }
        }
        sb.append("*");
        arr = new char[sb.toString().length()];
        arr = sb.toString().toCharArray();
        System.out.println(sb.toString());
        int answer =0;
        for(int i=0; i<arr.length-1; i++){
           
        }*/
    }
}
