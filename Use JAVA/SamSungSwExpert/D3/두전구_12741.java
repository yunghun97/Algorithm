package SamSungSwExpert.D3;

import java.util.*;
import java.io.*;
public class 두전구_12741 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T;  t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int min = Math.max(a, c);
            int max = Math.min(b, d);
            int answer = 0;
            if(max-min>=0){
                answer = max-min;
            }
            
            bw.write("#"+t+" "+answer+"\n");
        }   // 테케 끝
        bw.flush();
    }
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=3&contestProbId=AXuUo_Tqs9kDFARa&categoryId=AXuUo_Tqs9kDFARa&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=3&pageSize=10&pageIndex=1