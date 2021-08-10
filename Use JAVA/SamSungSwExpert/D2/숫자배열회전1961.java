package SamSungSwExpert.D2;

import java.io.*;
import java.util.StringTokenizer;
public class 숫자배열회전1961 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D2\\숫자배열회전.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T= Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int size = Integer.parseInt(br.readLine());
            int[][] input = new int[size][size];
            for(int i=0; i<size; i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0; j<size; j++){
                    input[i][j]= Integer.parseInt(st.nextToken());
                }
            }
            int temp= size;
            int tm =-1;
            bw.write("#"+t+"\r\n");
            for(int x=0; x<size; x++){              // 사이즈 만큼 반복
                temp--;
                tm++;
                    for(int i=size-1; i>=0; i--){   // 첫번째 조건 ex -> 2,0 1,0 0,0 -> 2,1 1,1 0,1
                        bw.write(String.valueOf(input[i][tm]));
                    }
                    bw.write(" ");
                    for(int i=size-1; i>=0; i--){   // 두번째 조건 ex -> 2,2 2,1 2,0 -> 1,2 1,1 1,0
                        bw.write(String.valueOf(input[temp][i]));
                    }
                    bw.write(" ");
                    for(int i=0; i<size; i++){      // 세번째 조건 ex -> 0,2 1,2 2,2 -> 0,1 1,1 2,1
                        bw.write(String.valueOf(input[i][temp]));
                }
                bw.write("\r\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
        
    }
}
