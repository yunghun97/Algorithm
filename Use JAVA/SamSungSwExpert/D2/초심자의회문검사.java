package SamSungSwExpert.D2;
import java.io.*;

public class 초심자의회문검사 {     //테케, + 문자열 입력하면 됩니다. ex) samsung, level
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            String input = br.readLine();
            int answer ;
            StringBuilder sb = new StringBuilder();
            if(input.length()%2==0){
                if(input.substring(input.length()/2, input.length()).equals(sb.append(input.substring(0, input.length()/2)).reverse().toString())){
                        answer =1;
                    }
                else{
                        answer  =0;
                    }
            }
            else{
                if(input.substring(input.length()/2+1, input.length()).equals(sb.append(input.substring(0, input.length()/2)).reverse().toString())){
                    answer  =1;
                }
                else{
                    answer  =0;
                }
            }
            
            sb.setLength(0);
            System.out.printf("#%d %d\n",t,answer);
        }
    }
}
