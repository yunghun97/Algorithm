package SamSungSwExpert.D3;
import java.io.*;
import java.util.*;

public class 부먹왕국의차원관문 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
        st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        int dis = Integer.parseInt(st.nextToken());
        int[] arr = new int[city];
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i=0; i<city; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(arr[0]==0){
            arr[0]=1;
            answer++;
        }
        if(arr[city-1]==0){
            arr[city-1]=1;
            answer++;
        }
        int cnt = 0;
        for(int i=0; i<city; i++){
            if(arr[i]==1){
                cnt=0;
            }else{
                cnt++;
                if(cnt==dis){
                    answer++;
                    cnt=0;
                }
            }
        }
        bw.write("#"+t+" "+answer+"\n");
        bw.flush();
        }
        bw.close();
        br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWuSgKpqmooDFASy&categoryId=AWuSgKpqmooDFASy&categoryType=CODE&problemTitle=%EB%B6%80%EB%A8%B9&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1