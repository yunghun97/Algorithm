package SamSungSwExpert.D3;
import java.io.*;
import java.util.StringTokenizer;
public class 삼성시의버스노선 {
    static int[] answer;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            answer = new int[5001];
            int busCount = Integer.parseInt(br.readLine());
            for(int i=0; i<busCount; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                check(a,b);
            }            
            
            int p = Integer.parseInt(br.readLine());
            int[] temp = new int[p];
            for(int i=0; i<p; i++){
                int tmp = Integer.parseInt(br.readLine());
                temp[i] = answer[tmp];
            }
            bw.write("#"+t+" ");
            for(int i=0; i<p; i++){
                bw.write(""+temp[i]+" ");
            }
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
    private static void check(int a, int b) {
        for(int i=a; i<=b; i++){
            answer[i]++;
        }
    
    }
}
