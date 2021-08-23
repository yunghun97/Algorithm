package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G5암호만들기_1759 {
    static int[] input, answer;
    static int N,R;
    static BufferedWriter bw ;
    static boolean[] isSelected;
    // 모음 번호 0,4,8,14,20
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G5암호만들기_1759.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        input = new int[N];
        answer = new int[R];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = st.nextToken().charAt(0)-97;
        }
        Arrays.sort(input);
        
        combi(0,-1);
    }
    private static void combi(int cnt, int preNum) throws IOException {
        if(cnt==R){
            int count = 0; int countA =0;
            for(int y=0; y<cnt; y++){
                if(answer[y]==0||answer[y]==4||answer[y]==8||answer[y]==14||answer[y]==20){
                     countA++; continue;
                }
                count++;
            }
            if(countA>=1&&count>=2){
            for(int x=0; x<cnt; x++){
                bw.write((char)(answer[x]+97));
            }
            bw.newLine();
            bw.flush();
            return;
            }else return;
        }
        for(int i=0; i<N; i++){
            if(isSelected[i]||input[i]<preNum) continue;

            answer[cnt] = input[i];
            isSelected[i]=true;
            combi(cnt+1,input[i]);
            isSelected[i]=false;
        }
    }
}



//https://www.acmicpc.net/problem/1759