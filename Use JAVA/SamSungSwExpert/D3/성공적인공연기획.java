package SamSungSwExpert.D3;

import java.io.*;

public class 성공적인공연기획 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
        int now  = 0; int answer = 0;
        String input = br.readLine();
        int[] arr = new int[input.length()];
        for(int i=0; i<arr.length; i++){
            arr[i] = input.charAt(i)-48;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i]==0){   // 0 일 때

            }else{      // 1이상 떄
                if(i>now){
                    answer += i-now;
                    now += i-now+arr[i];
                }else{
                    now+=arr[i];
                }
            }
        }
        bw.write("#"+t+" "+answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
