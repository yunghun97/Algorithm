package SamSungSwExpert.D3;
import java.io.*;
import java.util.StringTokenizer;
public class 햄버거다이어트개선 {           // 배열로 계산안하고 매개변수로 계산바로 하기
    static int[] score, cal;
    static int ingreCount, maxCal,answer,temp;
    static boolean[] isSelected;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\햄버거다이어트.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            ingreCount = Integer.parseInt(st.nextToken());
            maxCal = Integer.parseInt(st.nextToken());
            isSelected = new boolean[ingreCount];
            answer =0; temp=0;
            score =new int[ingreCount];
            cal = new int[ingreCount];
            
            for(int i=0; i<ingreCount; i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            sum(0,0,0);
            bw.write("#"+t+" "+answer);
            bw.write("\r\n");
            bw.flush();
        }
        bw.close();
        br.close();
        }
    static void sum(int cnt,int scoreSum, int caloly){
        if(caloly>maxCal) return;
        else if(cnt==ingreCount){
            answer = Math.max(scoreSum, answer);
            return;
        }
        sum(cnt+1, scoreSum+score[cnt], caloly+cal[cnt]);
        sum(cnt+1, scoreSum,caloly);
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWT-lPB6dHUDFAVT&categoryId=AWT-lPB6dHUDFAVT&categoryType=CODE&problemTitle=%ED%96%84%EB%B2%84%EA%B1%B0&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1