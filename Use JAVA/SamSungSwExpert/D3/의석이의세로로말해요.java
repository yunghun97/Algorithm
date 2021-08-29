package SamSungSwExpert.D3;
import java.io.*;
public class 의석이의세로로말해요 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String a = br.readLine();
            String b = br.readLine();
            String c = br.readLine();
            String d = br.readLine();
            String e = br.readLine();
            int a1 = a.length();
            int b1 = b.length();
            int c1 = c.length();
            int d1 = d.length();
            int e1 = e.length();
            bw.write("#"+t+" ");
            int i =0;
            while(true){
            if(i>a1&&i>b1&&i>c1&&i>d1&&i>e1) break;
            if(i<a1) bw.write(a.charAt(i));
            if(i<b1) bw.write(b.charAt(i));
            if(i<c1) bw.write(c.charAt(i));
            if(i<d1) bw.write(d.charAt(i));
            if(i<e1) bw.write(e.charAt(i));
            i++;
        }
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }    
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWVWgkP6sQ0DFAUO&categoryId=AWVWgkP6sQ0DFAUO&categoryType=CODE&problemTitle=%EC%9D%98%EC%84%9D%EC%9D%B4&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

/*
입력
2
ABCDE
abcde
01234
FGHIJ
fghij
AABCDD
afzz
09121
a8EWg6
P5h3kx
출력
#1 Aa0FfBb1GgCc2HhDd3IiEe4Jj
#2 Aa0aPAf985Bz1EhCz2W3D1gkD6x
*/