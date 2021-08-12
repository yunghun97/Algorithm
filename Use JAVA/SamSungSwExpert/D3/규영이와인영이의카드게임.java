package SamSungSwExpert.D3;

import java.io.*;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임 {
    static int[] Gyu, InYeong, submit;
    static int N,R,Win,Loose;
    static boolean[] check;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\규영이와인영이의카드게임.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            Gyu = new int[9];
            InYeong = new int[9];
            check = new boolean[19];
            submit = new int[9];
            N=9; Win=0; Loose =0;
            int tm=0;
            st= new StringTokenizer(br.readLine());
            for(int i=0; i<9; i++){
                int temp = Integer.parseInt(st.nextToken());
                Gyu[i] = temp;
                check[temp] = true;
            }
            for(int i=1; i<check.length; i++){
                if(!check[i]){InYeong[tm++]=i;}
            }
            Permutation(0,0);
            bw.write("#"+t+" "+Win+" "+Loose);
            bw.newLine();
            bw.flush();
        }//테케 끝
        bw.close();
        br.close();
    }
    private static void Permutation(int cnt, int flag) {
        
        if(cnt==N){
            int tempGyu=0;
            int tempIn =0;
            for(int i=0; i<N; i++){
                if(Gyu[i]>submit[i]){
                    tempGyu+=Gyu[i]+submit[i];
                }
                else if(Gyu[i]<submit[i]){
                    tempIn+=Gyu[i]+submit[i];
                }
                else continue;
            }
            if(tempGyu>tempIn) Win++;
            else if(tempIn>tempGyu) Loose++;
            return;
        }
        for(int i=0; i<N; i++){             //flag는 32비트 isSelected배열 느낌
            if((flag&1<<i)!=0)continue;  // 둘다 같으면 1이 나옴 -> 중복이라는 소리

            submit[cnt]=InYeong[i];
            Permutation(cnt+1,flag | 1<<i); // flag= 011 i00 -> 111
        }
    }  
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWgv9va6HnkDFAW0&categoryId=AWgv9va6HnkDFAW0&categoryType=CODE&problemTitle=%EA%B7%9C%EC%98%81%EC%9D%B4&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1