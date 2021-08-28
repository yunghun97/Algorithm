package SamSungSwExpert.D2;
import java.io.*;
public class 패턴마디의길이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int answer=0;
        for(int t=1; t<=T; t++){
            bw.write("#"+t+" ");
            String input = br.readLine();
            for(int i=1; i<input.length(); i++){
                for(int j=0; j<i; j++){
                    sb.append(input.charAt(j));
                    temp.append(input.charAt(j+i));
                }
                if(sb.toString().equals(temp.toString())){
                    answer = i;
                    bw.write(""+answer+"\n");
                    break;
                }
                sb.setLength(0);
                temp.setLength(0);
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P1kNKAl8DFAUq&categoryId=AV5P1kNKAl8DFAUq&categoryType=CODE&problemTitle=%EB%A7%88%EB%94%94%EC%9D%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
/*
입력
3       
KOREAKOREAKOREAKOREAKOREAKOREA
SAMSUNGSAMSUNGSAMSUNGSAMSUNGSA
GALAXYGALAXYGALAXYGALAXYGALAXY     
출력
#1 5
#2 7
#3 6

*/
