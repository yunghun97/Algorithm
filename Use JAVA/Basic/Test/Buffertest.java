package Basic.Test;
import java.io.*;
public class Buffertest {
    public static void main(String[] args) throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        bf.close();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(s);
        bw.close();
    }
}
