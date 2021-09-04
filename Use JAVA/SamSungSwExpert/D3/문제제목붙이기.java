package SamSungSwExpert.D3;
import java.io.*;
public class 문제제목붙이기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int repeat = Integer.parseInt(br.readLine());
            
            int arr[] = new int[26];
            for(int i=0; i<repeat; i++){
                arr[br.readLine().charAt(0)-65]++;
            }
            int answer=0;
            for(int i=0; i<26; i++){
                if(arr[i]==0) break;
                answer++;
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWkIdD46A5EDFAXC&categoryId=AWkIdD46A5EDFAXC&categoryType=CODE&problemTitle=%EB%AC%B8%EC%A0%9C+%EC%A0%9C%EB%AA%A9&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
