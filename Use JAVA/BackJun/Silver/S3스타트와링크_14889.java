package BackJun.Silver;
import java.io.*;
import java.util.*;
public class S3스타트와링크_14889 {
    static int N,R,answer;
    static int[][] map,data;
    static boolean isSelected[];
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Silver\\S1링크와스타트_15661.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        R = N/2;
        map = new int[N][N];
        answer = Integer.MAX_VALUE;
        isSelected = new boolean[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        combi(0,0);
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void combi(int cnt, int start) {
        if(answer==0) return;
        if(cnt==R){
            answer =Math.min(cal(),answer);
            return;
        }
        for(int i=start; i<N; i++){
            isSelected[i] = true;
            combi(cnt+1, i+1);
            isSelected[i] = false;
        }
    }
    private static int cal() {
        int aSum =0; int bSum =0;
        for(int i=0; i<N; i++){
            if(isSelected[i])
            for(int j=0; j<N; j++){
                if(isSelected[j]) aSum+=map[i][j];
            }else{
                for(int j=0; j<N; j++){
                    if(!isSelected[j]) bSum+=map[i][j];
                }
            }
        }
        return Math.abs(aSum-bSum);
    }
}
