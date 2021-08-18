package SamSungSwExpert.D3;
import java.io.*;
import java.util.StringTokenizer;
public class 수의새로운연산 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int temp1 =0,temp2=0,i=0,j=0;  
            //1,n이 최대 좌표
            int x1=0, x2=0, y1=0, y2=0;
            while(temp1<a){
                i++;
                temp1+=i;
            }
            int R1 = 1, R2 = i;
            if(temp1==a){
                x1=1; y1=i;
            }
            else{
            while(temp1!=a){
                temp1--;
                R1++; R2--;
            }
            x1 = R1; y1= R2;
        }           // 좌표 1저장
            while(temp2<b){
                j++;
                temp2+=j;   
            }
            R1 = 1; R2 = j;
            if(temp2==b){
                x2=1; y2=j;
            }else{
                while(temp2!=b){
                    temp2--;
                    R1++; R2--;
                }
                x2= R1; y2= R2;
            } // 좌표 2 저장


            int resultX = x1+x2;
            int resultY = y1+y2;
            int result=1;
            for(int x=1; x<=resultX; x++){  // 처음위치 1으로 되고 2번째는 +1 3번째는 +2 4번째는 +3의 규칙을 가진다.
                result+=x-1;
            }
            int temp =1;
            for(int y=1; y<resultY; y++){   // 왼쪽 좌표값 +1 +2 +3 형태임
                result+=resultX+temp;
                temp++;
            }
            bw.write("#"+t+" "+result+"\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV2b-QGqADMBBASw&categoryId=AV2b-QGqADMBBASw&categoryType=CODE&problemTitle=1493&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&