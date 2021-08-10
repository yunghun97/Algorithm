package BackJun.Silver;


import java.io.*;
import java.util.StringTokenizer;
public class S2색종이2563 {
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S5색종이2563txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int r,c;
        int T = Integer.parseInt(br.readLine());
        int answer = 0;
        boolean[][] map = new boolean[100][100];            // boolean 형 배열 100*100으로 색종이가 위치한 칸 true로 바꾸고 마지막에 true칸 갯수를 센다.
        for(int t=0; t<T; t++){
            st= new StringTokenizer(br.readLine()," ");
            r = Integer.parseInt(st.nextToken());
            c= Integer.parseInt(st.nextToken());
            for(int x=0; x<10; x++){
                for(int y=0; y<10; y++){
                    if(map[r+x][c+y]) continue;
                    map[r+x][c+y]=true;
                    answer++;
                }
            } 
        }
        
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}