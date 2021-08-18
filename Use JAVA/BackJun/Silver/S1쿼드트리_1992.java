package BackJun.Silver;
import java.io.*;
public class S1쿼드트리_1992 {
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); 
        map = new int[N][N];
        for(int i=0; i<N; i++){
            sb.append(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(sb.toString().substring(j,j+1));
            }
            sb.setLength(0);
        }
        cal(0,0,N); 
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void cal(int r, int c, int len){
        if(possible(r, c, len)){        // 해당 박스의 칸 숫자가 모두 같은지 아닌지 확인 -> 아니면 내려가서 반으로 쪼개서 계속 재귀로 돌린다.
            sb.append(map[r][c]);       // 해당 숫자가 다 똑같으면 해당 숫자 출력
            return;
        }

        sb.append("(");  // 한 번 쪼개질 때 마다 ( 가 출력된다.

        len /= 2;       // 계속 반으로 쪼개준다. -> 1이 되면 possible에서 자기자신과 비교하게 되므로 알아서 해당숫자가 출력된다.
        cal(r, c, len);    // 1사분면
        cal(r, c+len, len); // 2사분면
        cal(r+len, c, len); // 3사분면
        cal(r+len, c+len, len); // 4사분면
        
        sb.append(")");   // 한 번 다 돌면 )로 닫아준다.
    }

    static boolean possible(int r, int c, int len){ // 젤 처음 행, 젤 처음 열, 네모의 길이 매개변수로 전달.
        int temp = map[r][c];   // 시작위치 int변수에 저장

        for(int x=r; x<r+len; x++){ //시작 행 위치부터 len 길이만큼 돌아준다.
            for(int y=c; y<c+len; y++){ // 시작 열 위치부터 +len 길이만큼 돌아준다.
                if(map[x][y]!=temp) return false;   // 다르면 종료 -> 다시 쪼개지게 된다.
            }
        }
        return true;   //만족했으므로 쪼개지지않고 현재 숫자를 쓰게된다.
    }
}
//https://www.acmicpc.net/problem/1992