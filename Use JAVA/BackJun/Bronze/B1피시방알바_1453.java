package BackJun.Bronze;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class B1피시방알바_1453 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];
        int answer =0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<size-1; i++){
            if(arr[i]==arr[i+1]) answer++;
        }
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
}
