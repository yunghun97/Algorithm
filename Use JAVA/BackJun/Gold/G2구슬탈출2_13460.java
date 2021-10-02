package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G2구슬탈출2_13460 {
    static int R,C;
    static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        Red red = new Red(0,0);
        Blue blue = new Blue(0,0);
        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                char tmp = input.charAt(j);
                if(tmp=='R'){
                    red.r = i;
                    red.c = j;
                }
                if(tmp=='B'){
                    blue.r = i;
                    blue.c = j;
                }
                map[i][j] = tmp;
            }
        }
        
    }

    static class Red{
        int r;
        int c;
        public Red(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
    static class Blue{
        int r;
        int c;
        public Blue(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
}
