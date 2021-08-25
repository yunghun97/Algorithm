package BackJun.Silver;

import java.io.*;
// 입력 ljes=njak 출력 -> 6
public class S5크로아이타알파벳_2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] cArr = new String[8];
        cArr[0] = "c=";
        cArr[1] = "c-";
        cArr[2] = "dz=";
        cArr[3] = "d-";
        cArr[4] = "lj";
        cArr[5] = "nj";
        cArr[6] = "s=";
        cArr[7] = "z=";
        int answer=0;
        sb.append(br.readLine());
        int size = sb.toString().length();
        for(int x=0; x<size; x++){
        for(int i=0; i<8; i++){
            String temp = cArr[i];  // 8번 비교해서 있으면 answer++하고 다음 탐색하러 break; 
            if(i!=2){
                if(x+1<size){
                if(temp.equals(sb.toString().substring(x, x+2))){
                    answer++; x++; break;
                }
            }}
            else if(i<8){
                if(x+2<size){
                    if(temp.equals(sb.toString().substring(x, x+3))){
                        answer++; x+=2; break;
                    }

            }}
            if(i==7) answer++; // break 되지 않았으므로 일치하는 문자가 없음 = +1 해준다.
        }
    }
        System.out.println(answer);
    }
}
//https://www.acmicpc.net/problem/2941