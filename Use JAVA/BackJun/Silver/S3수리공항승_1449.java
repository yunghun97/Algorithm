package BackJun.Silver;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class S3수리공항승_1449 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st= new StringTokenizer(br.readLine());
        int waterPoint = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        double[] arr = new double[waterPoint];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<waterPoint; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }
        Arrays.sort(arr);
        int answer = 1;
        double limit = arr[0]-0.5+length;
        for(int i=1; i<arr.length; i++){
            if(arr[i]+0.5>limit){
                answer++;
                limit = arr[i]-0.5+length;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
