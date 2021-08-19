package BackJun.Bronze;
import java.io.*;
import java.util.StringTokenizer;
public class B3일우는야바위꾼_20361 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int locate = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        for(int i=0; i<order; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a==locate||b==locate){
                if(a==locate) locate = b;
                else locate = a;
            }
        }
        bw.write(""+locate);
        bw.flush();
        bw.close();
        br.close();
    }
}
// https://www.acmicpc.net/problem/20361