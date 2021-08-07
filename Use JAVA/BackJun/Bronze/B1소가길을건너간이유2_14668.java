package BackJun.Bronze;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;

public class B1소가길을건너간이유2_14668 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Bronze\\B1소가길을건너간이유2_14668.txt"));
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int answer =0;
        int temp ;
        int[][] cowCheck = new int[26][2];
        char[] input = br.readLine().toCharArray();
        for(int i=0; i<52; i++){
            temp = input[i]-'A';            // A는 0번지부터 해서 해당 배열이 0이면 처음 등장하므로 i값이 출발점이 된다.
            if(cowCheck[temp][0]==0){
                cowCheck[temp][0] = i+1;  // 1번 순서 + 다시 체크할때 0이면 안되므로 처음 시작 값을 1부터 시작하도록 해준다.
            }
            else{
                cowCheck[temp][1] = i+1;
            }
        }
        for(int x=0; x<26; x++){
            for(int y=0; y<26; y++){
                // ACCBAB 이므로 A보다 시작점이 더 느리고 A종료점보다 시작점이 더 빠르고 
                // A종료점보다 종료점이 더 느린 것을 찾기 위한 조건
                if(cowCheck[x][0]<cowCheck[y][0]&&cowCheck[x][1]>cowCheck[y][0]&&cowCheck[x][1]<cowCheck[y][1]) answer++;   
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
}
}
