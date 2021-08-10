package SamSungSwExpert.D3;

import java.io.*;
import java.util.StringTokenizer;
public class 한빈이와SpotMart9229재귀 {
    static int N,sum,result, temp, R=2;
    static int[] input, answer;
    public static void main(String[] args) throws FileNotFoundException, IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\한빈이와SpotMart9229.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            result = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            sum = Integer.parseInt(st.nextToken());
            input = new int[N];
            answer = new int[2];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            combi(0,0,0);
            bw.write("#"+t+" "+(result<0 ? -1 : result) +"\r\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
    static void combi(int cnt, int start,int nowSum){
        if(nowSum >sum){
            return;
        }
        if(cnt==2){
            result = Math.max(result, nowSum);
            return;
        }
        for(int i=start; i<N; i++){
            answer[cnt] += input[i];
            combi(cnt+1,i+1, nowSum+input[i]);   // 조합형태에 매개변수 추가로 현재 과자 무게 전달
        }
    }
}
