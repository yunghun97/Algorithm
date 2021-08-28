package BackJun.Silver;
import java.io.*;
public class S3단어뒤집기2_17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] arr = input.split(" ");    // " "로 나누어서 배열 만들기
        boolean check = false;
        StringBuilder tempSb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length(); j++){
                
                char a = arr[i].charAt(j);
                if(a =='<'){        // <가 나올 때 이전에 저장해놨던 글자들 반대로 bw 입력버퍼에 저장 (저장된 단어가 있을 경우에만) 
                    if(tempSb.length()>=1) bw.write(tempSb.reverse().toString());
                    tempSb.setLength(0);    // Tempsb 초기화
                    check = true;   // <상태임을 알려준다
                }else if(a=='>'){
                    check = false;
                    bw.write(a);
                    continue;
                }

                if(!check){     // < 상태가 아니면 글자 tempSb에 저장
                     tempSb.append(a);
                }else{          // <인 상태이므로 < bw에 저장
                    bw.write(a);    
                }

            }
            if(tempSb.length()>=1){ bw.write(tempSb.reverse().toString());  // 괄호가 안 나온 경우 bw에 전체 문자열 반대로 저장
            tempSb.setLength(0);} //초기화
            bw.write(" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/17413
// 입력 <int><max>2147483647<long long><max>9223372036854775807
// 출력 <int><max>7463847412<long long><max>7085774586302733229