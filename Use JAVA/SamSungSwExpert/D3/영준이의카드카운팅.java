package SamSungSwExpert.D3;

import java.io.*;

public class 영준이의카드카운팅 {
    static String input;
    static BufferedWriter bw;
    static boolean[] SArr, DArr, CArr, HArr;
    static int s,d,c,h;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            bw.write("#"+t+" ");
            s = d = c = h = 13;
            SArr = new boolean[14];
            DArr = new boolean[14];
            CArr = new boolean[14];
            HArr = new boolean[14];    
            input = br.readLine();
            cal();

            bw.flush();
        }

    }
    static void cal() throws IOException{
        for(int i=0; i<input.length(); i+=3){
            char pattern = input.charAt(i);
            int ten = (int)input.charAt(i+1)-48;
            int one = (int)input.charAt(i+2)-48;
            if(pattern=='S'){
                if(ten==1){
                    if(SArr[10+one]){
                        bw.write("ERROR\n");
                        return;
                    } 
                    SArr[10+one] = true;
                }else{

                if(SArr[one]){
                    bw.write("ERROR\n");
                    return;
                }
                SArr[one] = true;
                }
            }else if(pattern=='D'){
                if(ten==1){
                    if(DArr[10+one]){
                        bw.write("ERROR\n");
                        return;
                    } 
                    DArr[10+one] = true;
                }else{
                if(DArr[one]){
                    bw.write("ERROR\n");
                    return;
                }
                DArr[one] = true;
            }
            }else if(pattern=='C'){
                if(ten==1){
                    if(CArr[10+one]){
                        bw.write("ERROR\n");
                        return;
                    } 
                    CArr[10+one] = true;
                }else{
                if(CArr[one]){
                    bw.write("ERROR\n");
                    return;
                }
                CArr[one] = true;
                }

            }else{
                if(ten==1){
                    if(HArr[10+one]){
                        bw.write("ERROR\n");
                        return;
                    } 
                    HArr[10+one] = true;
                }else{
                if(HArr[one]){
                    bw.write("ERROR\n");
                    return;
                }
                HArr[one] = true;
                }
            }
        }
        check();

    }
    private static void check() throws IOException{
        for(int i=1; i<=13; i++){
            if(SArr[i]) s--;
            if(DArr[i]) d--;
            if(HArr[i]) h--;
            if(CArr[i]) c--;
        }
        bw.write(""+s+" "+d+" "+h+" "+c+"\n");
    }
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIsY84KEPMDFAWN

/*
입력
3
S01D02H03H04
H02H10S11H02
S10D10H10C01 
출력
#1 12 12 11 13
#2 ERROR
#3 12 12 12 12 
*/
