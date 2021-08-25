package BackJun.Gold;
import java.io.*;
public class G5적록색약_10026 {     //DFS 탐색한다.
    static char[][] map;
    static boolean[][] normalMap, blindMap;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static int size, bAnswer, nAnswer;
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G5적록색약_10026.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(br.readLine());
        map = new char[size][size];
        normalMap = new boolean[size][size];
        blindMap = new boolean[size][size];
        for(int i=0; i<size; i++){
            map[i] = br.readLine().toCharArray();
        }
        bAnswer = 0; nAnswer =0;
        person(size);
        blind(size);
        bw.write(""+nAnswer+" "+bAnswer);
        bw.flush();
        bw.close();
        br.close();
    }
    private static void person(int N) {     // 일반사람
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!normalMap[i][j]){
                    nAnswer++;
                    if(map[i][j]=='R') checkNormal(i, j, 'R');
                    else if(map[i][j]=='B') checkNormal(i, j, 'B');
                    else checkNormal(i, j, 'G');
                }
                }

            }

    }
    private static void blind(int N) {  // 색약
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!blindMap[i][j]){
                    bAnswer++;
                    if(map[i][j]=='R'||map[i][j]=='G') checkBlind(i,j,'R','G');
                    else checkBlind(i, j, 'B','B');
                }
                }

            }
    }
    

    private static void checkBlind(int i, int j, char letter1, char letter2) {  // 색약이면 R G 일 경우 R G를 전달 ->(R과 G를 통합해서 1개로 넘겨도 됨) -> 통합하면 메소드 한개로 가능
        for(int d=0; d<4; d++){
            int nr = i+dx[d];
            int nc = j+dy[d];
            if(nr<0||nr>=size||nc<0||nc>=size) continue;
            if(!blindMap[nr][nc]&&(map[nr][nc]==letter1||map[nr][nc]==letter2)){
                blindMap[nr][nc] = true; checkBlind(nr, nc, letter1, letter2);
            }

        }
        return;
    }
    private static void checkNormal(int i, int j, char letter) {    // 일반사람 계산
        for(int d=0; d<4; d++){
            int nr = i+dx[d];
            int nc = j+dy[d];
            if(nr<0||nr>=size||nc<0||nc>=size) continue;
            if(!normalMap[nr][nc]&&(map[nr][nc]==letter)){
                normalMap[nr][nc] = true; checkNormal(nr, nc, letter);
            }

        }
        return;
    }
}