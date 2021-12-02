package Softeer2021모의알고리즘코딩대회;

import java.util.*;
import java.io.*;

// 세포분열 4 -> 2,2 -> 1,1,1,1
// 분열하면 에너지 1 발생
public class test1
{
    static long answer;
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        answer = 0 ;
        cal(n);
        bw.write(""+answer);
        bw.flush();
    }
    static void cal(long size){
        if(size==0) return;
        long tmp = size;
        long plus = 1;
        while(tmp>=1){
            answer+=plus;
            plus*=2;
            tmp/=2;
        }
        
    }
}