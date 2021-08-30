package SamSungSwExpert.D3;
import java.io.*;
import java.util.StringTokenizer;
public class 안경이없어 {
    static String zero, one, two;
    static int a,b,c;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        zero = "CEFGHIJKLMNSTUVWXYZ";
        one = "ADOPQR";
        two = "B";
        for(int t=1; t<=T; t++){
            
            bw.write("#"+t+" ");
            st = new StringTokenizer(br.readLine()," ");
            String input1 = st.nextToken();
            String input2 = st.nextToken();
            int[] b1 = new int[input1.length()];
            int[] b2 = new int[input2.length()];
            if(b1.length!=b2.length){
                bw.write("DIFF\n");
                continue;
            }

            for(int i=0; i<input1.length(); i++){
                char temp1 = input1.charAt(i);
                if(zero.contains(String.valueOf(temp1))) b1[i]=1;
                else if(one.contains(String.valueOf(temp1))) b1[i]=2;
                else b1[i]=3;
            }

            for(int i=0; i<input2.length(); i++){
                char temp2 = input2.charAt(i);
                if(zero.contains(String.valueOf(temp2))) b2[i]=1;
                else if(one.contains(String.valueOf(temp2))) b2[i]=2;
                else b2[i]=3;
            }
            boolean check = true;
            for(int i=0; i<b1.length; i++){
                if(b1[i]!=b2[i]){
                    bw.write("DIFF\n");
                    check=false;
                    break;
                }
            }
            if(check){
                bw.write("SAME\n");
            }

            bw.flush();
        } // 테케 끝
        bw.close();
        br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWl0ZQ8qn7UDFAXz&categoryId=AWl0ZQ8qn7UDFAXz&categoryType=CODE&problemTitle=%EC%95%88%EA%B2%BD%EC%9D%B4&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
/*
입력
5
ABCD EFGH
ABCD PBZO
PRQO OQAD
ZXCV HJKL
BBBB BBB
출력

#1 DIFF
#2 SAME
#3 SAME
#4 SAME
#5 DIFF
*/