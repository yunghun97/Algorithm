package SamSungSwExpert.D3;

import java.io.*;
import java.util.*;
public class 저수지의물의총깊이구하기_7236 {
    static int[] dx ={-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\저수지의물의총깊이구하기_7236.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int size = Integer.parseInt(br.readLine());
            boolean[][] map = new boolean[size][size];  // W일 떄 True
            for(int i=0; i<size; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<size; j++){
                    if(st.nextToken().charAt(0)=='W'){
                        map[i][j]=true;
                    }
                }
            }
            int answer= 0;
            outer : for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(map[i][j]){
                        int temp =0;
                        for(int d=0; d<8; d++){
                            int nr = i+dx[d];
                            int nc = j+dy[d];
                            if(nr<0||nr>=size||nc<0||nc>=size) continue;
                            
                            if(map[nr][nc]) temp++;
                        }
                        if(temp==0) temp =1;
                        answer = Math.max(temp,answer);
                        if(answer==8) break outer;
                    }
                }
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }// 테케 끝
        bw.close();
        br.close();
    }
}
