package 코딩테스트문제.현대엔지비;

import java.io.*;


public class 하반기2021_1번
{
    public static void main(String args[] )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input =  br.readLine();
        String odd = "RUD";
        String even = "LUD";
        boolean check = false;
        for(int i=1; i<=input.length(); i++){
            if(i%2==0){ 
                if(even.contains(String.valueOf(input.charAt(i-1)))) continue;
                System.out.println(even.contains(String.valueOf(input.charAt(i))));
                bw.write("No");
                check = true;
                break;
            }else{
                if(odd.contains(String.valueOf(input.charAt(i-1)))) continue;
                bw.write("No");
                check = true;
                break;
            }
        }
        if(!check){
            bw.write("Yes");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}