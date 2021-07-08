import java.io.*;
;
public class Buffertest {
    public static void main(String[] args) throws IOException{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        bf.close();
        System.out.print(s);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = "ASDSADASD";
        bw.write(a);
        bw.close();
    }
}

