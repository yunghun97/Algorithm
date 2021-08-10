package BackJun.Silver;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;

public class abc {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S2소가길을건너간이유5_14465.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int normal = Integer.parseInt(st.nextToken());
        int error = Integer.parseInt(st.nextToken());
        int[] map = new int[size+1];
        int[] tempArr = new int[size+1];
        int answer = 0;
        int temp = Integer.MIN_VALUE;
        for(int i=0; i<error; i++){
            map[Integer.parseInt(br.readLine())] = 1;   // 고장난거
        }
        for(int i=1; i<=size; i++){
            if(map[i]==1){
                if(map[i-1]==1){
                if(answer==0){
                    tempArr[i]=0;
                }
                else{
                    tempArr[i]=--answer;
                }
            }
                else{
                    tempArr[i]=answer;
                }
            }
            else{
                tempArr[i]= ++answer;
            }
        }
        for(int i=1; i<=size; i++){
            temp = Math.max(temp, tempArr[i]);
        }
        if(normal-temp<0) temp=0;
        else temp = normal-temp;
        bw.write(String.valueOf(temp));
        bw.flush();
        bw.close();
        br.close();
    }
}
