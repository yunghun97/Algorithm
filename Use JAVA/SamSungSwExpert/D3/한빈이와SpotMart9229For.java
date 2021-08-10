package SamSungSwExpert.D3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
public class 한빈이와SpotMart9229For {
    static int N,sum,result, R=2;
    static int[] input;
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
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                input[i] = Integer.parseInt(st.nextToken());
            }
            int answer =0;
            int temp =0;
            Arrays.sort(input);
            for(int i=input.length-1; i>0; i--){            // 시간 복잡도 N^2 잘하면 더 줄일 수 있을 듯
                for(int j=i-1; j>=0; j--){
                    temp += input[i]+input[j];
                    if(temp>sum){
                        temp =0;
                        continue;
                    }
                    else{
                        answer = Math.max(answer,temp);
                        temp =0;
                    }
                }
            }
            if(answer==0) answer = -1;      // answer ==0이라는건 위에 else조건이 한번도 실행 안됬다는 뜻
            bw.write("#"+t+" "+answer+"\r\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
