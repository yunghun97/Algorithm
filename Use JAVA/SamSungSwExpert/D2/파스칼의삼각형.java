package SamSungSwExpert.D2;

import java.io.*;

public class 파스칼의삼각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=1; t<=T; t++){
            int[] arr = new int[10];
            int[] swap = new int[10];
            int size = Integer.parseInt(br.readLine());
            arr[0] = 1;
            swap[0] = 1;
            bw.write("#"+t+"\n");
            for(int i=0; i<size; i++){
                
                for(int j=0; j<i+1; j++){
                    if(j>=1&&j<10) swap[j] =arr[j]+arr[j-1]; 
                    bw.write(""+swap[j]+" ");
                    
                }
                for(int j=0; j<i+1; j++){
                    arr[j]=swap[j];
                }
                bw.newLine();
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }

}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P0-h6Ak4DFAUq&categoryId=AV5P0-h6Ak4DFAUq&categoryType=CODE&problemTitle=%ED%8C%8C%EC%8A%A4%EC%B9%BC&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1

/*
입력
1
4

출력
1
1 1
1 2 1
1 3 3 1
*/