package SamSungSwExpert.D3;
import java.io.*;
import java.util.StringTokenizer;
public class 햄버거다이어트 {           // 부분집합으로 푸는것
    static int[] score, cal;
    static int ingreCount, maxCal,answer,temp;
    static boolean[] isSelected;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\햄버거다이어트.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            ingreCount = Integer.parseInt(st.nextToken());
            maxCal = Integer.parseInt(st.nextToken());
            isSelected = new boolean[ingreCount];
            answer =0; temp=0;
            score =new int[ingreCount];
            cal = new int[ingreCount];
            
            for(int i=0; i<ingreCount; i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
            sum(0);
            bw.write("#"+t+" "+answer);
            bw.write("\r\n");
            bw.flush();
        }
        bw.close();
        br.close();
        }
    static void sum(int cnt){
        int caloly =0;
        if(cnt==ingreCount){        // 마지막 원소에 도달 했을때
            for(int i=0; i<ingreCount; i++){    // 첨부터 끝까지 돌려준다.
                if(isSelected[i]) {   // 선택되었으면
                    caloly +=cal[i];    // 칼로리를 계산
                    if(caloly>maxCal){  // 총합보다 크면 + 안하고 그자리에서 점수 계산
                        break;
                    }
                    else{
                       temp+=score[i];  // 작으면 점수 더하기
                    }
                }
                else continue;
                
            }
            answer = Math.max(answer, temp);    // 점수 계산하기
            temp =0;
            return;
        }

        isSelected[cnt] =true;          // 모든 재료가 부분집합으로 돈다.
        sum(cnt+1);
        isSelected[cnt] = false;
        sum(cnt+1);
    }
}
